package com.example.courierservice.consumer;

import com.example.courierservice.service.DeliveryOrderService;
import lombok.RequiredArgsConstructor;
import org.example.commondtos.enums.OrderStatus;
import org.example.commondtos.event.OrderEvent;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@EnableRabbit
@RequiredArgsConstructor
public class RabbitMQConsumerService {

    private final RabbitTemplate rabbitTemplate;
    private final DeliveryOrderService orderService;

//    @RabbitListener(queues = "order")
//    public void processOrderEvent(OrderEvent orderEvent) {
//
//        System.err.println(orderEvent);
//
//        if (orderEvent.getOrderStatus().equals(OrderStatus.CANCELED))
//            orderService.deleteDeliveryOrderByOrderId(orderEvent.getOrderId());
//
//    }

}