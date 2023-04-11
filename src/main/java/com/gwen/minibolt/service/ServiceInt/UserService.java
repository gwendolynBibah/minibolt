package com.gwen.minibolt.service.ServiceInt;

import com.gwen.minibolt.dto.RegisterRequest;
import com.gwen.minibolt.dto.UpdateUserRequest;
import com.gwen.minibolt.dto.UserDto;
import com.gwen.minibolt.export_data.ExcelMetaDataDto;
import com.gwen.minibolt.export_data.ResourceDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.security.Principal;
import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();

    UserDto register(RegisterRequest user);

    String generateToken(RegisterRequest user);

    UserDto updateUserDetails(UpdateUserRequest user, @NotNull @NotBlank String userId);

    UserDto getUser(String id);

    void deleteUser(String id);

    String signInWithGoogle(Principal principal);

    ExcelMetaDataDto prepareExcelData();

    ResourceDto exportExcel();
}
