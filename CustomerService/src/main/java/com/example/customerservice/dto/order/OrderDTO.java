package com.example.customerservice.dto.order;

import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {

    private Long id;

    private String userId;

    private List<OrderItemDTO> orderItems;
}
