package com.gwen.minibolt.dto;

import com.gwen.minibolt.model.Food;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * A DTO for the {@link Food} entity
 */
public record CreateFoodDto(@NotNull @NotBlank(message = "name is mandatory.") String name,
                            @NotNull @Min(value = 0, message = "least is 0") double price,
                            @NotNull @NotBlank(message = "description is mandatory.") String description,
                            Long menuId) implements Serializable {
}