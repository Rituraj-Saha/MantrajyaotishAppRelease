package com.javaguide.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;



@SpringBootApplication
public class AstrologyMantrajatishApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(AstrologyMantrajatishApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(AstrologyMantrajatishApplication.class, args);
	}

}
