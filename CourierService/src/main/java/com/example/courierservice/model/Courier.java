package com.example.courierservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalTime;
import java.util.UUID;

@Data
@Table("couriers")
public class Courier {

    @Id
    private Long id;

    private String firstName;

    private LocalTime startWorkTime;

    private LocalTime endWorkTime;

    private String lastName;

    private UUID userId;

}
