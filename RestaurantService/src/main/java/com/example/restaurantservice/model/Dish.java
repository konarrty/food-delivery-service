package com.example.restaurantservice.model;

import com.example.restaurantservice.enums.DishStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "dishes")
@AllArgsConstructor
@NoArgsConstructor
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private double price;

    @Enumerated(EnumType.ORDINAL)
    private DishStatus status;

    @ManyToOne
    private Restaurant restaurant;

    public Dish(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Dish(String name, String description, Restaurant restaurant) {
        this.name = name;
        this.description = description;
        this.restaurant = restaurant;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Dish dish = (Dish) o;
        return getId() != null && Objects.equals(getId(), dish.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
