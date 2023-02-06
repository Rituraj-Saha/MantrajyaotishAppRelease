package com.javaguide.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javaguide.springboot.model.User;

public interface ProcessRepository extends JpaRepository<com.javaguide.springboot.model.Process, Long> {
	
}
