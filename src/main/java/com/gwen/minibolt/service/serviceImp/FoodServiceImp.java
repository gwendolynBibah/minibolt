package com.gwen.minibolt.service.serviceImp;

import com.gwen.minibolt.dto.CreateFoodDto;
import com.gwen.minibolt.dto.FoodDto;
import com.gwen.minibolt.dto.converters.ApiMapper;
import com.gwen.minibolt.repository.FoodRepository;
import com.gwen.minibolt.service.ServiceInt.FoodService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
@Slf4j
public class FoodServiceImp implements FoodService {
    private final FoodRepository foodRepository;
    private final ApiMapper mapper;

    @Override
    public List<FoodDto> getAllFood() {
        return foodRepository.findAll().stream().map(mapper::foodToFoodDto).toList();
    }

    @Override
    public FoodDto createFood(CreateFoodDto food) {


        return mapper.foodToFoodDto(foodRepository.save(mapper.createFoodDtoToFood(food)));
//        return menuRepository.findById(food.menuId()).map(existingMenu->{
//                Food newFood = mapper.createFoodDtoToFood(food);
//            System.out.println(newFood);
//                newFood.setMenu(existingMenu);
//        return mapper.foodToFoodDto(foodRepository.save(newFood));
//        }).orElseThrow();
    }

    @Override
    public FoodDto getFood(long id) {
        return getFoodFromDatabase(id);
    }

    @Override
    public void deleteFood(Long id) {
        if (Objects.nonNull(id)) {
            foodRepository.findById(id).ifPresent(foodRepository::delete);
        }
    }

    @Override
    public FoodDto updateFood(Long id, CreateFoodDto food) {
        return this.foodRepository.findById(id).map(existingFood ->
                mapper.foodToFoodDto(this.foodRepository.save(mapper.updateFoodFromCreateFoodDto(food, existingFood)))
        ).orElseThrow(() ->
                {
                    String message = String.format("Food with id %d not found.", id);
                    log.debug(message);
                    return new RuntimeException(message);
                }
        );
    }

    private FoodDto getFoodFromDatabase(long id) {
        return foodRepository.findById(id).map(mapper::foodToFoodDto)
                .orElseThrow(() ->
                {
                    String message = String.format("Food with id %d not found.", id);
                    log.debug(message);
                    return new RuntimeException(message);
                });
    }
}
