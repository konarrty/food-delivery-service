package com.example.courierservice.service.impl;

import com.example.courierservice.service.DeliveryOrderService;
import lombok.RequiredArgsConstructor;
import org.example.commondtos.event.CourierOrderEvent;
import org.example.commondtos.event.OrderEvent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CourierOrderService {

    private final DeliveryOrderService orderService;

    @Transactional
    public Mono<CourierOrderEvent> cancelOrder(OrderEvent orderEvent) {

        return orderService.deleteDeliveryOrderByOrderId(orderEvent.getOrderId())
                .thenReturn(new CourierOrderEvent(orderEvent));
    }

}
