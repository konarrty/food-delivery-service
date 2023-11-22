package com.example.restaurantservice.service.impl;

import org.example.commondtos.dto.RestaurantDTO;
import com.example.restaurantservice.model.Restaurant;
import com.example.restaurantservice.repository.RestaurantRepository;
import com.example.restaurantservice.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.example.commondtos.exception.NoSuchEntityException;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> getAllRestaurants(int page) {

        return restaurantRepository.findAll(
                        PageRequest.of(page - 1, 5))
                .getContent();
    }

    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {

        return restaurantRepository.save(restaurant);
    }


    @Override
    public Restaurant patchRestaurants(RestaurantDTO newRestaurant, Long id) {
        Restaurant restaurant = restaurantRepository
                .findById(id)
                .orElseThrow(() ->
                        new NoSuchEntityException("Ресторан не найден!"));

        BeanUtils.copyProperties(restaurant, newRestaurant);

        return restaurantRepository.save(restaurant);
    }

    @Override
    public void deleteRestaurant(Long id) {
        if (!restaurantRepository.existsById(id))
            throw new NoSuchEntityException("Ресторан не найден!");

        restaurantRepository.deleteById(id);
    }

    @Override
    public Restaurant getRestaurantById(Long id) {

        return restaurantRepository
                .findById(id)
                .orElseThrow(() ->
                        new NoSuchEntityException("Ресторан не найден!"));
    }
}
