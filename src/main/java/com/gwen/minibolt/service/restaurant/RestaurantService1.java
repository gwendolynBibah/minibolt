package com.gwen.minibolt.service.restaurant;

import com.gwen.minibolt.model.Food;
import com.gwen.minibolt.model.Menu;

public interface RestaurantService1 {
    public Food saveFood(Food food);

    public Menu addMenu(Menu menu);

    public String deleteFood(long id);

}
