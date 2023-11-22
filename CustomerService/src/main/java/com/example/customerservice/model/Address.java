package com.example.customerservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "addresses")
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String country;

    private String region;

    private String city;

    private String street;

    private int home;

    private int storey;

    private int apartment;

    private boolean isActive;

    @ManyToOne
    private Customer customer;

}
