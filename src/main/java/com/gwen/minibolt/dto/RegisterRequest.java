package com.gwen.minibolt.dto;

import com.gwen.minibolt.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

/**
 * A DTO for the {@link User} entity
 */
public record RegisterRequest(
        @NotNull @NotBlank(message = "name is mandatory.") String email,
        @NotBlank(message = "password is mandatory")
        @Size(min = 4, message = "password should have a minimum of 4 character.")
        @NotNull String password) implements Serializable {
}