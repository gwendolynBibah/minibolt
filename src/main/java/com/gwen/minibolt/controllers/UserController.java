package com.gwen.minibolt.controllers;

import com.gwen.minibolt.dto.RegisterRequest;
import com.gwen.minibolt.dto.UpdateUserRequest;
import com.gwen.minibolt.dto.UserDto;
import com.gwen.minibolt.enums.ROLE;
import com.gwen.minibolt.export_data.ResourceDto;
import com.gwen.minibolt.service.ServiceInt.EmailSenderService;
import com.gwen.minibolt.service.ServiceInt.UserService;
import com.gwen.minibolt.service.ServiceInt.roleBase.AdminPrivilege;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;
    private final AdminPrivilege adminPrivilege;
    private final EmailSenderService emailSenderService;


    @GetMapping()
    public List<UserDto> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @GetMapping("/user")
    public UserDto getUser(@RequestParam("userId") @NotNull @NotBlank String userId) {
        return this.userService.getUser(userId);
    }

    @PostMapping("sign-up")
    public UserDto registerUser(@RequestBody @Valid RegisterRequest user) {
        return this.userService.register(user);
    }

    @PatchMapping
    public UserDto updateUserDetails(@RequestParam(value = "userId") @NotNull @NotBlank String userId, @RequestBody UpdateUserRequest user) {
        return this.userService.updateUserDetails(user, userId);
    }

    @DeleteMapping
    public void deleteUser(@RequestParam(value = "userId") @NotNull @NotBlank String userId) {
        this.userService.deleteUser(userId);
    }

    @PostMapping("{userId}/{role}")
    public UserDto changeUserRole(@PathVariable String role, @PathVariable String userId){
        return this.adminPrivilege.changeUserRole(userId, ROLE.valueOf(role));
    }

    @PostMapping("suspend/{userId}")
    public UserDto suspend(@PathVariable String userId){
        return this.adminPrivilege.SuspendUser(userId);
    }

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody RegisterRequest registerRequest){
    return this.userService.generateToken(registerRequest);
    }

    @GetMapping("google")
    public String signInWithGoogle(Principal principal){
        return this.userService.signInWithGoogle(principal);
    }

    @PostMapping("/redirect")
    public ResponseEntity<Void> redirect(){
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("https://google.com")).build();
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportUsers(){
        ResourceDto resourceDto = userService.exportExcel();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition",
                "attachment; filename= " +
                        resourceDto.getFilename() +
                        ".xlsx");
        return ResponseEntity.ok().contentType(resourceDto.getMediaType()).headers(headers).body(resourceDto.getResource());
    }

    @GetMapping("/exportPdf")
    public ResponseEntity<Resource> exportUsersPdf(){
        ResourceDto resourceDto = userService.exportExcel();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition",
                "attachment; filename= " +
                        resourceDto.getFilename() +
                        ".pdf");
        return ResponseEntity.ok().contentType(resourceDto.getMediaType()).headers(headers).body(resourceDto.getResource());
    }

    @PostMapping("/send/{status}")
    public ResponseEntity<String> sendEmail(@RequestBody String email, @PathVariable String status) throws MessagingException {
        String message =  switch (status){
            case "yes"->    emailSenderService.sendMailWithAttachment(email,"Hello testing feature","MIniBoltRegistry","C:/Users/Gracias/Desktop/Users.xlsx");
            case "no"->emailSenderService.sendMailWithAttachment(email,"Hello testing feature","MIniBoltRegistry",null);
            default -> "nothing to show";
        };
        return ResponseEntity.ok().body(message);
    }


}
