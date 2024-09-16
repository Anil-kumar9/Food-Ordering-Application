package com.OrderService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OrderService.exceptions.OrderNotFoundException;
import com.OrderService.exceptions.OrederAlredayFoundException;
import com.OrderService.model.OrderDto;
import com.OrderService.model.OrderItems;
import com.OrderService.model.Orders;
import com.OrderService.service.OrderService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class OrderController {

	@Autowired
	private OrderService service;
	
	@PostMapping("/orders")
	public String createOrder(@RequestBody Orders order ) throws OrederAlredayFoundException {
		return service.createOrder(order);
	}
	
	@PostMapping("/orders/{id}/items")
	public Orders addOrderItem(@PathVariable int id, @RequestBody OrderItems item) throws OrderNotFoundException {
		return service.addOrderItems(id, item);		
	}
	
	@GetMapping("/orders/{id}/total")
	public OrderDto getTotalPrice(@PathVariable int id) throws OrderNotFoundException {
		return service.getTotalPrice(id);
	}
}
