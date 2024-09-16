package com.UserService.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserService.exceptions.UserAlreadyFoundException;
import com.UserService.exceptions.UserNotFoundException;
import com.UserService.model.User;
import com.UserService.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public String createUser(User user) throws UserAlreadyFoundException  {
		Optional<User> obj = repository.findById(user.getId());
		if(obj.isEmpty()) {
			repository.save(user);
			return "user created successfully";
		}else {
			throw new UserAlreadyFoundException("user already exist");
		}
	}
	
	public String updateUser(int id, User products) throws UserNotFoundException {
		Optional<User> product = repository.findById(id);
		if(product.isEmpty()) {
			throw new UserNotFoundException("user not found with the id: "+ id);
		}
		repository.save(products);
		return "user updated successf ully";
	}
	
	public User getUser(int id) throws UserNotFoundException {
		Optional<User> product = repository.findById(id);
		if(product.isEmpty()) {
			throw new UserNotFoundException("user not found with the id: "+ id);
		}
		return repository.findById(id).get();
	}
}
