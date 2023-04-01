package com.gwen.minibolt.service.serviceImp.roleBase;

import com.gwen.minibolt.Dtos.MenuDto;
import com.gwen.minibolt.dto.FoodDto;
import com.gwen.minibolt.dto.OrderItemDto;
import com.gwen.minibolt.dto.RestaurantDto;
import com.gwen.minibolt.dto.UserDto;
import com.gwen.minibolt.dto.converters.ApiMapper;
import com.gwen.minibolt.dto.requests.MenuItemRequest;
import com.gwen.minibolt.enums.GENERAL_STATUS;
import com.gwen.minibolt.enums.ORDER_STATUS;
import com.gwen.minibolt.repository.FoodRepository;
import com.gwen.minibolt.repository.MenuRepository;
import com.gwen.minibolt.repository.OrderItemRepository;
import com.gwen.minibolt.repository.RestaurantRepository;
import com.gwen.minibolt.service.ServiceInt.FoodService;
import com.gwen.minibolt.service.ServiceInt.MenuService;
import com.gwen.minibolt.service.ServiceInt.roleBase.RestaurantPrivilege;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;


@Service
@RequiredArgsConstructor
public class RestaurantPrivilegeImpl implements RestaurantPrivilege {

    private final RestaurantRepository restaurantRepository;
    private final ApiMapper mapper;
    private final MenuRepository menuRepository;
    private final OrderItemRepository orderItemRepository;
    private final FoodRepository foodRepository;
    private final FoodService foodService;
    private final MenuService menuService;

    /**
     * @param restaurantId
     * @return
     */
    @Override
    public List<FoodDto> displayAllFoodByRestaurant(@NotNull Long restaurantId) {
        return menuRepository.findAllByRestaurantId(restaurantId)
                .stream().flatMap(menu -> menu.getFoods().stream().map(mapper::foodToFoodDto))
                .distinct().toList();
    }

    /**
     * @param restaurantId
     * @return
     */
    @Override
    public List<MenuDto> displayAllMenuByRestaurant(@NotNull Long restaurantId) {
        return menuService.getRestaurantMenuList(restaurantId);
    }

    /**
     * @param menuId
     * @param status
     * @return
     */
    @Override
    public MenuDto changeMenuStatus(@NotNull Long menuId, GENERAL_STATUS status) {
        return menuRepository.findById(menuId).map(menu -> {
            menu.setStatus(status);
            return mapper.menuToMenuDto(this.menuRepository.save(menu));
        }).orElseThrow();
    }

    /**
     * @param foodId
     * @param status
     * @return
     */
    @Override
    public FoodDto changeFoodStatus(Long foodId, GENERAL_STATUS status) {
        return foodRepository.findById(foodId).map(food -> {
            food.setStatus(status);
            return mapper.foodToFoodDto(foodRepository.save(food));
        }).orElseThrow();
    }

    /**
     * @param restaurantId
     * @param status
     * @return
     */
    @Override
    public RestaurantDto changeRestaurantStatus(Long restaurantId, GENERAL_STATUS status) {
        return restaurantRepository.findById(restaurantId).map(restaurant -> {
            restaurant.setStatus(status);
            restaurantRepository.save(restaurant);
            return mapper.restaurantToRestaurantDto(restaurant);
        }).orElseThrow();
    }

    /**
     * @param orderItemId
     * @param status
     * @return
     */
    @Override
    public OrderItemDto confirmOrderItem(Long orderItemId, ORDER_STATUS status) {
        return orderItemRepository.findById(orderItemId).map(orderItem -> {
            orderItem.setStatus(status);
            return mapper.orderItemToOrderItemDto(orderItem);
        }).orElseThrow();
    }

    /**
     * @param restaurantId
     * @return
     */
    @Override
    public List<UserDto> getRestaurantCustomers(Long restaurantId) {
        return orderItemRepository.findAllByRestaurantId(restaurantId)
                .stream().map(orderItem -> mapper.userToUserDto(orderItem.getOrder().getUser()))
                .toList();
    }

    /**
     * @param menuId
     * @return
     */
    @Override
    public List<UserDto> getRestaurantCustomersByMenu(Long menuId) {
        return menuRepository.findById(menuId).map(menu -> menu.getFoods().stream()
                        .flatMap(food -> orderItemRepository.findAllByFoodId(food.getId())
                                .stream().map(orderItem -> mapper.userToUserDto(orderItem.getOrder().getUser())))
                        .toList())
                .orElseThrow();
    }

    /**
     * @param restaurantId
     * @param foodId
     * @return
     */
    @Override
    public List<UserDto> getRestaurantCustomersByFood(Long restaurantId, Long foodId) {
        return orderItemRepository.findAllByFoodIdAndRestaurantId(foodId, restaurantId).stream()
                .map(orderItem -> mapper.userToUserDto(orderItem.getOrder().getUser())).toList();
    }

    /**
     * @param restaurantId
     * @return
     */
    @Override
    public Map<UserDto, List<OrderItemDto>> getCustomersAndTheirOrdersByRestaurant(Long restaurantId) {
        return orderItemRepository.findAllByRestaurantId(restaurantId)
                .stream().collect(Collectors.groupingBy(orderItem -> mapper.userToUserDto(orderItem.getOrder().getUser()),
                        collectingAndThen(toList(), orderItems -> orderItems.stream().map(mapper::orderItemToOrderItemDto).toList())));
    }

    /**
     * @param restaurantId
     * @param itemRequest
     * @return
     */
    @Override
    public MenuDto removeMenuItem(Long restaurantId, MenuItemRequest itemRequest) {
        return menuRepository.findByRestaurantIdAndId(restaurantId, itemRequest.menuId()).map(menu -> {
            menu.getFoods().removeIf(food -> food.getId().equals(itemRequest.foodId()));
            foodService.deleteFood(itemRequest.foodId());
            return mapper.menuToMenuDto(menuRepository.save(menu));
        }).orElseThrow();
    }
}
