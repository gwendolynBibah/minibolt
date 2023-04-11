package com.gwen.minibolt.dto;

import com.gwen.minibolt.model.Town;

import java.io.Serializable;

/**
 * A DTO for the {@link Town} entity
 */
public record RRTownDto(String id, String name) implements Serializable {
}