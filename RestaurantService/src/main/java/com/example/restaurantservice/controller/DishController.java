package com.example.restaurantservice.controller;

import org.example.commondtos.dto.DishDTO;
import com.example.restaurantservice.model.Dish;
import com.example.restaurantservice.service.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dishes")
@RequiredArgsConstructor
public class DishController {

    private final DishService dishService;

    @GetMapping({"/", ""})
    public ResponseEntity<?> getAllDishes(@RequestParam(required = false, defaultValue = "1") int page) {
        List<Dish> dishsList = dishService.getAllDishes(page);
        if (!dishsList.isEmpty())
            return ResponseEntity.ok(dishsList);
        else
            return ResponseEntity.notFound().build();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping({"/", ""})

    public Dish createDish(@RequestBody Dish dish) {

        return dishService.createDish(dish);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteDish(@PathVariable Long id) {

        dishService.deleteDish(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{id}")
    public Dish patchDish(@RequestBody DishDTO dishDTO, @PathVariable Long id) {

        return dishService.patchDish(dishDTO, id);
    }

}
