package com.gwen.minibolt.serviceimpl.adminimpl;

import com.gwen.minibolt.model.Restaurant;
import com.gwen.minibolt.model.User;
import com.gwen.minibolt.repository.RestaurantRepository;
import com.gwen.minibolt.repository.UserRepository;
import com.gwen.minibolt.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AdminServiceImpl implements AdminService {

    //view all restaurants registed
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> viewAllRestaurants() {
        return restaurantRepository.findAll();
    }

    //view all users
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> viewAllUsers() {
        return userRepository.findAll();
    }

    //deleting a user
    @Override
    public String deleteUser(long id) {
    Optional<User> deletedUser = userRepository.findById(id);
    if (deletedUser.isPresent()) {
        userRepository.deleteById(id);
    }
    return "User is deleted";
    }

    //deleting a restaurant
    @Override
    public String deleteRestaurant(long id) {
        Optional<Restaurant> deletedRestaurant = restaurantRepository.findById(id);
        if (deletedRestaurant.isPresent()) {
            restaurantRepository.deleteById(id);
        }
        return "User is deleted";
    }

}
