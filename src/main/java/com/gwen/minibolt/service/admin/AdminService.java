package com.gwen.minibolt.service.admin;

import com.gwen.minibolt.model.Restaurant;
import com.gwen.minibolt.model.User;

import java.util.List;

public interface AdminService {
    public List<Restaurant> viewAllRestaurants();

    public List<User> viewAllUsers();

    public String deleteUser(long id);

    public String deleteRestaurant(long id);

}
