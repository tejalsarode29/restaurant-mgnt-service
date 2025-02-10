package com.shantisagar.restaurant_mgnt_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class RestaurantMgntServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantMgntServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("============== Application Started ==============");
	}

}
