package com.shantisagar.restaurant_mgnt_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.shantisagar.restaurant_mgnt_service.repositories.UserRepository;
import com.shantisagar.restaurant_mgnt_service.services.auth.AuthServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class RestaurantMgntServiceApplication implements CommandLineRunner {


	@Autowired
	AuthServiceImpl authService;
	/* Important Notes:
	 * 		1) Once Spring security added: Default Username: user and password can be seen in console log
	 * 		
	 */

	public static void main(String[] args) {
		SpringApplication.run(RestaurantMgntServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		authService.createAnAdminAccount();
		log.info("============== Application Started ==============");
	}

}
