package org.example.commondtos.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.commondtos.enums.OrderStatus;
import org.springframework.core.annotation.Order;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourierOrderEvent {

    private Long orderId;

    private String userId;

    private OrderStatus orderStatus;

    public CourierOrderEvent(OrderEvent event) {
        orderId = event.getOrderId();
        userId = event.getUserId();
        orderStatus = event.getOrderStatus();
    }
}
