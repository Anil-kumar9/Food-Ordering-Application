package com.OrderService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OrderService.model.OrderItems;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItems,Integer>{

}
