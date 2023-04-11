package com.gwen.minibolt.controllers;


import com.gwen.minibolt.Dtos.MenuDto;
import com.gwen.minibolt.dto.CreateMenuDto;
import com.gwen.minibolt.service.ServiceInt.MenuService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/menus")
public class MenuController {
    private final MenuService menuService;

    @GetMapping
    public List<MenuDto> getAllMenu() {
        return this.menuService.getAllMenu();
    }

    @PostMapping
    public MenuDto addMenu(@RequestBody CreateMenuDto menuDto) {
        return this.menuService.createMenu(menuDto);
    }

    @GetMapping("/restaurant")
    public List<MenuDto> getMenuByRestaurant(@RequestParam("id") @NotNull String id) {
        return this.menuService.getRestaurantMenuList(id);
    }

    @GetMapping("/restaurants")
    public Map<String, List<MenuDto>> getRestaurantAndTheirMenu() {
        return this.menuService.getAllRestaurantAndTheirMenu();
    }
}
