package com.javaguide.springboot.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javaguide.springboot.model.Star;
import com.javaguide.springboot.model.User;

public interface StarRepository extends JpaRepository<Star, Long> {
	
}
