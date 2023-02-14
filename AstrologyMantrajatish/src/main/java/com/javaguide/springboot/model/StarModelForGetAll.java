package com.javaguide.springboot.model;

import lombok.Data;

@Data
public class StarModelForGetAll {
	private long id;
	private String star_name;
	public StarModelForGetAll(long id, String star_name) {
		super();
		this.id = id;
		this.star_name = star_name;
	}
	
}
