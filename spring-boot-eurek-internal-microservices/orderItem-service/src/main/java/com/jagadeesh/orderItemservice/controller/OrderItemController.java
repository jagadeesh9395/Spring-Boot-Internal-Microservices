package com.jagadeesh.orderItemservice.controller;


import com.jagadeesh.orderItemservice.model.OrderItem;
import com.jagadeesh.orderItemservice.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class OrderItemController {

    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }

    @GetMapping
    public Iterable<OrderItem> listProducts() {
        return orderItemRepository.findAll();
    }

//    @GetMapping("/{id}")
//    private Product getProductById(@PathVariable String id) {
//        return DataStore.listProducts().stream().filter(prd -> prd.getId().equalsIgnoreCase(id)).findFirst().get();
//    }

    @PostMapping("/add")
    public OrderItem addProduct(@RequestBody OrderItem orderItem) {

        return orderItemRepository.save(orderItem);
    }

    @GetMapping("/customer/{id}")
    public Optional<OrderItem> listProductsByCustomerId(@PathVariable int id) {
        return orderItemRepository.findById(id);
    }
}
