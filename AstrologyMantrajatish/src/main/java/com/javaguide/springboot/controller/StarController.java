package com.javaguide.springboot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaguide.springboot.model.ReturnModel;
import com.javaguide.springboot.model.StarResponse;
import com.javaguide.springboot.model.User;
import com.javaguide.springboot.model.UserResponse;
import com.javaguide.springboot.service.StarService;


@RestController
@RequestMapping("/api/user/star")
@CrossOrigin(origins = "*")
public class StarController {

	private StarService starService;
	
	public StarController(StarService starService) {
		super();
		this.starService = starService;
	}
	
	@GetMapping("/get-mantram")
	public ReturnModel getMantram(@RequestParam String starid){
		try {
			String mantram = starService.getMantram(starid);
			return new ReturnModel("200","ok",mantram);
		}
		catch(Exception e){
			return new ReturnModel("502","user not found",e.getMessage());
		}
		
//		 return new ResponseEntity<>(userService.getUserByPhone(phone), HttpStatus.OK);
	        
	}
	@GetMapping("/get-jantram")
	public ReturnModel getJantram(@RequestParam String starid){
		try {
			String mantram = starService.getJantram(starid);
			return new ReturnModel("200","ok",mantram);
		}
		catch(Exception e){
			return new ReturnModel("502","user not found",e.getMessage());
		}
		
//		 return new ResponseEntity<>(userService.getUserByPhone(phone), HttpStatus.OK);
	        
	}

	@GetMapping("/get-tips")
	public ReturnModel getTips(@RequestParam String starid,@RequestParam String lang){
		try {
			String mantram = starService.getTips(starid,lang);
			return new ReturnModel("200","ok",mantram);
		}
		catch(Exception e){
			return new ReturnModel("502","user not found",e.getMessage());
		}
		
//		 return new ResponseEntity<>(userService.getUserByPhone(phone), HttpStatus.OK);
	        
	}
	
	@GetMapping("/get-puja")
	public ReturnModel getPuja(@RequestParam String starid,@RequestParam String lang){
		try {
			String mantram = starService.getPuja(starid,lang);
			return new ReturnModel("200","ok",mantram);
		}
		catch(Exception e){
			return new ReturnModel("502","user not found",e.getMessage());
		}
		
//		 return new ResponseEntity<>(userService.getUserByPhone(phone), HttpStatus.OK);
	        
	}
	@GetMapping("/admin/get-all-stars")
	public ReturnModel getStarts(){
		try {
			List<StarResponse> stars = starService.getAllStars();
			return new ReturnModel("200","ok",stars);
		}
		catch(Exception e){
			return new ReturnModel("502","user not found",e.getMessage());
		}
		
//		 return new ResponseEntity<>(userService.getUserByPhone(phone), HttpStatus.OK);
	        
	}
}
