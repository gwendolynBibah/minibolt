package com.gwen.minibolt.service.serviceImp;

import com.gwen.minibolt.Dtos.RestaurantDto;
import com.gwen.minibolt.Dtos.converters.ApiMapper;
import com.gwen.minibolt.repository.RestaurantRepository;
import com.gwen.minibolt.service.RestaurantService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class RestaurantServiceImp implements RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final ApiMapper mapper;

    @Override
    public List<RestaurantDto> getAllRestaurant() {
        return null;
    }

    @Override
    public RestaurantDto createRestaurant(RestaurantDto order) {
        return null;
    }

    @Override
    public RestaurantDto getRestaurant(long id) {
        return null;
    }

    @Override
    public void deleteRestaurant(Long id) {

    }
}
