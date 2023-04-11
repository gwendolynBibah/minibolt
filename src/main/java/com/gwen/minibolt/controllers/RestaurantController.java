package com.gwen.minibolt.controllers;

import com.gwen.minibolt.Dtos.MenuDto;
import com.gwen.minibolt.dto.*;
import com.gwen.minibolt.dto.converters.ApiMapper;
import com.gwen.minibolt.dto.requests.MenuItemRequest;
import com.gwen.minibolt.dto.subDto.RestaurantSubDto;
import com.gwen.minibolt.enums.GENERAL_STATUS;
import com.gwen.minibolt.enums.ORDER_STATUS;
import com.gwen.minibolt.service.ServiceInt.FileManagementService;
import com.gwen.minibolt.service.ServiceInt.RestaurantService;
import com.gwen.minibolt.service.ServiceInt.roleBase.AdminPrivilege;
import com.gwen.minibolt.service.ServiceInt.roleBase.RestaurantPrivilege;
import com.gwen.minibolt.service.ServiceInt.roleBase.UserPrivilege;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/restaurants")
public class RestaurantController {
    private final RestaurantService restaurantService;
    private final ApiMapper apiMapper;
    private final AdminPrivilege adminPrivilege;
    private final UserPrivilege userPrivilege;
    private final RestaurantPrivilege restaurantPrivilege;
    private final FileManagementService fileManagementService;

    @GetMapping
    public List<RestaurantSubDto> getRestaurants() {
        return this.restaurantService.getRestaurants();
    }

    @PostMapping
    public RestaurantDto registerRestaurant(RegisterRestaurantDto restaurant) {
        return this.apiMapper.restaurantToRestaurantDto(this.restaurantService.createRestaurant(restaurant));
    }

    @GetMapping("restaurant")
    public RestaurantDto getRestaurant(@RequestParam(value = "id") @NotNull String id) {
        return this.restaurantService.getRestaurant(id);
    }

    @GetMapping("{restaurantId}/menu/list")
    public List<MenuDto> displayAllMenuByRestaurant(@PathVariable String restaurantId) {
        return this.restaurantPrivilege.displayAllMenuByRestaurant(restaurantId);
    }

    @PatchMapping
    public RestaurantDto updateRestaurant(@RequestParam("id") @NotNull String id, @RequestBody RegisterRestaurantDto restaurantDto) {
        return this.restaurantService.updateRestaurant(id, restaurantDto);
    }

    @DeleteMapping
    public void removeRestaurant(@RequestParam(value = "id") @NotNull String id) {
        this.restaurantService.deleteRestaurant(id);
    }


    //privileges for a user
    @PostMapping("{restaurantId}")
    public RestaurantDto rateARestaurant(@RequestBody double rating, @PathVariable String restaurantId) {
        return this.userPrivilege.rateRestaurant(restaurantId, rating);
    }

    @GetMapping("{restaurantId}/foodList")
    public List<FoodDto> displayAllFoodByRestaurant(@PathVariable String restaurantId) {
        return this.restaurantPrivilege.displayAllFoodByRestaurant(restaurantId);
    }

    @GetMapping("restaurant/{restaurantId}")
    public List<UserDto> getCustomersOfRestaurant(@PathVariable String restaurantId) {
        return this.restaurantPrivilege.getRestaurantCustomers(restaurantId);
    }

    @GetMapping("{restaurantId}/status/{status}")
    public RestaurantDto changeRestaurantStatus(@PathVariable String restaurantId, @PathVariable GENERAL_STATUS status) {
        return this.restaurantPrivilege.changeRestaurantStatus(restaurantId, status);
    }

    @PostMapping("{restaurantId}/food")
    public FoodDto changeFoodStatus(@PathVariable String restaurantId, @RequestParam("foodId") String foodId, @RequestBody GENERAL_STATUS status) {
        return this.restaurantPrivilege.changeFoodStatus(foodId, status);
    }

    @PostMapping("{restaurantId}/menu")
    public MenuDto changeMenuStatus(@PathVariable String restaurantId, @RequestParam String menuId, @RequestBody GENERAL_STATUS status) {
        return this.restaurantPrivilege.changeMenuStatus(menuId, status);
    }

    @PostMapping("{restaurantId}/orderItem")
    public OrderItemDto hm(@PathVariable String restaurantId, @RequestParam String orderItemId, @RequestBody ORDER_STATUS status) {
        return this.restaurantPrivilege.confirmOrderItem(orderItemId, status);
    }

    @GetMapping("{restaurantId}/customers/menu")
    public List<UserDto> getRestaurantCustomersByMenu(@PathVariable String restaurantId, @RequestParam String menuId) {
        return this.restaurantPrivilege.getRestaurantCustomersByMenu(menuId);
    }

    @GetMapping("{restaurantId}/customers/food")
    public List<UserDto> getRestaurantCustomersByFood(@RequestParam String foodId, @PathVariable @NotNull String restaurantId) {
        return this.restaurantPrivilege.getRestaurantCustomersByFood(restaurantId, foodId);
    }

    @GetMapping("{restaurantId}/customers")
    public Map<UserDto, List<OrderItemDto>> getCustomersAndTheirOrdersByRestaurant(@PathVariable String restaurantId) {
        return this.restaurantPrivilege.getCustomersAndTheirOrdersByRestaurant(restaurantId);
    }

    @PutMapping("{restaurantId}/menu-item")
    public MenuDto removeMenuItem(@PathVariable String restaurantId, @RequestBody MenuItemRequest menuItem) {
        return this.restaurantPrivilege.removeMenuItem(restaurantId, menuItem);
    }

    @GetMapping("/locations")
    public Map<String, List<RestaurantDto>> getRestaurantsGroupedByLocation() {
        return this.userPrivilege.getRestaurantGroupedByLocation();
    }

    @GetMapping("{restaurantId}/menu-list")
    public List<MenuDto> getRestaurantMenuByStatus(@PathVariable String restaurantId, @RequestParam GENERAL_STATUS status) {
        return this.userPrivilege.getRestaurantMenuByStatus(restaurantId, status);
    }

    @GetMapping("{location}")
    public List<RestaurantDto> lm(@PathVariable String location) {
        return this.userPrivilege.getRestaurantsByLocation(location);
    }

    @GetMapping("status")
    public List<RestaurantDto> getRestaurantByStatus(@RequestParam GENERAL_STATUS status) {
        return this.userPrivilege.getRestaurantsByStatus(status);
    }

    @GetMapping("locations/status")
    public List<RestaurantDto> getRestaurantByStatusAndLocation(@RequestParam String location, @RequestParam GENERAL_STATUS status) {
        return this.userPrivilege.getRestaurantsByStatusAndLocation(status, location);
    }

    //TODO::Change DTO
    @GetMapping("{restaurantId}/menu/food-prices")
    public List<MenuDto> getRestaurantMenuAndFoodPrices(@PathVariable String restaurantId) {
        return this.userPrivilege.getRestaurantMenuAndFoodPrices(restaurantId);
    }

    @GetMapping("owners")
    public Map<UserDto, List<RestaurantDto>> getRestaurantsAndTheirOwners(){
        return this.adminPrivilege.getRestaurantsAndOwners();
    }

    @GetMapping("{ownerId}")
    public List<RestaurantDto> getRestaurantByOwnerId(@PathVariable String ownerId){
        return this.adminPrivilege.getOwnerRestaurant(ownerId);
    }
    @GetMapping("{restaurantId}/owner")
    public UserDto getRestaurantOwner(@PathVariable String restaurantId){
        return this.adminPrivilege.getRestaurantOwner(restaurantId);
    }

    @GetMapping("{restaurantId}/orders")
    public List<OrderItemDto> getRestaurantOrders(@PathVariable String restaurantId){
        return this.adminPrivilege.getRestaurantOrders(restaurantId);
    }
    @PatchMapping("suspend/{restaurantId}")
    public RestaurantDto suspendRestaurant(@PathVariable String restaurantId){
        return this.adminPrivilege.suspendRestaurant(restaurantId);
    }
}
