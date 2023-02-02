package com.javaguide.springboot.service;

import com.javaguide.springboot.model.User;

public interface UserService {
	User saveUser(User u);
	User getUserByPhone(String phone);
}
