package com.gwen.minibolt.mappers.adminImplmappers;

import com.gwen.minibolt.dtos.adminImplDto.UserDto;
import com.gwen.minibolt.enums.Role;
import com.gwen.minibolt.model.MiniboltUser;
import org.apache.catalina.User;

public class UserListMappers {
    public UserDto toUserDto (MiniboltUser user) {
        UserDto userDto = new UserDto();
        userDto.setName(user.getUserName());
        userDto.setRole(String.valueOf(user.getRole()));

        return userDto;
    }
    public MiniboltUser toUserEntity (UserDto userDto) {
        MiniboltUser user = new MiniboltUser();
        user.setUserName(user.getUserName());
        user.setRole(Role.valueOf(userDto.getRole()));

        return user;
    }
}
