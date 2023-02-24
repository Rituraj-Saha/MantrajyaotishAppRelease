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
import com.javaguide.springboot.model.UserUpdate;
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
		
		return userRepository.save(u);
	}

	@Override
	public User getUserByPhone(String phone) {
		
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

	
		List<User> mUsers = userRepoPagination.findAll(pageable).toList();
		List<UserResponse> getPages = new ArrayList<>(); 
		for(User u:mUsers) {
			getPages.add(new UserResponse(u));
		}
		
		return getPages;
	}

	@Override
	public String updateUser(UserUpdate userUpdate) {
		
		try {
			userRepository.updateUser(userUpdate.getName(), userUpdate.getDate_of_birth(), userUpdate.getTime_of_birth(), userUpdate.getPlace_of_birth(), userUpdate.getPayment_status(), userUpdate.getPayment_amt(), userUpdate.getPayment_date(),userUpdate.getStar_id(), userUpdate.getId());
			return "Updated Successfully";
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
		 	
	}
	
}
