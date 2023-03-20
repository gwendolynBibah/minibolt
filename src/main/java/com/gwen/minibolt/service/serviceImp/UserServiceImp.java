package com.gwen.minibolt.service.serviceImp;

import com.gwen.minibolt.Dtos.RegisterRequest;
import com.gwen.minibolt.Dtos.UpdateUserRequest;
import com.gwen.minibolt.Dtos.UserDto;
import com.gwen.minibolt.Dtos.converters.ApiMapper;
import com.gwen.minibolt.repository.UserRepository;
import com.gwen.minibolt.service.ServiceInt.UserService;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    public UserDto register(RegisterRequest registerRequest){
        return mapper.userToUserDto(userRepository.save(mapper.registerRequestToUser(registerRequest)));
    }

    @Override
    public UserDto updateUserDetails(UpdateUserRequest user, @NotNull @NotBlank Long userId) {
        return this.userRepository.findById(userId)
                .map(existingUser ->
                        mapper.userToUserDto(this.userRepository.save(mapper.updateUserFromUpdateUserRequest(user,existingUser)))
                ).orElseThrow(() ->
                {
                    String message = String.format("User with id %d not found.", userId);
                    log.debug(message);
                    return new RuntimeException(message);
                });
    }

    @Override
    public UserDto getUser(long id) {
        return getUserFromDatabase(id);
    }

    @Override
    public void deleteUser(Long id) {
        if (Objects.nonNull(id)) {
            userRepository.deleteById(getUserFromDatabase(id).userId());
        }
    }
    private UserDto getUserFromDatabase(long userId) {

        return userRepository.findById(userId).map(mapper::userToUserDto)
                .orElseThrow(() ->
                {
                    String message = String.format("User with id %d not found.", userId);
                    log.debug(message);
                    return new RuntimeException(message);
                });
    }

}

