package com.example.courierservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@Table("orders")
public class DeliveryOrder {

    @Id
    private Long orderId;

    private Long courierId;

    private UUID userID;


}
