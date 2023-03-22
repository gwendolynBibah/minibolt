package com.gwen.minibolt.service.user;

import com.gwen.minibolt.model.Menu;
import com.gwen.minibolt.model.Order;
import com.gwen.minibolt.model.Restaurant;

import java.util.List;

public interface UserService1 {
    public List<Restaurant> viewRestaurants();

    public List<Menu> viewMenu();

    public List<Order> viewPrevOrders();
}
