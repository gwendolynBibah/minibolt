package com.gwen.minibolt.serviceimpl.foodimpl;

import com.gwen.minibolt.enums.FoodStatus;
import com.gwen.minibolt.enums.OrderStatus;
import com.gwen.minibolt.model.*;
import com.gwen.minibolt.repository.FoodRepository;
import com.gwen.minibolt.repository.MenuRepository;
import com.gwen.minibolt.repository.OrderItemRepository;
import com.gwen.minibolt.repository.RestaurantRepository;
import com.gwen.minibolt.service.restaurant.RestaurantService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
@Service
public class RestaurantService1Impl implements RestaurantService1 {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public Food saveFood(Food food) {
        return foodRepository.save(food);
    }

    @Override
    public String deleteFood(long id) {
       Food food = foodRepository.findById(id).orElseThrow(()-> new RuntimeException("Food not found"));
            foodRepository.deleteById(food.getFoodId());
            return "Food has being deleted";
    }

    @Override
    //this id is the restaurant id as a menu belongs to a restaurant
    public List<Menu> viewMenu(long id) {
        Restaurant selectedRestaurant = restaurantRepository.findById(id).orElseThrow(()-> new RuntimeException("Restaurant not found"));
        return menuRepository.findAllByRestaurant_RestaurantId(selectedRestaurant.getRestaurantId());
    }

    @Override
    public Map<MiniboltUser, List<OrderItem>> getUsersAndOrderItemsByRestaurantId(long restaurantId) {
        List<OrderItem> orderItemList = orderItemRepository.findAllByRestaurant_RestaurantId(restaurantId);
        List<MiniboltUser> customers = orderItemList.stream().map(orderItem -> orderItem.getOrder().getMiniboltUser()).toList();
        Map<MiniboltUser, List<OrderItem>> customersAndOrderItems = new HashMap<>();
        for ( MiniboltUser user: customers ) {
            List<OrderItem> userOrder = new ArrayList<>();
            for (OrderItem orderItem : orderItemList) {
                if(user == orderItem.getOrder().getMiniboltUser()) {
                    userOrder.add(orderItem);
                }
            }
            customersAndOrderItems.put(user, userOrder);
        }
        return customersAndOrderItems;
     // return orderItemRepository.findAllByRestaurant_RestaurantId(restaurantId).stream().collect(Collectors.groupingBy(orderItem-> orderItem.getOrder().getMiniboltUser()));
    }

    @Override
    public String restaurantFoodStatus(FoodStatus foodStatus) {
       return switch (foodStatus) {
            case AVAILABLE -> "Available";

            case OUT_OF_STOCK -> "Out Of Stock";

           default -> "";
        };
    }

    @Override
    public String foodApprovedOrRejected(OrderStatus orderStatus) {
      return  switch (orderStatus) {
            case ACCEPTED ->  "You've accepted this user's order";

            case REJECTED ->  "You've rejected this user's order";

          default -> "";
        };
    }

    @Override
    public Menu addMenu(Menu menu) {
        return menuRepository.save(menu);
    }



}
