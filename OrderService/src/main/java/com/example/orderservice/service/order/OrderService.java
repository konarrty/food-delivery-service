package com.example.orderservice.service.order;

import com.example.orderservice.model.Order;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.service.TimestampService;
import org.example.commondtos.dto.ActiveOrder;
import org.example.commondtos.dto.DishWithAmountDTO;
import org.example.commondtos.enums.OrderStatus;
import org.example.commondtos.exception.NoSuchEntityException;

import java.util.List;
import java.util.Map;


public abstract class OrderService {
    protected final OrderRepository orderRepository;
    protected final TimestampService timestampService;


    public OrderService(OrderRepository orderRepository, TimestampService timestampService) {
        this.orderRepository = orderRepository;
        this.timestampService = timestampService;
    }

    public List<Order> getAllOrders() {

        return orderRepository.findAll();
    }


    public Order getOrderById(Long orderId) {

        System.err.println(orderRepository.findAll());
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new NoSuchEntityException("Не существует заказа с таким id!"));
    }

    public List<Order> getAllOrdersByRestaurantIdAndStatus(Long restaurantId, OrderStatus status) {

        return orderRepository.findAllOrdersByRestaurantIdAndOrderStatus(restaurantId, status);
    }


    public ActiveOrder mapToActiveOrder(Order order) {

        ActiveOrder activeOrder = new ActiveOrder();
        activeOrder.setOrderId(order.getId());
        activeOrder.setRestaurantId(order.getRestaurantId());

        for (Map.Entry<Long, Integer> entry : order.getDishQuantityMap().entrySet())
            activeOrder.getDishes()
                    .add(new DishWithAmountDTO(
                            timestampService.getDishById(entry.getKey()),
                            entry.getValue()));

        return activeOrder;

    }

}
