package com.gwen.minibolt.Dtos;

import com.gwen.minibolt.enums.Role;
import com.gwen.minibolt.model.User;

import java.io.Serializable;

/**
 * A DTO for the {@link User} entity
 */
public record UpdateUserRequest(Long id, String name, Role role, String password) implements Serializable {
}