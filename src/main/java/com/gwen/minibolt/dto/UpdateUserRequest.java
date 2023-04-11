package com.gwen.minibolt.dto;

import com.gwen.minibolt.enums.ROLE;
import com.gwen.minibolt.model.User;

import java.io.Serializable;

/**
 * A DTO for the {@link User} entity
 */
public record UpdateUserRequest(String id, String name, ROLE role, String password) implements Serializable {
}