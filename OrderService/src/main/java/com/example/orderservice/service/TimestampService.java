package com.example.orderservice.service;

import com.example.RestaurantServiceGrpc;
import com.example.RestaurantServiceOuterClass;
import lombok.AllArgsConstructor;
import org.example.commondtos.dto.DishDTO;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
@AllArgsConstructor
public class TimestampService {

    private RestaurantServiceGrpc.RestaurantServiceBlockingStub myServiceStub;

    public LocalTime getClosingTimeByRestaurantIdRequest(Long id) {
        RestaurantServiceOuterClass.GetClosingTimeByRestaurantIdRequest request = RestaurantServiceOuterClass.GetClosingTimeByRestaurantIdRequest.newBuilder()
                .setRestaurantId(id)
                .build();

        return LocalTime.ofSecondOfDay(myServiceStub.getClosingTimeByRestaurantId(request).getTimeStamp().getSeconds());
    }

    public DishDTO getDishById(Long id) {
        var request = RestaurantServiceOuterClass
                .GetDishByIdRequest.newBuilder()
                .setDishId(id)
                .build();

        var response = myServiceStub.getDishById(request);

        return DishDTO.builder()
                .id(response.getId())
                .name_(response.getName())
                .description_(response.getDescription())
                .build();

    }


    public Iterable<Long> extractValidDishesRequest(Long id, Iterable<Long> dishIds) {
        var request = RestaurantServiceOuterClass.ExtractValidDishesRequest.newBuilder()
                .setRestaurantId(id)
                .addAllDishId(dishIds)
                .build();

        return myServiceStub.extractValidDishes(request).getValidDishIdList();
    }

}