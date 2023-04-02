package com.gwen.minibolt.service.serviceImp;

import com.gwen.minibolt.config.JwtService;
import com.gwen.minibolt.dto.RegisterRequest;
import com.gwen.minibolt.dto.UpdateUserRequest;
import com.gwen.minibolt.dto.UserDto;
import com.gwen.minibolt.dto.converters.ApiMapper;
import com.gwen.minibolt.enums.ROLE;
import com.gwen.minibolt.model.User;
import com.gwen.minibolt.repository.UserRepository;
import com.gwen.minibolt.service.ServiceInt.UserService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final ApiMapper mapper;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserDto> getAllUsers() {
        log.info("Fetching all users");
        return userRepository.findAll().stream().map(mapper::userToUserDto).toList();
    }

    @Override
    public UserDto register(RegisterRequest registerRequest) {
        return saveUserDetails(registerRequest);
    }

    private UserDto saveUserDetails(RegisterRequest registerRequest) {
        User userEntity = mapper.registerRequestToUser(registerRequest);
        userEntity.setDeleted(Boolean.FALSE);
        userEntity.setRole(ROLE.USER);
        userEntity.setPassword(passwordEncoder.encode(registerRequest.password()));
        Optional<User> user = userRepository.findByEmail(registerRequest.email());
        if (user.isPresent()){
            return mapper.userToUserDto(user.get());
        }
        var newUser =  userRepository.save(userEntity);
        return mapper.userToUserDto(newUser);
    }

    @Override
    public String generateToken(RegisterRequest user) {
        Authentication authenticate = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.email(), user.password()));
        if (authenticate.isAuthenticated()) {
            return jwtService.generateToken(user.email());
        } else {
            throw new UsernameNotFoundException("invalid user");
        }
    }

    @Override
    public UserDto updateUserDetails(UpdateUserRequest user, @NotNull @NotBlank Long userId) {
        return this.userRepository.findById(userId)
                .map(existingUser ->
                        mapper.userToUserDto(this.userRepository.save(mapper.updateUserFromUpdateUserRequest(user, existingUser)))
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
            userRepository.findById(id).ifPresent(userRepository::delete);
        }
    }

    /**
     * @param principal
     * @return
     */
    @Override
    public String signInWithGoogle(Principal principal) {
        RegisterRequest registerRequest = new RegisterRequest(principal.getName(), principal.getName());
        saveUserDetails(registerRequest);
        return generateToken(registerRequest);
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

