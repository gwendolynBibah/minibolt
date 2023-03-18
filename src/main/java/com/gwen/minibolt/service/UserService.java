package com.gwen.minibolt.service;

import com.gwen.minibolt.Dtos.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    UserDto register(UserDto user);
    UserDto getUser(long id);
    void deleteUser(Long id);
}
