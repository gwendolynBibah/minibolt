package com.gwen.minibolt.dto;

import com.gwen.minibolt.enums.ROLE;
import com.gwen.minibolt.model.User;

import java.io.Serializable;

/**
 * A DTO for the {@link User} entity
 */
public record UpdateUserRequest(Long id, String name, ROLE role, String password) implements Serializable {
}