package com.gwen.minibolt.dto;

import com.gwen.minibolt.model.Menu;

import java.io.Serializable;

/**
 * A DTO for the {@link Menu} entity
 */
public record MenuDto(String menuId, String menuName) implements Serializable {
}
