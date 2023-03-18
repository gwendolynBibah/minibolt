package com.gwen.minibolt.controllers;

import com.gwen.minibolt.Dtos.UserDto;
import com.gwen.minibolt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
public class UserController {
    private final UserService userService;

    @GetMapping()
    public List<UserDto> getAllUsers(){
        return this.userService.getAllUsers();
    }
}
