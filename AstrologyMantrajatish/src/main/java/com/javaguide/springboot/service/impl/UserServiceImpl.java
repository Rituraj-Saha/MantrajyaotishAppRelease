package com.javaguide.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.javaguide.springboot.exception.ResourceNotFoundException;
import com.javaguide.springboot.model.User;
import com.javaguide.springboot.model.UserResponse;
import com.javaguide.springboot.repository.UserRepoPagination;
import com.javaguide.springboot.repository.UserRepository;
import com.javaguide.springboot.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private UserRepoPagination userRepoPagination;
	
	
	public UserServiceImpl(UserRepository userRepository,UserRepoPagination userRepoPagination) {
		super();
		this.userRepository = userRepository;
		this.userRepoPagination = userRepoPagination;
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

	@Override
	public List<UserResponse> getAllUser(Pageable pageable) {
		// TODO Auto-generated method stub
	
		List<User> mUsers = userRepoPagination.findAll(pageable).toList();
		List<UserResponse> getPages = new ArrayList<>(); 
		for(User u:mUsers) {
			getPages.add(new UserResponse(u));
		}
		
		return getPages;
	}
	
	

}
