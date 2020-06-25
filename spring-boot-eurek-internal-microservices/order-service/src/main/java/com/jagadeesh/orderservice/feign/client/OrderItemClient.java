package com.jagadeesh.orderservice.feign.client;


import com.jagadeesh.orderItemservice.model.OrderItem;
import com.jagadeesh.orderservice.feign.config.CustomFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import java.util.List;

@FeignClient(name = "orderItem-service", url = "localhost:8089", configuration = CustomFeignConfig.class)
@Component
public interface OrderItemClient {

    @GetMapping("/orderItems")
    List<OrderItem> listOrderItems();

    @GetMapping("/orderItems/{id}")
    OrderItem getOrderItemById(@PathVariable String id);

    @PostMapping("/orderItems")
    OrderItem create(@RequestBody OrderItem orderItem);

    @RequestMapping(method = RequestMethod.GET, value = "/orderItems/order/{id}")
    OrderItem listOrderItemsByOrderId(@PathVariable int id);
}
