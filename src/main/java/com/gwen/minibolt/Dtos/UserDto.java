package com.gwen.minibolt.Dtos;

import com.gwen.minibolt.enums.Role;
import com.gwen.minibolt.model.User;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.lang.NonNull;

import java.io.Serializable;

/**
 * A DTO for the {@link User} entity
 */
public record UserDto(@NonNull Long userId, @NotEmpty @NotNull String userName, Role role) implements Serializable {
}