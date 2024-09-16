package com.InventoryService.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.InventoryService.Exception.ProductAlreadyFoundException;
import com.InventoryService.Exception.ProductNotFountException;
import com.InventoryService.model.Products;
import com.InventoryService.service.InventoryService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class InventoryController {

	@Autowired
	private InventoryService service;
	
	@PostMapping("/products")
	public ResponseEntity<String> addNewProduct(@RequestBody Products product) throws ProductAlreadyFoundException {
		return new ResponseEntity<String>(service.addProduct(product), HttpStatus.CREATED);
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestBody Products product) throws ProductNotFountException {
		return new ResponseEntity<String>(service.updateProduct(id, product), HttpStatus.OK);
	}
	
	@GetMapping("/inventory/value")
	public ResponseEntity<HashMap<String,BigDecimal>> getTotalInventoryValue() {
		return new ResponseEntity<HashMap<String,BigDecimal>>(service.getInventoryValue(), HttpStatus.OK);
	}
}
