package com.example.clientnotificationservice.dto.order.status;

import com.example.clientnotificationservice.dto.order.OrderDTO;
import com.example.clientnotificationservice.enums.OrderStage;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderStatusDTO {

    private OrderDTO order;

    private OrderStage orderStatus;

    private Exception[] exceptions;

    @JsonProperty("is_ok")
    private boolean isOk;


}
