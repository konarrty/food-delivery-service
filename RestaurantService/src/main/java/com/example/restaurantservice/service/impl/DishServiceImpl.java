package com.example.restaurantservice.service.impl;

import org.example.commondtos.dto.DishDTO;
import com.example.restaurantservice.model.Dish;
import com.example.restaurantservice.repository.DishRepository;
import com.example.restaurantservice.service.DishService;
import lombok.RequiredArgsConstructor;
import org.example.commondtos.exception.NoSuchEntityException;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;

    @Override
    public List<Dish> getAllDishes(int page) {

        return dishRepository.findAll(
                        PageRequest.of(page - 1, 5))
                .getContent();
    }

    @Override
    public Dish createDish(Dish dish) {

        return dishRepository.save(dish);
    }


    @Override
    public Dish patchDish(DishDTO newDish, Long id) {
        Dish dish = dishRepository
                .findById(id)
                .orElseThrow(() ->
                        new NoSuchEntityException("Ресторан не найден!"));

        BeanUtils.copyProperties(dish, newDish);

        return dishRepository.save(dish);
    }

    @Override
    public void deleteDish(Long id) {
        if (!dishRepository.existsById(id))
            throw new NoSuchEntityException("Ресторан не найден!");

        dishRepository.deleteById(id);
    }

    @Override
    public Dish getDishById(Long id) {

        return dishRepository
                .findById(id)
                .orElseThrow(() ->
                        new NoSuchEntityException("Ресторан не найден!"));
    }
}
