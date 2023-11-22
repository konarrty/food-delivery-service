package org.example.commondtos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DishWithAmountDTO {
    private Long id;

    private String name;

    private String description;

    private long amount;

    public DishWithAmountDTO(DishDTO dishDTO, long amount) {
        this.description = dishDTO.getDescription_();
        this.name = dishDTO.getName_();
        this.id = dishDTO.getId();
        this.amount = amount;
    }
}

