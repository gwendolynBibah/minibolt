package com.gwen.minibolt.service.ServiceInt;

import com.gwen.minibolt.Dtos.RegisterRequest;
import com.gwen.minibolt.Dtos.UpdateUserRequest;
import com.gwen.minibolt.Dtos.UserDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    UserDto register(RegisterRequest user);
    UserDto updateUserDetails(UpdateUserRequest user, @NotNull @NotBlank Long userId);
    UserDto getUser(long id);
    void deleteUser(Long id);
}
