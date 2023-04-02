package com.gwen.minibolt.service.ServiceInt;

import com.gwen.minibolt.dto.RegisterRequest;
import com.gwen.minibolt.dto.UpdateUserRequest;
import com.gwen.minibolt.dto.UserDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();

    UserDto register(RegisterRequest user);

    String generateToken(RegisterRequest user);

    UserDto updateUserDetails(UpdateUserRequest user, @NotNull @NotBlank Long userId);

    UserDto getUser(long id);

    void deleteUser(Long id);
}
