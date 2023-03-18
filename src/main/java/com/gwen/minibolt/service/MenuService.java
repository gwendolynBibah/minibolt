package com.gwen.minibolt.service;

import com.gwen.minibolt.Dtos.FoodDto;
import com.gwen.minibolt.Dtos.MenuDto;

import java.util.List;

public interface MenuService {
    List<MenuDto> getAllMenu();
    MenuDto createMenu(MenuDto food);
    MenuDto getMenu(long id);
    void deleteMenu(Long id);
}
