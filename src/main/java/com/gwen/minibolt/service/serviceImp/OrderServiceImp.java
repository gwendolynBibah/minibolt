package com.gwen.minibolt.service.serviceImp;

import com.gwen.minibolt.Dtos.OrderDto;
import com.gwen.minibolt.Dtos.converters.ApiMapper;
import com.gwen.minibolt.repository.OrderRepository;
import com.gwen.minibolt.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class OrderServiceImp implements OrderService {
    private final OrderRepository orderRepository;
    private final ApiMapper mapper;
    @Override
    public List<OrderDto> getAllOrder() {
        return null;
    }

    @Override
    public OrderDto createOrder(OrderDto order) {
        return null;
    }

    @Override
    public OrderDto getOrder(long id) {
        return null;
    }

    @Override
    public void deleteOrder(Long id) {

    }
}
