package com.example.customerservice.service;

import com.example.customerservice.dto.order.status.OrderStatusDTO;

public interface OrderStatusProcessorService {
    void processOrderStatus(OrderStatusDTO orderStatusDTO);

    void sendPushNotification(OrderStatusDTO orderStatusDTO);
}
