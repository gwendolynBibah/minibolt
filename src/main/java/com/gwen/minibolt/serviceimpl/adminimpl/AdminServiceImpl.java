package com.gwen.minibolt.serviceimpl.adminimpl;

import com.gwen.minibolt.model.Order;
import com.gwen.minibolt.model.OrderItem;
import com.gwen.minibolt.model.Restaurant;
import com.gwen.minibolt.model.MiniboltUser;
import com.gwen.minibolt.repository.OrderItemRepository;
import com.gwen.minibolt.repository.RestaurantRepository;
import com.gwen.minibolt.repository.MiniboltUserRepository;
import com.gwen.minibolt.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {


    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private MiniboltUserRepository userRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    //view all restaurants registered
    @Override
    public List<Restaurant> viewAllRestaurants() {
        return restaurantRepository.findAll();
    }

    //view all users
    @Override
    public List<MiniboltUser> viewAllUsers() {
        return userRepository.findAll();
    }

    //deleting a user
    @Override
    public String deleteUser(long id) {
       MiniboltUser unwantedMiniboltUser = userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
        userRepository.deleteById(unwantedMiniboltUser.getUserId());
        return "User is deleted";
    }

    //deleting a restaurant
    @Override
    public String deleteRestaurant(long id) {
        //lengthy way of deleting an entity
        Optional<Restaurant> deletedRestaurant = restaurantRepository.findById(id);
        if (deletedRestaurant.isPresent()) {
            restaurantRepository.deleteById(id);
        }
        return "User is deleted";
    }

    @Override
    public List<OrderItem> viewRestaurantOrders(long restaurantId) {
        Restaurant selectedRestaurant = restaurantRepository.findById(restaurantId).orElseThrow(()->new RuntimeException("Restaurant not found"));
        List<OrderItem> orderList = orderItemRepository.findAllByRestaurant_RestaurantId(restaurantId);
        return orderList;
    }

}
