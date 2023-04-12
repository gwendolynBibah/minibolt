package com.gwen.minibolt.service.user;

import com.gwen.minibolt.enums.OrderStatus;
import com.gwen.minibolt.enums.Role;
import com.gwen.minibolt.model.Menu;
import com.gwen.minibolt.model.Order;
import com.gwen.minibolt.model.Restaurant;
import com.gwen.minibolt.model.MiniboltUser;

import java.util.List;

public interface UserService1 {
     public MiniboltUser saveNewUser(MiniboltUser miniboltUser);

     public Order saveOrder(Order order);

    public List<Restaurant> viewRestaurants();

    public List<Menu> viewMenu(Long id);

    public List<Order> viewPrevOrders();

    public double userRating(double rating);

    //owner functions
    public Restaurant saveNewRestaurant(Restaurant restaurant);

    String deleteRestaurant(long id);

    String trackOrders(OrderStatus orderStatus);

    String userRoles(Role role);
}
