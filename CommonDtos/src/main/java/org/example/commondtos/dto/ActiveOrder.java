package org.example.commondtos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActiveOrder {

    private Long orderId;
    private Long restaurantId;

    private List<DishWithAmountDTO> dishes = new ArrayList<>();

}
