package com.javaguide.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.javaguide.springboot.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "SELECT * FROM user WHERE phone = ?1", nativeQuery = true)
	Optional<User> findByphone(String phone);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE user SET name = ?1, date_of_birth = ?2 ,time_of_birth = ?3, place_of_birth = ?4, payment_status = ?5, payment_amt = ?6, payment_date = ?7, star_id = ?8 WHERE id = ?9", nativeQuery = true)
	void updateUser(
			String name,
			String date_of_birth,
			String time_of_birth,
			String place_of_birth,
			String payment_status,
			String payment_amt,
			String payment_date,
			String star_id,
			Long id);
	
}
