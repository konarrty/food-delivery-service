package org.example.commondtos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDTO {

    private Long id;

    private String name;

    private List<DishDTO> menu;
}
