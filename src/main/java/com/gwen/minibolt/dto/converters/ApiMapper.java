package com.gwen.minibolt.dto.converters;

import com.gwen.minibolt.Dtos.MenuDto;
import com.gwen.minibolt.dto.*;
import com.gwen.minibolt.model.*;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ApiMapper {
    @Mapping(source = "userId", target = "id")
    @Mapping(source = "userName", target = "email")
//    @Mapping(source = "isActive", target = "isActive")
    User userDtoToUser(UserDto userDto);

    @InheritInverseConfiguration(name = "userDtoToUser")
    UserDto userToUserDto(User user);

    @InheritConfiguration(name = "userDtoToUser")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User updateUserFromUserDto(UserDto userDto1, @MappingTarget User user);

    @Mapping(source = "restaurant.location", target = "restaurant.location.name")
    Menu menuDtoToMenu(MenuDto menuDto);
    @InheritInverseConfiguration(name = "menuDtoToMenu")
    MenuDto menuToMenuDto(Menu menu);

    @InheritConfiguration(name = "menuDtoToMenu")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Menu updateMenuFromMenuDto(MenuDto menuDto, @MappingTarget Menu menu);

//    @AfterMapping
//    default void linkFoods(@MappingTarget Menu menu) {
//        menu.getFoods().forEach(food -> food.setMenu(menu));
//    }

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "userName", target = "user.email")
    @Mapping(source = "userRole", target = "user.role")
    Order orderDtoToOrder(OrderDto orderDto);

    @InheritInverseConfiguration(name = "orderDtoToOrder")
    OrderDto orderToOrderDto(Order order);

    @InheritConfiguration(name = "orderDtoToOrder")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Order updateOrderFromOrderDto(OrderDto orderDto, @MappingTarget Order order);


    @Mapping(source = "menuId", target = "menu.id")
    @Mapping(source = "menuName", target = "menu.name")
    @Mapping(source = "restaurantId", target = "menu.restaurant.id")
    @Mapping(source = "restaurantName", target = "menu.restaurant.name")
    Food foodDtoToFood(FoodDto foodDto);

    @InheritInverseConfiguration(name = "foodDtoToFood")
    FoodDto foodToFoodDto(Food food);

    @InheritConfiguration(name = "foodDtoToFood")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Food updateFoodFromFoodDto(FoodDto foodDto, @MappingTarget Food food);

    OrderItem orderItemDtoToOrderItem(OrderItemDto orderItemDto);

    OrderItemDto orderItemToOrderItemDto(OrderItem orderItem);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    OrderItem updateOrderItemFromOrderItemDto(OrderItemDto orderItemDto, @MappingTarget OrderItem orderItem);

    User updateUserRequestToUser(UpdateUserRequest updateUserRequest);

    UpdateUserRequest userToUpdateUserRequest(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User updateUserFromUpdateUserRequest(UpdateUserRequest updateUserRequest, @MappingTarget User user);

    User registerRequestToUser(RegisterRequest registerRequest);

    @Mapping(source = "ownerId", target = "owner.id")
    @Mapping(source = "location", target = "location.name")
    Restaurant registerRestaurantDtoToRestaurant(RegisterRestaurantDto registerRestaurantDto);

    @InheritInverseConfiguration(name = "registerRestaurantDtoToRestaurant")
    RegisterRestaurantDto restaurantToRegisterRestaurantDto(Restaurant restaurant);

    @InheritConfiguration(name = "registerRestaurantDtoToRestaurant")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Restaurant updateRestaurantFromRegisterRestaurantDto(RegisterRestaurantDto registerRestaurantDto, @MappingTarget Restaurant restaurant);


    @Mapping(source = "menuId", target = "menu.id")
    Food createFoodDtoToFood(CreateFoodDto createFoodDto);

    @Mapping(source = "menu.id", target = "menuId")
    CreateFoodDto foodToCreateFoodDto(Food food);

    @Mapping(source = "menuId", target = "menu.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Food updateFoodFromCreateFoodDto(CreateFoodDto createFoodDto, @MappingTarget Food food);

    @Mapping(source = "restaurantId", target = "restaurant.id")
    Menu createMenuDtoToMenu(CreateMenuDto createMenuDto);

    @Mapping(source = "restaurant.id", target = "restaurantId")
    CreateMenuDto menuToCreateMenuDto(Menu menu);

    @Mapping(source = "restaurantId", target = "restaurant.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Menu updateMenuFromCreateMenuDto(CreateMenuDto createMenuDto, @MappingTarget Menu menu);

    @Mapping(source = "ownerId", target = "owner.id")
    @Mapping(source = "ownerName", target = "owner.email")
    @Mapping(source = "location", target = "location.name")
    Restaurant restaurantDtoToRestaurant(RestaurantDto restaurantDto);

    @InheritInverseConfiguration(name = "restaurantDtoToRestaurant")
    RestaurantDto restaurantToRestaurantDto(Restaurant restaurant);

    @InheritConfiguration(name = "restaurantDtoToRestaurant")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Restaurant updateRestaurantFromRestaurantDto(RestaurantDto restaurantDto, @MappingTarget Restaurant restaurant);

    Town RRTownDtoToTown(RRTownDto RRTownDto);

    RRTownDto townToRRTownDto(Town town);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Town updateTownFromRRTownDto(RRTownDto RRTownDto, @MappingTarget Town town);

    @Mapping(source = "regionId", target = "region.id")
    @Mapping(source = "regionRegion", target = "region.region")
    Town townDtoToTown(TownDto townDto);

    @InheritInverseConfiguration(name = "townDtoToTown")
    TownDto townToTownDto(Town town);

    @InheritConfiguration(name = "townDtoToTown")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Town updateTownFromTownDto(TownDto townDto, @MappingTarget Town town);

//    @AfterMapping
//    default void linkMenus(@MappingTarget Restaurant restaurant) {
//        restaurant.getMenus().forEach(menu -> menu.setRestaurant(restaurant));
//    }
}
