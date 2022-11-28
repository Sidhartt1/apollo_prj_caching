package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ApolloPrjCachingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApolloPrjCachingApplication.class, args);
	}

}
