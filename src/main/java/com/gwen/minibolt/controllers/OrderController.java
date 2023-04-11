package com.gwen.minibolt.controllers;

import com.gwen.minibolt.dto.OrderDto;
import com.gwen.minibolt.dto.OrderItemDto;
import com.gwen.minibolt.enums.ORDER_STATUS;
import com.gwen.minibolt.service.ServiceInt.OrderService;
import com.gwen.minibolt.service.ServiceInt.roleBase.AdminPrivilege;
import com.gwen.minibolt.service.ServiceInt.roleBase.RestaurantPrivilege;
import com.gwen.minibolt.service.ServiceInt.roleBase.UserPrivilege;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final OrderService orderService;
    private final UserPrivilege userPrivilege;
    private final AdminPrivilege adminPrivilege;
    private final RestaurantPrivilege restaurantPrivilege;

    //getOrder or orderItem =/id  or =orders/id/orderItems/
    //createOrder =/ or = orders/orderItems
    //deleteOrder =/id = orders/id/ordersItems/id
    //updateOrder =/=id  ==
    //getAllOrders = /

    @GetMapping
    public List<OrderDto> getAllOrders() {
        return this.orderService.getAllOrder();
    }

    @GetMapping("{orderId}")
    public OrderDto getOrder(@PathVariable String orderId) {
        return this.orderService.getOrder(orderId);
    }

    @PostMapping
    public OrderDto createOrder(@RequestBody OrderDto order) {
        return this.orderService.createOrder(order);
    }

    @PutMapping("{orderId}")
    public OrderDto updateOrder(@PathVariable String orderId, @RequestBody OrderDto orderDto) {
        return this.orderService.updateOrder(orderId, orderDto);
    }

    @DeleteMapping("{orderId}")
    public void deleteOrder(@PathVariable String orderId) {
        this.orderService.deleteOrder(orderId);
    }

    @GetMapping("{orderId}/status")
    public ORDER_STATUS getOrderStatus(@PathVariable String orderId) {
        return this.userPrivilege.getOrderStatus(orderId);
    }
    @PostMapping("order")
    public OrderDto placeOrder(@RequestBody List<OrderItemDto> orderItems){
        return this.userPrivilege.placeOrder(orderItems);
    }

    @PostMapping("order/Item")
    public OrderItemDto placeOrderItem(@RequestBody OrderItemDto orderItem){
        return this.userPrivilege.placeOrderItem(orderItem);
    }

//    @GetMapping
//    public void res(){
//
//
//    }


}
