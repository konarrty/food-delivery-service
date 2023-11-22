package com.example.restaurantservice.service;

import com.example.restaurantservice.model.Dish;
import org.example.commondtos.dto.DishDTO;

import java.util.List;

public interface MenuService {
    List<Dish> getAllDishesByRestaurantId(Long restaurantId);

    Dish createDish(Dish dish, Long restaurantId);

    Dish patchDishes(DishDTO newDish, Long id);

    void deleteDish(Long id);

    Dish getDishById(Long id);
}
