package com.javaguide.springboot.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.javaguide.springboot.model.User;
import com.javaguide.springboot.model.UserResponse;

public interface UserService {
	User saveUser(User u);
	User getUserByPhone(String phone);
	List<UserResponse> getAllUser(Pageable pageable);
}
