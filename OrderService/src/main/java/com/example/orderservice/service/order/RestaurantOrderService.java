package com.example.orderservice.service.order;

import com.example.orderservice.model.Order;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.service.TimestampService;
import org.example.commondtos.dto.ActiveOrder;
import org.example.commondtos.enums.OrderStatus;
import org.example.commondtos.event.OrderEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RestaurantOrderService extends OrderService {

    private final RabbitTemplate rabbitTemplate;

    public RestaurantOrderService(OrderRepository orderRepository, TimestampService timestampService, RabbitTemplate rabbitTemplate) {
        super(orderRepository, timestampService);
        this.rabbitTemplate = rabbitTemplate;
    }

    public List<ActiveOrder> getActiveOrders(Long restaurantId) {

        return getAllOrders().stream().filter(order -> order.getRestaurantId().equals(restaurantId)
                        && (order.getOrderStatus().equals(OrderStatus.CREATED)))
                .map(this::mapToActiveOrder)
                .toList();
    }

    public List<ActiveOrder> getAllOrderByStatus(Long restaurantId, OrderStatus status) {

        return getAllOrdersByRestaurantIdAndStatus(restaurantId, status)
                .stream().map(this::mapToActiveOrder).toList();
    }


    @Transactional
    public Order updateOrderStatus(Long orderId, OrderStatus orderStatus) {

        Order order = getOrderById(orderId);
        order.setOrderStatus(orderStatus);
        rabbitTemplate.convertAndSend("order", "orderKey", new OrderEvent(orderId, order.getUserId(), orderStatus));
        return order;

    }
}
