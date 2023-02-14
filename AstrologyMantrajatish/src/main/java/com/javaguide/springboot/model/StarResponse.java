package com.javaguide.springboot.model;

import lombok.Data;

@Data
public class StarResponse {
	StarModelForGetAll starInfo;

	public StarResponse(StarModelForGetAll starInfo) {
		super();
		this.starInfo = starInfo;
	}
}
