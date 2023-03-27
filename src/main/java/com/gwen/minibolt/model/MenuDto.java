package com.gwen.minibolt.model;

import java.io.Serializable;

/**
 * A DTO for the {@link Menu} entity
 */
public record MenuDto(Long menuId, String menuName) implements Serializable {
}