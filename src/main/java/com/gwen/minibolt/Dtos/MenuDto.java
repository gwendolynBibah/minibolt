package com.gwen.minibolt.Dtos;

import com.gwen.minibolt.dto.subDto.FoodSubDto;
import com.gwen.minibolt.dto.subDto.RestaurantSubDto;
import com.gwen.minibolt.enums.GENERAL_STATUS;
import com.gwen.minibolt.model.Menu;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link Menu} entity
 */
public record MenuDto(Long id, String name, GENERAL_STATUS status, List<FoodSubDto> foods,
                      RestaurantSubDto restaurant) implements Serializable {
}