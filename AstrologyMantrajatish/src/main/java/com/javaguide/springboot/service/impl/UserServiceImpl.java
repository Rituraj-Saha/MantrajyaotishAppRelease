package com.javaguide.springboot.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.javaguide.springboot.exception.ResourceNotFoundException;
import com.javaguide.springboot.model.User;
import com.javaguide.springboot.repository.UserRepository;
import com.javaguide.springboot.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User saveUser(User u) {
		// TODO Auto-generated method stub
		return userRepository.save(u);
	}

	@Override
	public User getUserByPhone(String phone) {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findByphone(phone);
		if(user.isPresent()) {
			return user.get();
		}
		else
		{
			throw new ResourceNotFoundException("user","phone",phone);
		}
		
	}

}
