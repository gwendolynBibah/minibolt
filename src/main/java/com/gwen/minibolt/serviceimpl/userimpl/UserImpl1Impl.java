package com.gwen.minibolt.serviceimpl.userimpl;

import com.gwen.minibolt.enums.OrderStatus;
import com.gwen.minibolt.enums.Role;
import com.gwen.minibolt.model.Menu;
import com.gwen.minibolt.model.Order;
import com.gwen.minibolt.model.Restaurant;
import com.gwen.minibolt.model.MiniboltUser;
import com.gwen.minibolt.repository.MenuRepository;
import com.gwen.minibolt.repository.MiniboltUserRepository;
import com.gwen.minibolt.repository.OrderRepository;
import com.gwen.minibolt.repository.RestaurantRepository;
import com.gwen.minibolt.service.user.UserService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImpl1Impl implements UserService1 {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private MiniboltUserRepository miniboltUserRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public MiniboltUser saveNewUser(MiniboltUser miniboltUser) {

        return miniboltUserRepository.save(miniboltUser);
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    //view all restaurants based on location
    @Override
    public List<Restaurant> viewRestaurants() {

        return restaurantRepository.findAll(Sort.by("location"));
    }

    //viewing a resturant's menu
    //!yet to add prices
    //I want to see a restaurant's menu and the prices of their foods.
    @Override
    public List<Menu> viewMenu(Long restaurantId) {
        //find the restaurant id
        //find the menu belonging to the selected menu
        Restaurant selectedRestaurant = restaurantRepository.findById(restaurantId).orElseThrow(() -> new RuntimeException("Restaurant doesn't exist"));
        return menuRepository.findAllByRestaurant_RestaurantId(selectedRestaurant.getRestaurantId());

    }

    //viewing prev orders
    @Override
    public List<Order> viewPrevOrders() {

        return orderRepository.findAll(Sort.by("timestamp"));
    }

    @Override
    public double userRating(double rating) {
        System.out.println("Pleave leave a rating");
        if (rating < 0 || rating > 5) {
            throw new RuntimeException("Input a number between from 1 to 5");
        }
        return rating;
    }

    @Override
    public Restaurant saveNewRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public String trackOrders(OrderStatus orderStatus) {
        return switch (orderStatus) {
            case PENDING -> "Waiting for the restaurant to accept your order";

            case ACCEPTED -> "Restaurant has accepted your order";

            case REJECTED -> "Restaurant has rejected your order";

            case IN_PROGRESS -> "Restaurant is making your order";

            case DELIVERING -> "The rider is on his way to you";

            case DELIVERED -> "The food has been delivered. Happy meals!";

            default -> "";
        };

    }

    @Override
    public String userRoles(Role role) {
        return switch(role) {
            case ADMIN -> "You're part of the admins of the app";
            case USER -> "You're a user";
            case OWNER -> "You own a restaurant";
        };
    }

    @Override
    public String deleteRestaurant(long id) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() -> new RuntimeException("Restaurant not found"));
        restaurantRepository.deleteById(restaurant.getRestaurantId());
        return "Restaurant has been deleted";
    }


}
