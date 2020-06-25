package com.jagadeesh.orderservice.controller;

import com.jagadeesh.orderItemservice.model.OrderItem;
import com.jagadeesh.orderservice.dto.OrderDto;
import com.jagadeesh.orderservice.feign.client.OrderItemClient;
import com.jagadeesh.orderservice.model.Order;
import com.jagadeesh.orderservice.repository.OrderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@RequestMapping("/orders")
@RestController
public class OrderController {

    @Autowired(required = true)
    private OrderItemClient orderItemClient;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("order/{id}")
    public Optional<Order> getCustomer(@PathVariable int id) {
        return orderRepository.findById(id);
    }

    @GetMapping("/{id}")
    public OrderDto getCustomerById(@PathVariable int id) {
        Optional<Order> customer = orderRepository.findById(id);
        OrderItem orderItems = orderItemClient.listOrderItemsByOrderId(id);
        OrderDto dto = new OrderDto();
        BeanUtils.copyProperties(customer, dto);
        dto.setOrderItem(orderItems);
        return dto;
    }

    @PostMapping
    public Order addOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

}
