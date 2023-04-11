package com.gwen.minibolt.service.serviceImp;

import com.gwen.minibolt.dto.OrderDto;
import com.gwen.minibolt.dto.converters.ApiMapper;
import com.gwen.minibolt.repository.OrderRepository;
import com.gwen.minibolt.service.ServiceInt.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
@Slf4j
public class OrderServiceImp implements OrderService {
    private final OrderRepository orderRepository;
    private final ApiMapper mapper;

    @Override
    public List<OrderDto> getAllOrder() {
        return orderRepository.findAll().stream().map(mapper::orderToOrderDto).toList();
    }

    @Override
    public OrderDto createOrder(OrderDto order) {
        return mapper.orderToOrderDto(orderRepository.save(mapper.orderDtoToOrder(order)));
    }

    @Override
    public OrderDto getOrder(String id) {
        return this.getOrderFromDatabase(id);
    }

    @Override
    public void deleteOrder(String id) {
        if (Objects.nonNull(id)) {
            orderRepository.findById(id).ifPresent(orderRepository::delete);
        }

    }

    /**
     * @param orderId
     * @param orderDto
     * @return
     */
    @Override
    public OrderDto updateOrder(String orderId, OrderDto orderDto) {
        return null;
    }

    private OrderDto getOrderFromDatabase(String id) {
        return orderRepository.findById(id).map(mapper::orderToOrderDto)
                .orElseThrow(() ->
                {
                    String message = String.format("Order with id %d not found.", id);
                    log.debug(message);
                    return new RuntimeException(message);
                });
    }

}
