package com.InventoryService.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.InventoryService.model.Products;

@Repository
public interface InventoryRepository extends JpaRepository<Products, Integer>{

	@Query("SELECT SUM(p.price * p.quantity) FROM Products p")
    BigDecimal calculateTotalInventoryValue();
}
