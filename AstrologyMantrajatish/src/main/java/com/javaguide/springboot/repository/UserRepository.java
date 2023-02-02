package com.javaguide.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javaguide.springboot.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "SELECT * FROM user WHERE phone = ?1", nativeQuery = true)
	Optional<User> findByphone(String phone);
}
