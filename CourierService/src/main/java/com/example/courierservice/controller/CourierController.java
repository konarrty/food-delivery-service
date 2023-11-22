package com.example.courierservice.controller;

import com.example.courierservice.model.Courier;
import com.example.courierservice.service.CourierService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/couriers")
@RequiredArgsConstructor
public class CourierController {

    private final CourierService couriersService;

//    @GetMapping({"/", ""})
//    public ResponseEntity<?> getAllCouriers(@RequestParam(required = false, defaultValue = "1") int page) {
//        List<Courier> couriersList = couriersService.getAllCouriers(page);
//        if (!couriersList.isEmpty())
//            return ResponseEntity.ok(couriersList);
//        else
//            return ResponseEntity.notFound().build();
//    }
//
//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping({"/", ""})
//
//    public Courier createCouriers(@RequestBody Courier courier) {
//
//        return couriersService.createCourier(courier);
//    }
//
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @DeleteMapping("/{id}")
//    public void deleteCouriers(@PathVariable Long id) {
//
//        couriersService.deleteCourier(id);
//    }
//
//    @ResponseStatus(HttpStatus.OK)
//    @PatchMapping("/{id}")
//    public Courier patchCouriers(@RequestBody CourierDTO courierDTO, @PathVariable Long id) {
//
//        return couriersService.patchCouriers(courierDTO, id);
//    }

    @GetMapping(path = "{id}")
    public Mono<Courier> getCourier(@PathVariable Long id) {

        return couriersService.getCourierById(id);
    }

}
