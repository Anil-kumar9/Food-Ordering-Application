package com.InventoryService.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import jakarta.servlet.http.HttpServletRequest;

import java.util.HashMap;

import org.springframework.http.HttpStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public String handleResourceNotFoundException(ProductAlreadyFoundException exception,
			HttpServletRequest request) {
		HashMap<String,String> response = new HashMap<>();
		response.put("url", request.getRequestURI());
		response.put("message", exception.getMessage());
		return response.toString();
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public String handleResourceNotFoundException(ProductNotFountException exception,
			HttpServletRequest request) {
		HashMap<String,String> response = new HashMap<>();
		response.put("url", request.getRequestURI());
		response.put("message", exception.getMessage());
		return response.toString();
	}
}
