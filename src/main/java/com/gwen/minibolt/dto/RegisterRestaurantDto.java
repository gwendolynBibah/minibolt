package com.gwen.minibolt.dto;

import com.gwen.minibolt.model.Restaurant;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * A DTO for the {@link Restaurant} entity
 */
public record RegisterRestaurantDto(String location, double rating, String name, String ownerId, MultipartFile file) implements Serializable {
}