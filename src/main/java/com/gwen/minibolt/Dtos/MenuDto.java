package com.gwen.minibolt.Dtos;

import com.gwen.minibolt.Dtos.subDto.FoodSubDto;
import com.gwen.minibolt.Dtos.subDto.RestaurantSubDto;
import com.gwen.minibolt.model.Menu;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link Menu} entity
 */
public record MenuDto(Long id, String name, List<FoodSubDto> foods,
                      RestaurantSubDto restaurant) implements Serializable {
}