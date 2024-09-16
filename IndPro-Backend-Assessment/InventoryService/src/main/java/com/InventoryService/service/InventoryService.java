package com.InventoryService.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InventoryService.Exception.ProductAlreadyFoundException;
import com.InventoryService.Exception.ProductNotFountException;
import com.InventoryService.model.Products;
import com.InventoryService.repository.InventoryRepository;

@Service
public class InventoryService {
	
	@Autowired
	private InventoryRepository repository;
	
	public String addProduct(Products products)throws ProductAlreadyFoundException {
		Optional<Products> product = repository.findById(products.getId());
		if(product.isEmpty()) {
			repository.save(products);
			return "product created successfully";
		}else {
			throw new ProductAlreadyFoundException("product already exist");
		}
	}
	
	public String updateProduct(int id, Products products) throws ProductNotFountException {
		Optional<Products> product = repository.findById(id);
		if(product.isEmpty()) {
			throw new ProductNotFountException("product not found with the id: "+ id);
		}
		repository.save(products);
		return "product updated successf ully";
	}
	
	public HashMap<String, BigDecimal> getInventoryValue() {
		HashMap<String,BigDecimal> map = new HashMap<>();
		BigDecimal totalValue = repository.calculateTotalInventoryValue();
		map.put("total_inventory_value" , totalValue);
		return map;
	}
	
	

}
