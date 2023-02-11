package com.javaguide.springboot.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.javaguide.springboot.model.User;

public interface UserRepoPagination extends PagingAndSortingRepository<User, Long>{

}
