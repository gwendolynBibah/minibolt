package com.gwen.minibolt.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link com.gwen.minibolt.model.Town} entity
 */
public record TownDto(String id, String name, String regionId, String regionRegion) implements Serializable {
}