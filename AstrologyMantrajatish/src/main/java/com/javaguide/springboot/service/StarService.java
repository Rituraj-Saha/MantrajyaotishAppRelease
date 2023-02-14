package com.javaguide.springboot.service;

import java.util.List;

import com.javaguide.springboot.model.StarResponse;

public interface StarService {
	String getMantram(String star_id);
	String getJantram(String star_id);
	String getTips(String star_id,String lang);
	String getPuja(String star_id,String lang);
	String getStarName(String star_id);
	List<StarResponse> getAllStars();
}
