package com.example.courierservice.config;

import com.example.courierservice.service.impl.CourierOrderService;
import lombok.RequiredArgsConstructor;
import org.example.commondtos.enums.OrderStatus;
import org.example.commondtos.event.CourierOrderEvent;
import org.example.commondtos.event.OrderEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;
import java.util.function.Supplier;

@Configuration
@RequiredArgsConstructor
public class CancelOrderConfig {

    private final CourierOrderService orderService;

    @Bean
    public Function<Flux<OrderEvent>, Flux<CourierOrderEvent>> paymentProcessor() {

        return a -> a.flatMap(this::processPayment);
    }

    private Mono<CourierOrderEvent> processPayment(OrderEvent orderEvent) {

        if (OrderStatus.CANCELED.equals(orderEvent.getOrderStatus())) {

            return orderService.cancelOrder(orderEvent);
        }
        return Mono.empty();
    }
}