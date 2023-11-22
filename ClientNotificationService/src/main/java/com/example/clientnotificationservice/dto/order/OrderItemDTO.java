package com.example.clientnotificationservice.dto.order;

import lombok.Data;

@Data
public class OrderItemDTO {
    private Long id;

    private int amount;

    private DishDTO dish;

}
