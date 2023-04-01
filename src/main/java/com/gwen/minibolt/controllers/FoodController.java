package com.gwen.minibolt.controllers;

import com.gwen.minibolt.dto.CreateFoodDto;
import com.gwen.minibolt.dto.FoodDto;
import com.gwen.minibolt.service.ServiceInt.FoodService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/foods")
public class FoodController {

    private final FoodService foodService;

    @GetMapping
    public List<FoodDto> getAllFood() {
        return this.foodService.getAllFood();
    }

    @GetMapping("food")
    public FoodDto getFood(@RequestParam(value = "id") @NotNull Long id) {
        return this.foodService.getFood(id);
    }

    @PostMapping
    public FoodDto addFood(@RequestBody CreateFoodDto food) {
        return this.foodService.createFood(food);
    }

    @PatchMapping
    public FoodDto updateFood(@RequestParam(value = "id") @NotNull Long id, @RequestBody CreateFoodDto food) {
        return this.foodService.updateFood(id, food);

    }

    @DeleteMapping
    public void removeFood(@RequestParam(value = "id") @NotNull Long id) {
        this.foodService.deleteFood(id);
    }
}
