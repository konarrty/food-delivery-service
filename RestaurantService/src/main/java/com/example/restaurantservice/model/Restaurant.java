package com.example.restaurantservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Builder
@Data
@Entity
@Table(name = "restaurants")
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "closing_time")
    private LocalTime closedTime;

    @Column(name = "opening_time")
    private LocalTime openingTime;

    @JsonIgnore
    @OneToMany(mappedBy = "restaurant", fetch = FetchType.EAGER)
    private List<Dish> dishes;

    @JsonIgnore
    @OneToMany(mappedBy = "restaurant", fetch = FetchType.EAGER)
    private List<Mark> marks;

    public Restaurant(String name) {
        this.name = name;
    }

    public Restaurant(Long id) {
        this.id = id;
    }
}
