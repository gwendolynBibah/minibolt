package com.gwen.minibolt.service.serviceImp;

import com.gwen.minibolt.dto.RegisterRestaurantDto;
import com.gwen.minibolt.dto.RestaurantDto;
import com.gwen.minibolt.dto.converters.ApiMapper;
import com.gwen.minibolt.dto.subDto.RestaurantSubDto;
import com.gwen.minibolt.model.Image;
import com.gwen.minibolt.model.Restaurant;
import com.gwen.minibolt.model.Town;
import com.gwen.minibolt.model.User;
import com.gwen.minibolt.repository.RestaurantRepository;
import com.gwen.minibolt.repository.TownRepository;
import com.gwen.minibolt.repository.UserRepository;
import com.gwen.minibolt.service.ServiceInt.FileManagementService;
import com.gwen.minibolt.service.ServiceInt.RestaurantService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service
@AllArgsConstructor
@Slf4j
public class RestaurantServiceImp implements RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;
    private final FileManagementService fileManagementService;
    private final ApiMapper mapper;
    private final TownRepository townRepository;

    @Override
    public List<RestaurantSubDto> getRestaurants() {
        return restaurantRepository.findAll().stream()
                .map(restaurant -> new
                        RestaurantSubDto(
                        restaurant.getId(),
                        restaurant.getLocation().getName(),
                        restaurant.getName(),restaurant.getImage()))
                .toList();
    }
    @Override
    public Restaurant createRestaurant(RegisterRestaurantDto restaurantDto) {
        Restaurant restaurant = mapper.registerRestaurantDtoToRestaurant(restaurantDto);
        Town location = townRepository.findByNameIgnoreCase(restaurantDto.location())
                .orElseThrow(()->new EntityNotFoundException(new StringBuilder().append("Town with name ")
                        .append(restaurantDto.location()).append(" does not exist.").toString()));
        restaurant.setLocation(location);
        if (Objects.nonNull(restaurantDto.file())){
            Image image = fileManagementService.saveFileToDB(restaurantDto.file());
            String url = fileManagementService.generateDownLoadUri(image);
            restaurant.setImage(url);
        }
        User user = userRepository.findById(restaurantDto.ownerId())
                .orElseThrow(() -> new RuntimeException(String.format("User with id: %d not found. Owner must be a registered user.", restaurantDto.ownerId())));
        restaurant.setOwner(user);
        return this.restaurantRepository.save(restaurant);
    }

    @Override
    public RestaurantDto updateRestaurant(String restaurantId, RegisterRestaurantDto restaurantDto) {
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
    public RestaurantDto getRestaurant(String id) {
        return this.getRestaurantDto(id);

    }

    @Override
    public void deleteRestaurant(String id) {
        if (Objects.nonNull(id)) {
            restaurantRepository.findById(id)
                    .ifPresent(restaurantRepository::delete);
        }
    }

    private RestaurantDto getRestaurantDto(String id) {
        return this.restaurantRepository.findById(id).map(mapper::restaurantToRestaurantDto)
                .orElseThrow(() -> {
                    String message = String.format("Restaurant with id %d not found.", id);
                    log.debug(message);
                    return new RuntimeException(message);
                });
    }


}
