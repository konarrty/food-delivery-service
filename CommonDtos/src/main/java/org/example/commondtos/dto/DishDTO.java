package org.example.commondtos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DishDTO {
    private Long id;

    private String name_;

    private String description_;
}
