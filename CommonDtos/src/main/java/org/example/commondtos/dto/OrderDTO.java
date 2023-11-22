package org.example.commondtos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private Long restaurantId;

    private Map<Long, Integer> dishQuantityMap = new HashMap<>(); // Карта для хранения блюд и их количества

}
