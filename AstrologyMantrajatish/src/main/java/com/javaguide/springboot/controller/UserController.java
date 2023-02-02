package com.javaguide.springboot.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.javaguide.springboot.model.ReturnModel;
import com.javaguide.springboot.model.User;
import com.javaguide.springboot.model.UserResponse;
import com.javaguide.springboot.service.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {
	private UserService userService;

	
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	@GetMapping("/get-user")
	public ReturnModel getUser(@RequestParam String phone){
		try {
			User u = userService.getUserByPhone(phone);
			return new ReturnModel("200","ok",new UserResponse(u));
		}
		catch(Exception e){
			return new ReturnModel("502","user not found",e.getMessage());
		}
		
//		 return new ResponseEntity<>(userService.getUserByPhone(phone), HttpStatus.OK);
	        
	}
}
