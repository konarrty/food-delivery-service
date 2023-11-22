package com.example.customerservice.consumer;

import com.example.customerservice.dto.order.status.OrderStatusDTO;
import com.example.customerservice.service.OrderStatusProcessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
@RequiredArgsConstructor
public class RabbitMQConsumerService {

    private final OrderStatusProcessorService orderStatusProcessorService;

    @RabbitListener(queues = "customerOrderStatus")
    public void processMyQueue(OrderStatusDTO orderStatus) {

        orderStatusProcessorService.processOrderStatus(orderStatus);
    }
}