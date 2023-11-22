package com.example.orderservice.dto.status;

import com.example.orderservice.model.Order;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.commondtos.enums.OrderStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatusDTO {

    private Order order;

    private OrderStatus orderStatus;

    private Exception[] exceptions;

    @JsonProperty("is_ok")
    private boolean isOk;

    public OrderStatusDTO(OrderStatus orderStatus, boolean is_ok) {
        this.orderStatus = orderStatus;
        this.isOk = is_ok;
    }

    public OrderStatusDTO(OrderStatus orderStatus, Exception exceptions, boolean is_ok) {
        this.orderStatus = orderStatus;
        this.exceptions[0] = exceptions;
        this.isOk = is_ok;
    }

    public OrderStatusDTO(Order order, OrderStatus orderStatus, boolean isOk) {
        this.order = order;
        this.orderStatus = orderStatus;
        this.isOk = isOk;
    }
}
