package com.gwen.minibolt.controllers;

import com.gwen.minibolt.dto.RegisterRequest;
import com.gwen.minibolt.dto.UpdateUserRequest;
import com.gwen.minibolt.dto.UserDto;
import com.gwen.minibolt.enums.ROLE;
import com.gwen.minibolt.service.ServiceInt.UserService;
import com.gwen.minibolt.service.ServiceInt.roleBase.AdminPrivilege;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;
    private final AdminPrivilege adminPrivilege;


    @GetMapping()
    public List<UserDto> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @GetMapping("/user")
    public UserDto getUser(@RequestParam("userId") @NotNull @NotBlank Long userId) {
        return this.userService.getUser(userId);
    }

    @PostMapping
    public UserDto registerUser(@RequestBody @Valid RegisterRequest user) {
        return this.userService.register(user);
    }

    @PatchMapping
    public UserDto updateUserDetails(@RequestParam(value = "userId") @NotNull @NotBlank Long userId, @RequestBody UpdateUserRequest user) {
        return this.userService.updateUserDetails(user, userId);
    }

    @DeleteMapping
    public void deleteUser(@RequestParam(value = "userId") @NotNull @NotBlank Long userId) {
        this.userService.deleteUser(userId);
    }

    @PostMapping("{userId}/{role}")
    public UserDto changeUserRole(@PathVariable String role, @PathVariable Long userId){
        return this.adminPrivilege.changeUserRole(userId, ROLE.valueOf(role));
    }

    @PostMapping("suspend/{userId}")
    public UserDto suspend(@PathVariable Long userId){
        return this.adminPrivilege.SuspendUser(userId);
    }

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody RegisterRequest registerRequest){
    return this.userService.generateToken(registerRequest);
    }

    @GetMapping("google")
    public Principal users(Principal principal){
        return principal;
    }


}
