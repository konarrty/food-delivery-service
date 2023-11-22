package com.example.clientnotificationservice.config;

import com.example.clientnotificationservice.dto.SubscriptionData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.commondtos.event.OrderEvent;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.ServerSentEvent;

import java.util.Map;
import java.util.function.Consumer;

@Slf4j
@EnableRabbit
@Configuration
@RequiredArgsConstructor
public class StreamConfig {

    private final Map<String, SubscriptionData> subscriptionsMap;

    @Bean
    public Consumer<OrderEvent> sse() {
        return orderEvent -> {
            var event = ServerSentEvent.builder("Order " + orderEvent.getOrderId() + " is " + orderEvent.getOrderStatus()).build();
            subscriptionsMap.get(orderEvent.getUserId()).fluxSink.next(event);

            log.info("Sending {} ", orderEvent.getOrderId());
        };
    }

}
