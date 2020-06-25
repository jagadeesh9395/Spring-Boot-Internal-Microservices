package com.jagadeesh.orderservice.dto;


import com.jagadeesh.orderItemservice.model.OrderItem;
import com.jagadeesh.orderservice.model.Order;


public class OrderDto extends Order {

    OrderItem orderItem;

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }
}
