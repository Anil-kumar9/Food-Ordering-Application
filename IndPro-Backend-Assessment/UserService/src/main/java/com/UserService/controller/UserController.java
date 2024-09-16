package com.UserService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UserService.exceptions.UserAlreadyFoundException;
import com.UserService.exceptions.UserNotFoundException;
import com.UserService.model.User;
import com.UserService.service.UserService;

@RestController
@RequestMapping
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/users")
	public String createuser(@RequestBody User user) throws UserAlreadyFoundException {
		return service.createUser(user);
	}
	
	@PutMapping("/users/{id}")
	public String updateUser(@PathVariable int id, @RequestBody User user) throws UserNotFoundException {
		return service.updateUser(id, user);
	}
	
	@GetMapping("users/{id}")
	public User getUser(@PathVariable int id) throws UserNotFoundException {
		return service.getUser(id);
	}
	
	

}
