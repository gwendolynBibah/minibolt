package com.gwen.minibolt.Dtos.converters;

import com.gwen.minibolt.Dtos.*;
import com.gwen.minibolt.model.*;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ApiMapper {
    User userDtoToUser(UserDto userDto1);

    UserDto userToUserDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User updateUserFromUserDto(UserDto userDto1, @MappingTarget User user);

    @Mapping(source = "menuName", target = "menu.name")
    Food foodDtoToFood(FoodDto foodDto);

    @Mapping(source = "menu.name", target = "menuName")
    FoodDto foodToFoodDto(Food food);

    @Mapping(source = "menuName", target = "menu.name")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Food updateFoodFromFoodDto(FoodDto foodDto, @MappingTarget Food food);

    Menu menuDtoToMenu(MenuDto menuDto);

    MenuDto menuToMenuDto(Menu menu);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Menu updateMenuFromMenuDto(MenuDto menuDto, @MappingTarget Menu menu);

    @AfterMapping
    default void linkFoods(@MappingTarget Menu menu) {
        menu.getFoods().forEach(food -> food.setMenu(menu));
    }

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "userName", target = "user.name")
    @Mapping(source = "userRole", target = "user.role")
    Order orderDtoToOrder(OrderDto orderDto);

    @InheritInverseConfiguration(name = "orderDtoToOrder")
    OrderDto orderToOrderDto(Order order);

    @InheritConfiguration(name = "orderDtoToOrder")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Order updateOrderFromOrderDto(OrderDto orderDto, @MappingTarget Order order);

    @Mapping(source = "ownerName", target = "owner.name")
    @Mapping(source = "ownerRole", target = "owner.role")
    @Mapping(source = "imageContent", target = "image.content")
    Restaurant restaurantDtoToRestaurant(RestaurantDto restaurantDto);

    @InheritInverseConfiguration(name = "restaurantDtoToRestaurant")
    RestaurantDto restaurantToRestaurantDto(Restaurant restaurant);

    @InheritConfiguration(name = "restaurantDtoToRestaurant")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Restaurant updateRestaurantFromRestaurantDto(RestaurantDto restaurantDto, @MappingTarget Restaurant restaurant);
}
