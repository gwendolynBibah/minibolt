package com.gwen.minibolt.serviceimpl.userimpl;

import com.gwen.minibolt.model.Menu;
import com.gwen.minibolt.model.Order;
import com.gwen.minibolt.model.Restaurant;
import com.gwen.minibolt.repository.MenuRepository;
import com.gwen.minibolt.repository.OrderRepository;
import com.gwen.minibolt.repository.RestaurantRepository;
import com.gwen.minibolt.service.user.UserService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import java.util.List;

public class UserImpl1Impl implements UserService1 {

    //view all restaurants based on location
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> viewRestaurants() {
        return restaurantRepository.findAll(Sort.by("location"));
    }


    //viewing a resturant's menu
    //!yet to add prices
    @Autowired
    private MenuRepository menuRepository;

    @Override
    public List<Menu> viewMenu() {
        return menuRepository.findAll();
    }

    //viewing prev orders
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> viewPrevOrders() {
        return orderRepository.findAll(Sort.by("timestamp"));
    }


}
