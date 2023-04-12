package com.gwen.minibolt.mappers.userimplmappers;

import com.gwen.minibolt.dtos.userImplDTOs.UserDTO;
import com.gwen.minibolt.enums.Role;
import com.gwen.minibolt.model.MiniboltUser;

public class UserMapper {
    public UserDTO toDto (MiniboltUser user) {
        UserDTO userDto = new UserDTO();
        userDto.setName(user.getUserName());
        userDto.setRole(String.valueOf(user.getRole()));
        userDto.setPassword(user.getPassword());

        return userDto;
}
    public MiniboltUser toEntity (UserDTO userDTO) {
        MiniboltUser user = new MiniboltUser();
        user.setUserName(userDTO.getName());
        user.setRole(Role.valueOf(userDTO.getRole()));
        user.setPassword(userDTO.getPassword());

        return user;
    }

}
