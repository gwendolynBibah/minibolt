package com.gwen.minibolt.service.serviceImp;

import com.gwen.minibolt.Dtos.UserDto;
import com.gwen.minibolt.Dtos.converters.ApiMapper;
import com.gwen.minibolt.repository.UserRepository;
import com.gwen.minibolt.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final ApiMapper mapper;

    @Override
    public List<UserDto> getAllUsers() {
        log.info("Fetching all users");
        return userRepository.findAll().stream().map(mapper::userToUserDto).toList();
    }

    @Override
    public UserDto register(UserDto user){
        var newUser = userRepository.save(mapper.userDtoToUser(user));
        return mapper.userToUserDto(newUser);
    }

    @Override
    public UserDto getUser(long id) {
        return getUserFromDatabase(id);
    }

    @Override
    public void deleteUser(Long id) {
        if (Objects.nonNull(id)) {
        Long userId = getUserFromDatabase(id).userId();
        userRepository.deleteById(userId);
        }
    }
    private UserDto getUserFromDatabase(long id) {
        return userRepository.findById(id).map(mapper::userToUserDto)
                .orElseThrow(() ->
                {
                    String message = String.format("User with id %d not found.", id);
                    log.debug(message);
                    return new RuntimeException(message);
                });
    }
}
