package com.gwen.minibolt.serviceimpl.foodimpl;

import com.gwen.minibolt.model.Food;
import com.gwen.minibolt.model.Menu;
import com.gwen.minibolt.repository.FoodRepository;
import com.gwen.minibolt.repository.MenuRepository;
import com.gwen.minibolt.service.restaurant.RestaurantService1;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class RestaurantService1Impl implements RestaurantService1 {
 //creating a menu for the restaurant

    //create an instance of food repository to be used
    private FoodRepository foodRepository;

    //create a constructor of the class
    public RestaurantService1Impl(FoodRepository foodRepository) {
        this.foodRepository =foodRepository;
    }

    @Override
    public Food saveFood(Food food) {
        return foodRepository.save(food);
    }

    //deleting a particular food from the food repository
    @Override
    public String deleteFood(long id) {
        Optional<Food> food = foodRepository.findById(id);
        if (food.isPresent()){
            foodRepository.deleteById(id);
            return "Food has being deleted";
        }
        return null;
    }

    //creating / saving the menu
    @Autowired
    private MenuRepository menuRepository;

    @Override
    public Menu addMenu(Menu menu) {
        return menuRepository.save(menu);
    }



}
