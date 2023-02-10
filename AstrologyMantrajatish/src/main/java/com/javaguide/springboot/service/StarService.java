package com.javaguide.springboot.service;

public interface StarService {
	String getMantram(String star_id);
	String getJantram(String star_id);
	String getTips(String star_id,String lang);
	String getPuja(String star_id,String lang);
	String getStarName(String star_id);
}
