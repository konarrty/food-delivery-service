package com.example.restaurantservice.controller;

import org.example.commondtos.dto.DishDTO;
import com.example.restaurantservice.model.Dish;
import com.example.restaurantservice.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants/{id}/dishes")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @GetMapping({"", "/"})
    public ResponseEntity<?> getAllDishes(@PathVariable Long id) {
        List<Dish> menusList = menuService.getAllDishesByRestaurantId(id);
        if (!menusList.isEmpty())
            return ResponseEntity.ok(menusList);
        else
            return ResponseEntity.notFound().build();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping({"/", ""})
    public Dish createDish(@RequestBody Dish dish, @PathVariable Long id) {

        return menuService.createDish(dish, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{dishId}")
    public void deleteDish(@PathVariable Long dishId, @PathVariable Long id) {

        menuService.deleteDish(dishId);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{dishId}")
    public Dish patchDish(@RequestBody DishDTO dishDTO, @PathVariable Long dishId) {

        return menuService.patchDishes(dishDTO, dishId);
    }

}
