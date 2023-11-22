package com.example.clientnotificationservice.dto.order;

import com.example.clientnotificationservice.enums.OrderStage;
import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {

    private Long id;

    private String userId;

    private OrderStage orderStage;

    private List<OrderItemDTO> orderItems;
}
