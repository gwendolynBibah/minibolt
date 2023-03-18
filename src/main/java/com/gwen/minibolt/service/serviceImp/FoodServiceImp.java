package com.gwen.minibolt.service.serviceImp;

import com.gwen.minibolt.Dtos.FoodDto;
import com.gwen.minibolt.Dtos.converters.ApiMapper;
import com.gwen.minibolt.repository.FoodRepository;
import com.gwen.minibolt.service.FoodService;
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
    public FoodDto createFood(FoodDto food) {
        var a = mapper.foodDtoToFood(food);
        var b = foodRepository.save(a);
        return mapper.foodToFoodDto(b);
    }

    @Override
    public FoodDto getFood(long id) {
        return getFoodFromDatabase(id);
    }

    @Override
    public void deleteFood(Long id) {
        if (Objects.nonNull(id)) {
            Long userId = getFoodFromDatabase(id).id();
            foodRepository.deleteById(userId);
        }
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
