package com.gwen.minibolt.service.serviceImp;

import com.gwen.minibolt.dto.RegisterRestaurantDto;
import com.gwen.minibolt.dto.RestaurantDto;
import com.gwen.minibolt.dto.converters.ApiMapper;
import com.gwen.minibolt.dto.subDto.RestaurantSubDto;
import com.gwen.minibolt.model.Restaurant;
import com.gwen.minibolt.repository.RestaurantRepository;
import com.gwen.minibolt.repository.UserRepository;
import com.gwen.minibolt.service.ServiceInt.RestaurantService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
@Slf4j
public class RestaurantServiceImp implements RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;
    private final ApiMapper mapper;

    @Override
    public List<RestaurantSubDto> getRestaurants() {
        return restaurantRepository.findAll().stream()
                .map(e -> new
                        RestaurantSubDto(
                        e.getId(),
                        e.getLocation(),
                        e.getName()))
                .toList();
    }

    @Override
    public RestaurantDto createRestaurant(RegisterRestaurantDto restaurantDto) {
        Restaurant restaurant = mapper.registerRestaurantDtoToRestaurant(restaurantDto);
        userRepository.findById(restaurant.getOwner().getId())
                .orElseThrow(() -> new RuntimeException(String.format("User with id: %d not found. Owner must be a registered user.", restaurantDto.ownerId())));
        return this.mapper.restaurantToRestaurantDto(this.restaurantRepository.save(restaurant));
    }

    @Override
    public RestaurantDto updateRestaurant(Long restaurantId, RegisterRestaurantDto restaurantDto) {
        return this.restaurantRepository.findById(restaurantId)
                .map(existingRestaurant ->
                        mapper.restaurantToRestaurantDto(
                                restaurantRepository.save(
                                        mapper.updateRestaurantFromRegisterRestaurantDto(restaurantDto, existingRestaurant)
                                )))
                .orElseThrow(() -> {
                    String message = String.format("Restaurant with id %d not found.", restaurantId);
                    log.debug(message);
                    return new RuntimeException(message);
                });

    }

    @Override
    public RestaurantDto getRestaurant(Long id) {
        return this.getRestaurantDto(id);

    }

    @Override
    public void deleteRestaurant(Long id) {
        if (Objects.nonNull(id)) {
            restaurantRepository.findById(id)
                    .ifPresent(restaurantRepository::delete);
        }
    }

    private RestaurantDto getRestaurantDto(Long id) {
        return this.restaurantRepository.findById(id).map(mapper::restaurantToRestaurantDto)
                .orElseThrow(() -> {
                    String message = String.format("Restaurant with id %d not found.", id);
                    log.debug(message);
                    return new RuntimeException(message);
                });
    }


}
