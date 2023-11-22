package com.example.orderservice.model;

import com.example.orderservice.dto.DishDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.commondtos.enums.OrderStatus;
import org.hibernate.annotations.Columns;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    private Long restaurantId;

    @Enumerated(EnumType.ORDINAL)
    private OrderStatus orderStatus;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "order_dish_quantity",
            joinColumns = @JoinColumn(name = "order_id"))
    @MapKeyColumn(name = "dish_id")
    @Column(name = "quantity")
    private Map<Long, Integer> dishQuantityMap = new HashMap<>();

    public Order(Long id, String userId) {
        this.id = id;
        this.userId = userId;
    }
}
