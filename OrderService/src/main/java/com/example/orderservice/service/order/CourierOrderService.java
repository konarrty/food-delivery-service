package com.example.orderservice.service.order;

import com.example.orderservice.model.Order;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.service.TimestampService;
import com.example.orderservice.service.gRPC.CourierGrpcService;
import org.example.commondtos.dto.ActiveOrder;
import org.example.commondtos.enums.OrderStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourierOrderService extends OrderService {
    private final CourierGrpcService courierService;

    public CourierOrderService(OrderRepository orderRepository, TimestampService timestampService, CourierGrpcService courierGrpcService) {
        super(orderRepository, timestampService);
        this.courierService = courierGrpcService;
    }

    public List<ActiveOrder> getActiveOrders() {

        return getAllOrders().stream().filter(order -> (order.getOrderStatus().equals(OrderStatus.CREATED) || order.getOrderStatus().equals(OrderStatus.ACCEPTED)
                        || order.getOrderStatus().equals(OrderStatus.COMPLETED)) &&
                        !courierService.existCourierByOrderId(order.getId()))
                .map(this::mapToActiveOrder)
                .toList();
    }

    public List<ActiveOrder> getAllOrderByStatus(OrderStatus status) {

        return getAllOrders().stream().filter(order -> order.getOrderStatus().equals(status))
                .map(this::mapToActiveOrder)
                .toList();
    }

    @Transactional
    public Order updateOrderStatus(Long orderId, OrderStatus orderStatus) {

        Order order = getOrderById(orderId);
        order.setOrderStatus(orderStatus);

        return order;
    }


}
