package com.example.clientnotificationservice.dto;

import com.example.clientnotificationservice.dto.order.OrderDTO;
import com.example.clientnotificationservice.enums.OrderStage;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CancelOrder {

    private OrderDTO order;
    private OrderStage orderStage = OrderStage.CANCELED;


    public CancelOrder(OrderDTO order) {
        this.order = order;
    }
}
