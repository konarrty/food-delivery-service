package com.example.restaurantservice.service.impl.gRPC;

import com.example.RestaurantServiceGrpc;
import com.example.RestaurantServiceOuterClass;
import com.example.restaurantservice.model.Dish;
import com.example.restaurantservice.service.DishService;
import com.example.restaurantservice.service.RestaurantService;
import com.google.protobuf.Timestamp;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.List;


@GrpcService
@RequiredArgsConstructor
public class RestaurantGrpcServiceImpl extends RestaurantServiceGrpc.RestaurantServiceImplBase {

    private final RestaurantService restaurantService;
    private final DishService dishService;

    @Override
    public void getClosingTimeByRestaurantId(RestaurantServiceOuterClass.GetClosingTimeByRestaurantIdRequest request,
                                             StreamObserver<RestaurantServiceOuterClass
                                                     .GetClosingTimeByRestaurantIdResponse> responseObserver) {

        RestaurantServiceOuterClass.GetClosingTimeByRestaurantIdResponse reply = RestaurantServiceOuterClass.GetClosingTimeByRestaurantIdResponse.newBuilder()
                .setTimeStamp(Timestamp.newBuilder().setSeconds(restaurantService.getRestaurantById(request.getRestaurantId()).getClosedTime().toSecondOfDay()))
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void extractValidDishes(RestaurantServiceOuterClass.ExtractValidDishesRequest request, StreamObserver<RestaurantServiceOuterClass.ExtractValidDishesResponse> responseObserver) {

        List<Long> dishes = restaurantService.getRestaurantById(request.getRestaurantId())
                .getDishes().stream().map(Dish::getId)
                .toList();

        dishes = dishes.stream()
                .filter(id -> request.getDishIdList().contains(id)).toList();

        RestaurantServiceOuterClass.ExtractValidDishesResponse reply = RestaurantServiceOuterClass.ExtractValidDishesResponse.newBuilder()
                .addAllValidDishId(dishes)
                .build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void getDishById(RestaurantServiceOuterClass.GetDishByIdRequest request, StreamObserver<RestaurantServiceOuterClass.GetDishByIdResponse> responseObserver) {

        Dish dish = dishService.getDishById(request.getDishId());

        var reply = RestaurantServiceOuterClass
                .GetDishByIdResponse.newBuilder()
                .setId(dish.getId())
                .setName(dish.getName())
                .setDescription(dish.getDescription())
                .build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }


}