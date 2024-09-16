package com.UserService.exceptions;

public class UserAlreadyFoundException extends Exception{

	public UserAlreadyFoundException(String msg) {
		super(msg);
	}
}
