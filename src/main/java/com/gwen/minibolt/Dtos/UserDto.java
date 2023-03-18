package com.gwen.minibolt.Dtos;

import com.gwen.minibolt.enums.Role;
import com.gwen.minibolt.model.User;

import java.io.Serializable;

/**
 * A DTO for the {@link User} entity
 */
public record UserDto(Long userId, String userName, Role role) implements Serializable {
}