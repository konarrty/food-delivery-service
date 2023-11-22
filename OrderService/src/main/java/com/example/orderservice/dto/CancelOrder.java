package com.example.orderservice.dto;

import com.example.orderservice.model.Order;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.commondtos.enums.OrderStatus;

@Data
@NoArgsConstructor
public class CancelOrder {

    private Order order;
    private OrderStatus orderStatus = OrderStatus.CANCELED;

    public CancelOrder(Order order) {
        this.order = order;
    }
}
