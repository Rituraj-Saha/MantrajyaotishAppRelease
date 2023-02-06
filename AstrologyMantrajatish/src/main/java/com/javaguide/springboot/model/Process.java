package com.javaguide.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="process")
public class Process {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "mantram", nullable=false)
	private String mantram;
	
	@Column(name = "jantram", nullable=false)
	private String jantram;
	
	@Column(name = "tips", nullable=false)
	private String tips;
	
	@Column(name = "puja", nullable=false)
	private String puja;
	
	 @OneToOne(mappedBy = "process")
	    private Star star;
}
