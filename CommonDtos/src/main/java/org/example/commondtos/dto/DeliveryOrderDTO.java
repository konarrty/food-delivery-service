package org.example.commondtos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryOrderDTO {
    private Long id;

    private Long orderId;

    private CourierDTO courier;
}
