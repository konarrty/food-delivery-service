package com.example.restaurantservice.service;

import org.example.commondtos.dto.RestaurantDTO;
import com.example.restaurantservice.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> getAllRestaurants(int page);

    Restaurant createRestaurant(Restaurant restaurant);

    Restaurant patchRestaurants(RestaurantDTO newRestaurant, Long id);

    void deleteRestaurant(Long id);

    Restaurant getRestaurantById(Long id);
}
