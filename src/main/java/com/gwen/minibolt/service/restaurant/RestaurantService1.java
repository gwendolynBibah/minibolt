package com.gwen.minibolt.service.restaurant;

import com.gwen.minibolt.enums.FoodStatus;
import com.gwen.minibolt.enums.OrderStatus;
import com.gwen.minibolt.model.Food;
import com.gwen.minibolt.model.Menu;
import com.gwen.minibolt.model.MiniboltUser;
import com.gwen.minibolt.model.OrderItem;

import java.util.List;
import java.util.Map;

public interface RestaurantService1 {
     Food saveFood(Food food);

    public Menu addMenu(Menu menu);

    public String deleteFood(long id);

    List <Menu> viewMenu(long id);

    public Map<MiniboltUser, List<OrderItem>> getUsersAndOrderItemsByRestaurantId(long restaurantId);

    String restaurantFoodStatus(FoodStatus foodStatus);

    String foodApprovedOrRejected(OrderStatus orderStatus);
}
