package com.example.restaurantservice.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
@EnableRabbit
@RequiredArgsConstructor
public class RabbitMQConsumer {

    private final ScheduledExecutorService taskExecutor;


}