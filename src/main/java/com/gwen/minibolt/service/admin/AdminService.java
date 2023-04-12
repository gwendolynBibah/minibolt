package com.gwen.minibolt.service.admin;

import com.gwen.minibolt.model.Order;
import com.gwen.minibolt.model.OrderItem;
import com.gwen.minibolt.model.Restaurant;
import com.gwen.minibolt.model.MiniboltUser;

import java.util.List;

public interface AdminService {
    public List<Restaurant> viewAllRestaurants();

    public List<MiniboltUser> viewAllUsers();

    public String deleteUser(long id);

    public String deleteRestaurant(long id);

    public List<OrderItem> viewRestaurantOrders(long restaurantId);

}
