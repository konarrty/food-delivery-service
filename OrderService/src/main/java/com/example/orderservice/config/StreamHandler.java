package com.example.orderservice.config;

import com.example.orderservice.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.example.commondtos.event.CourierOrderEvent;
import org.example.commondtos.event.OrderEvent;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;

import java.util.function.Function;
import java.util.function.Supplier;


@Configuration
public class StreamHandler {

    private FluxSink<OrderEvent> fluxSink;
    @Scope(scopeName = BeanDefinition.SCOPE_SINGLETON)
    @Bean
    public Function<Flux<CourierOrderEvent>, Mono<Void>> cancelOrderCompensate() {

        return event -> event.log().then();
    }

    @Scope(scopeName = BeanDefinition.SCOPE_SINGLETON)
    @Bean
    public Supplier<Flux<OrderEvent>> cancelOrder() {

        return () -> Flux.create(sink -> fluxSink = sink);

    }

    public void cancelOrder(OrderEvent orderEvent) {

        fluxSink.next(orderEvent);
    }
}
