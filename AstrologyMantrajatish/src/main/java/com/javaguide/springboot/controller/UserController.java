package com.javaguide.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.javaguide.springboot.model.ReturnModel;
import com.javaguide.springboot.model.User;
import com.javaguide.springboot.model.UserResponse;
import com.javaguide.springboot.model.UserUpdate;
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
	
	@RequestMapping(value="/admin/create-user", method = RequestMethod.POST)
	ReturnModel createUser(@RequestBody User user) throws Exception{
		try {
		User nUser = userService.saveUser(user);
		return new ReturnModel("200", "ok", new UserResponse(nUser));
		}
		catch(Exception e)
		{
			return new ReturnModel("502","user not created",e.getMessage());
		}
	}
	
	@RequestMapping(value="/admin/update-user", method = RequestMethod.POST)
	ReturnModel updateUser(@RequestBody UserUpdate userUpdate) throws Exception{
		try {
			System.out.println(userUpdate.toString());
		String msg = userService.updateUser(userUpdate);
		return new ReturnModel("200", "ok", msg);
		}
		catch(Exception e)
		{
			return new ReturnModel("502","user not updated",e.getMessage());
		}
	}
	
	@GetMapping("/get-pageable-user")
	public ReturnModel getPageableUser(@RequestParam String pageNo,@RequestParam String noOfitemPerPage){
		try {
			Pageable firstPageWithTwoElements = PageRequest.of(Integer.valueOf(pageNo), Integer.valueOf(noOfitemPerPage));
			List<UserResponse> userList = userService.getAllUser(firstPageWithTwoElements);
			return new ReturnModel("200","ok",userList);
		}
		catch(Exception e){
			return new ReturnModel("502","user not found",e.getMessage());
		}
		
//		 return new ResponseEntity<>(userService.getUserByPhone(phone), HttpStatus.OK);
	        
	}
	
}
