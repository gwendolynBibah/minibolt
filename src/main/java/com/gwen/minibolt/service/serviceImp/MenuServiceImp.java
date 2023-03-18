package com.gwen.minibolt.service.serviceImp;

import com.gwen.minibolt.Dtos.MenuDto;
import com.gwen.minibolt.Dtos.converters.ApiMapper;
import com.gwen.minibolt.repository.MenuRepository;
import com.gwen.minibolt.service.MenuService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class MenuServiceImp implements MenuService {
    private final MenuRepository menuRepository;

    private final ApiMapper mapper;

    @Override
    public List<MenuDto> getAllMenu() {
        return null;
    }

    @Override
    public MenuDto createMenu(MenuDto food) {
        return null;
    }

    @Override
    public MenuDto getMenu(long id) {
        return null;
    }

    @Override
    public void deleteMenu(Long id) {

    }
}
