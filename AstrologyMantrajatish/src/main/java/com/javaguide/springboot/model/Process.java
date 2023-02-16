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
	
	@Column(name = "tips_bang", nullable=false)
	private String tips_bang;
	
	@Column(name = "puja_bang", nullable=false)
	private String puja_bang;
	
	@Column(name = "gen_info", nullable=false)
	private String gen_info;
	
	@Column(name = "gen_info_bang", nullable=false)
	private String gen_info_bang;
	
	@Column(name = "jantram_info", nullable=false)
	private String jantram_info;
	
	@Column(name = "jantram_info_bang", nullable=false)
	private String jantram_info_bang;
	
	@Column(name = "mantram_info", nullable=false)
	private String mantram_info;
	
	@Column(name = "mantram_info_bang", nullable=false)
	private String mantram_info_bang;
	
	
	
	 @OneToOne(mappedBy = "process")
	    private Star star;
}
