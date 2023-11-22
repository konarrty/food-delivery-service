package com.example.restaurantservice.service;

import org.example.commondtos.dto.DishDTO;
import com.example.restaurantservice.model.Dish;

import java.util.List;

public interface DishService {
    List<Dish> getAllDishes(int page);

    Dish createDish(Dish dish);

    Dish patchDish(DishDTO newDish, Long id);

    void deleteDish(Long id);

    Dish getDishById(Long id);
}
