package com.example.orderservice.service.order;

import com.example.orderservice.config.StreamHandler;
import com.example.orderservice.mapper.OrderMapper;
import com.example.orderservice.model.Order;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.service.TimestampService;
import org.example.commondtos.dto.OrderDTO;
import org.example.commondtos.dto.UserJwtDTO;
import org.example.commondtos.enums.OrderStatus;
import org.example.commondtos.event.OrderEvent;
import org.example.commondtos.exception.BusinessLogicException;
import org.example.commondtos.exception.NoSuchEntityException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.time.LocalTime;
import java.util.HashMap;

@Service
public class ConsumerOrderService extends OrderService {

    private final RabbitTemplate rabbitTemplate;
    private final StreamHandler streamHandler;
    private final OrderMapper orderMapper;

    public ConsumerOrderService(RabbitTemplate rabbitTemplate, StreamHandler streamHandler, OrderMapper orderMapper, OrderRepository orderRepository, TimestampService timestampService) {
        super(orderRepository, timestampService);
        this.rabbitTemplate = rabbitTemplate;
        this.streamHandler = streamHandler;
        this.orderMapper = orderMapper;
    }


    public Order createOrder(OrderDTO orderDTO, UserJwtDTO userJwtDTO) {

        Order order = orderMapper.toEntity(orderDTO);
        order.setUserId(userJwtDTO.getId());
        order.setOrderStatus(OrderStatus.CREATED);

        if (!timestampService.getClosingTimeByRestaurantIdRequest(order.getRestaurantId()).isAfter(LocalTime.now()))
            throw new BusinessLogicException("Ресторан уже закрыт " + LocalTime.now());

        var validDishIds = new HashMap<Long, Integer>();

        timestampService.extractValidDishesRequest(order.getRestaurantId(), order.getDishQuantityMap().keySet())
                .forEach(id -> validDishIds.put(id, order.getDishQuantityMap().get(id)));

        order.setDishQuantityMap(validDishIds);

        if (order.getDishQuantityMap().isEmpty())
            throw new NoSuchEntityException("Не выбрано ни одного блюда");

        Order orderResult = orderRepository.save(order);
        rabbitTemplate.convertAndSend("order", "orderKey", Mono.fromRunnable(() -> new OrderEvent(orderResult.getId(), order.getUserId(), order.getOrderStatus())));

        return orderResult;
    }

    @Transactional
    public Order cancelOrder(Long orderId) {

        Order order = getOrderById(orderId);
        order.setOrderStatus(OrderStatus.CANCELED);

        streamHandler.cancelOrder(new OrderEvent(order.getId(), order.getUserId(), order.getOrderStatus()));

        return order;

    }


}
