package com.javaguide.springboot.model;

import lombok.Data;

@Data
public class UserUpdate {
	String name;
	String date_of_birth;
	String time_of_birth;
	String place_of_birth;
	String payment_status;
	String payment_amt;
	String payment_date;
	String star_id;
	Long id;
	public UserUpdate(String name, String date_of_birth, String time_of_birth, String place_of_birth,
			String payment_status, String payment_amt, String payment_date,String star_id, Long id) {
		super();
		this.name = name;
		this.date_of_birth = date_of_birth;
		this.time_of_birth = time_of_birth;
		this.place_of_birth = place_of_birth;
		this.payment_status = payment_status;
		this.payment_amt = payment_amt;
		this.payment_date = payment_date;
		this.star_id = star_id;
		this.id = id;
	}
}
