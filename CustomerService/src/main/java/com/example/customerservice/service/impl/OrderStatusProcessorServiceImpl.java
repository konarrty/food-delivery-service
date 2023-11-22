package com.example.customerservice.service.impl;

import com.example.customerservice.dto.order.status.OrderStatusDTO;
import com.example.customerservice.service.OrderStatusProcessorService;
import com.example.customerservice.utils.OrderStatusProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderStatusProcessorServiceImpl implements OrderStatusProcessorService {

    private final OrderStatusProcessor orderStatusProcessor;
    private final RabbitTemplate rabbitTemplate;

    @Override
    public void processOrderStatus(OrderStatusDTO orderStatusDTO) {

        if (!orderStatusDTO.isOk()) {
            sendPushNotification(orderStatusDTO);
            return;
        }
//        System.err.println(orderStatusProcessor.processOrderStatus(orderStatusDTO));
        rabbitTemplate.convertAndSend(orderStatusProcessor.processOrderStatus(orderStatusDTO), orderStatusDTO.getOrder());

    }

    @Override
    public void sendPushNotification(OrderStatusDTO orderStatusDTO) {

        //TODO ping front
    }
}
