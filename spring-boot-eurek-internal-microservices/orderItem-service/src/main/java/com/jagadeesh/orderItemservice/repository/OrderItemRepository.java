package com.jagadeesh.orderItemservice.repository;



import com.jagadeesh.orderItemservice.model.OrderItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, Integer> {
}
