package org.example.commondtos.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.commondtos.enums.OrderStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderEvent {

    private Long orderId;

    private String userId;

    private OrderStatus orderStatus;

    public OrderEvent(Long orderId) {
        this.orderId = orderId;
    }

    public OrderEvent(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public OrderEvent(Long orderId, OrderStatus orderStatus) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
    }
}
