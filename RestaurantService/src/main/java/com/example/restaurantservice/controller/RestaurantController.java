package com.example.restaurantservice.controller;

import org.example.commondtos.dto.RestaurantDTO;
import com.example.restaurantservice.model.Restaurant;
import com.example.restaurantservice.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantsService;

    @GetMapping({"/", ""})
    public ResponseEntity<?> getAllRestaurants(@RequestParam(required = false, defaultValue = "1") int page) {
        List<Restaurant> restaurantsList = restaurantsService.getAllRestaurants(page);
        if (!restaurantsList.isEmpty())
            return ResponseEntity.ok(restaurantsList);
        else
            return ResponseEntity.notFound().build();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping({"/", ""})

    public Restaurant createRestaurants(@RequestBody Restaurant restaurant) {

        return restaurantsService.createRestaurant(restaurant);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteRestaurants(@PathVariable Long id) {

        restaurantsService.deleteRestaurant(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{id}")
    public Restaurant patchRestaurants(@RequestBody RestaurantDTO restaurantDTO, @PathVariable Long id) {

        return restaurantsService.patchRestaurants(restaurantDTO, id);
    }

}
