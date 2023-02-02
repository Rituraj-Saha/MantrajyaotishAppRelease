package com.javaguide.springboot.model;

import lombok.Data;

@Data
public class UserResponse {
	User user;

	public UserResponse(User user) {
		super();
		this.user = user;
	}
	
}
