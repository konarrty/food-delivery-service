package com.example.customerservice.utils;

import com.example.customerservice.dto.order.status.OrderStatusDTO;
import com.example.customerservice.enums.OrderStage;
import org.example.commondtos.enums.OrderStatus;
import org.springframework.stereotype.Component;

@Component
public class OrderStatusProcessor {

    public String processOrderStatus(OrderStatusDTO orderStatusDTO) {

        if (orderStatusDTO.getOrderStatus().equals(OrderStatus.CREATED))
            return "restaurantOrder";
        else if (orderStatusDTO.getOrderStatus().equals(OrderStatus.ACCEPTED))
            return "clientNotification";

        return null;

    }
}
