package com.gwen.minibolt.controllers;

import com.gwen.minibolt.Dtos.RegisterRestaurantDto;
import com.gwen.minibolt.Dtos.RestaurantDto;
import com.gwen.minibolt.service.ServiceInt.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/restaurants")
public class RestaurantController {
    private  final RestaurantService restaurantService;

    @GetMapping
    public List<RestaurantDto> getRestaurants(){
        return this.restaurantService.getRestaurants();
    }

    @PostMapping
    public RestaurantDto registerRestaurant(RegisterRestaurantDto restaurant){
        return this.restaurantService.createRestaurant(restaurant);
    }

    @GetMapping("restaurant")
    public RestaurantDto getRestaurant(@RequestParam(value ="id") Long id){
        return this.restaurantService.getRestaurant(id);
    }

    @PatchMapping
    public RestaurantDto updateRestaurant(@RequestParam("id") Long id, @RequestBody RegisterRestaurantDto restaurantDto){
        return this.restaurantService.updateRestaurant(id,restaurantDto);

    }

    @DeleteMapping
    public void removeRestaurant(@RequestParam(value = "id") Long id){
        this.restaurantService.deleteRestaurant(id);
    }


}
