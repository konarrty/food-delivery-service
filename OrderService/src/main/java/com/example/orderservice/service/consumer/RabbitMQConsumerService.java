package com.example.orderservice.service.consumer;

import lombok.RequiredArgsConstructor;
import org.example.commondtos.dto.OrderDTO;
import org.example.commondtos.event.OrderEvent;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RabbitMQConsumerService {

    private final RabbitTemplate rabbitTemplate;

//    @RabbitListener(queues = "myQueue")
//    public void processMyQueue(OrderDTO orderDTO) {
//
////        OrderStatusDTO orderStatusDTO = orderService.createOrder(orderDTO);
////        rabbitTemplate.convertAndSend("customerOrderStatus", orderStatusDTO);
//    }
//    @RabbitListener(queues = "order")
//    public void processOrder(OrderEvent orderEvent) {
//
//        System.err.println(orderEvent.getOrderId());
//    }
}