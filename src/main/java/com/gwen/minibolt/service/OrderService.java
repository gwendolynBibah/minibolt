package com.gwen.minibolt.service;

import com.gwen.minibolt.Dtos.OrderDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> getAllOrder();
    OrderDto createOrder(OrderDto order);
    OrderDto getOrder(long id);
    void deleteOrder(Long id);
}
