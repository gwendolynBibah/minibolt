package com.gwen.minibolt.service.ServiceInt;

import com.gwen.minibolt.Dtos.MenuDto;
import com.gwen.minibolt.dto.CreateMenuDto;

import java.util.List;
import java.util.Map;

public interface MenuService {
    List<MenuDto> getAllMenu();

    List<MenuDto> getRestaurantMenuList(Long restaurantId);

    Map<String, List<MenuDto>> getAllRestaurantAndTheirMenu();

    MenuDto createMenu(CreateMenuDto food);

    MenuDto getMenu(long id);

    void deleteMenu(Long id);
}
