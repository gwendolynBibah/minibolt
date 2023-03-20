package com.gwen.minibolt.controllers;

import com.gwen.minibolt.Dtos.RegisterRequest;
import com.gwen.minibolt.Dtos.UpdateUserRequest;
import com.gwen.minibolt.Dtos.UserDto;
import com.gwen.minibolt.service.ServiceInt.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @GetMapping()
    public List<UserDto> getAllUsers(){
        return this.userService.getAllUsers();
    }
    @GetMapping("/user")
    public UserDto getUser(@RequestParam("userId") @NotNull @NotBlank Long userId){
        return this.userService.getUser(userId);

    }

    @PostMapping
    public UserDto registerUser(@RequestBody @Valid RegisterRequest user){
        return this.userService.register(user);
    }
    @PatchMapping
    public UserDto updateUserDetails(@RequestParam(value = "userId") @NotNull @NotBlank Long userId,@RequestBody UpdateUserRequest user){
        return this.userService.updateUserDetails(user,userId);
    }
}
