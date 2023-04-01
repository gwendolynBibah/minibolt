package com.gwen.minibolt.service.serviceImp.roleBase;

import com.gwen.minibolt.dto.OrderItemDto;
import com.gwen.minibolt.dto.RestaurantDto;
import com.gwen.minibolt.dto.UserDto;
import com.gwen.minibolt.dto.converters.ApiMapper;
import com.gwen.minibolt.enums.ROLE;
import com.gwen.minibolt.model.Restaurant;
import com.gwen.minibolt.repository.OrderItemRepository;
import com.gwen.minibolt.repository.RestaurantRepository;
import com.gwen.minibolt.repository.UserRepository;
import com.gwen.minibolt.service.ServiceInt.roleBase.AdminPrivilege;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class AdminPrivilegeImpl implements AdminPrivilege {
    private final UserRepository userRepository;
    private final ApiMapper apiMapper;
    private final RestaurantRepository restaurantRepository;
    private final OrderItemRepository orderItemRepository;

    @Override
    public UserDto changeUserRole(Long userid, ROLE role) {
        return userRepository.findById(userid).map(user -> {
            user.setRole(role);
            return apiMapper.userToUserDto(userRepository.save(user));
        }).orElseThrow();
    }

    @Override
    public UserDto SuspendUser(Long userId) {
        return this.userRepository.findById(userId).map(user -> {
            user.setDeleted(Boolean.TRUE);
            return apiMapper.userToUserDto(userRepository.save(user));
        }).orElseThrow();
    }

    @Override
    public RestaurantDto suspendRestaurant(Long restaurantId) {
        return this.restaurantRepository.findById(restaurantId).map(restaurant -> {
            restaurant.setIsActive(Boolean.FALSE);
            return apiMapper.restaurantToRestaurantDto(restaurant);
        }).orElseThrow();

    }

    @Override
    public Map<UserDto, List<RestaurantDto>> getRestaurantsAndOwners() {
        return restaurantRepository.findAll().stream()
                .filter(restaurant-> Objects.equals(restaurant.getOwner().isDeleted(),Boolean.TRUE))
                .collect(Collectors.groupingBy(r->apiMapper.userToUserDto(r.getOwner()),
                        collectingAndThen(toList(),list->list.stream().map(apiMapper::restaurantToRestaurantDto).toList())));
    }

    @Override
    public UserDto getRestaurantOwner(Long restaurantId) {
        return restaurantRepository.findById(restaurantId).map(Restaurant::getOwner)
                .map(apiMapper::userToUserDto).orElseThrow();
    }

    @Override
    public List<RestaurantDto> getOwnerRestaurant(Long userId) {
        return restaurantRepository.findAllByOwnerId(userId).stream().map(apiMapper::restaurantToRestaurantDto).toList();
    }

    @Override
    public List<OrderItemDto> getRestaurantOrders(Long restaurantId) {
        return orderItemRepository.findAllByRestaurantId(restaurantId)
                .stream().map(apiMapper::orderItemToOrderItemDto).toList();
    }
}
