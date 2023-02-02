package com.javaguide.springboot.model;

import jakarta.persistence.UniqueConstraint;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="user", uniqueConstraints = @UniqueConstraint(columnNames = "phone"))
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name", nullable=false)
	private String name;
	
	@Column(name = "phone", nullable=false)
	private String phone;
	
	@Column(name = "date_of_birth", nullable=false)
	private String date_of_birth;
	
	@Column(name = "time_of_birth", nullable=false)
	private String time_of_birth;
	
	@Column(name = "place_of_birth", nullable=false)
	private String place_of_birth;
	
	@Column(name = "registration_date", nullable=false)
	private String registration_date;
	
	@Column(name = "payment_status", nullable=false)
	private String payment_status;
	
	@Column(name = "payment_amt", nullable=false)
	private String payment_amt;
	
	@Column(name = "payment_date", nullable=false)
	private String payment_date;
	
	
	@Column(name = "star_id", nullable=false)
	private String star_id;
	
	
	@Column(name = "session_status", nullable=false)
	private String session_status;
	
	
}
