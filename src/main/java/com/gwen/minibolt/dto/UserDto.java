package com.gwen.minibolt.dto;

import com.gwen.minibolt.enums.ROLE;
import com.gwen.minibolt.model.User;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.lang.NonNull;

import java.io.Serializable;

/**
 * A DTO for the {@link User} entity
 */
public record UserDto(@NonNull String userId, @NotEmpty @NotNull String userName, Boolean deleted,
                      ROLE role) implements Serializable {
}