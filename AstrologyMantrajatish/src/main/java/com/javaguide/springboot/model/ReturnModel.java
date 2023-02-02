package com.javaguide.springboot.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
public class ReturnModel {
	String response_code;
	String response_msg;
	Object response_body;
	public ReturnModel(String response_code, String response_msg, Object response_body) {
		super();
		this.response_code = response_code;
		this.response_msg = response_msg;
		this.response_body = response_body;
	}
}
