package com.example.restaurantservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@Entity
@Table(name = "marks")
@NoArgsConstructor
@AllArgsConstructor
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int grade;

    private Long clientId;

    @ManyToOne
    private Restaurant restaurant;

}
