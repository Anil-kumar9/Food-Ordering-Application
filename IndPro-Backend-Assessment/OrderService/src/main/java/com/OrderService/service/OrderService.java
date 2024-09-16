package com.OrderService.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OrderService.exceptions.OrderNotFoundException;
import com.OrderService.exceptions.OrederAlredayFoundException;
import com.OrderService.model.OrderDto;
import com.OrderService.model.OrderItems;
import com.OrderService.model.Orders;
import com.OrderService.repository.OrderItemRepository;
import com.OrderService.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderrepo;
	@Autowired
	private OrderItemRepository orderItemrepo;
	
	
	public String createOrder(Orders orders) throws OrederAlredayFoundException {
		Optional<Orders> product = orderrepo.findById(orders.getId());
		if(product.isEmpty()) {	
			orderrepo.save(orders);
			return "product created successfully";
		}else {
			throw new OrederAlredayFoundException("product already exist");
		}
	}
	
	public Orders addOrderItems(int id, OrderItems item) throws OrderNotFoundException {
		Optional<Orders> order = orderrepo.findById(id);
		if(order.isEmpty()) {
			throw new OrderNotFoundException("order not found with id: "+id);
		}else {
			Orders orders = order.get();
			orders.setTotalPrice(orders.getTotalPrice()+item.getPrice());
			orderItemrepo.save(item);
			
			return orderrepo.getById(id);
		}
	}
	
	public OrderDto getTotalPrice(int id) throws OrderNotFoundException {
		Optional<Orders> order = orderrepo.findById(id);
		if(order.isEmpty()) {
			throw new OrderNotFoundException("order not found with id: "+id);
		}else {
			Orders orders = order.get();
			OrderDto dto = new OrderDto();
			dto.setOrderId(id);
			dto.setTotalPrice(orders.getTotalPrice());
			
			return dto;
		}
	}

}
