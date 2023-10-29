package com.FitGo;

import com.FitGo.model.Role;
import com.FitGo.model.User;
import com.FitGo.service.impl.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class FitGoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FitGoApplication.class, args);
	}


	@Bean
	PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

//	@Bean
//	CommandLineRunner run(UserService userService) {
//		return args -> {
//			userService.saveRole(new Role(null, "TRAINER"));
//			userService.saveRole(new Role(null, "TRAINEE"));
//
//			userService.saveUser(new User("John Doe", "john","user@gmail.com" ,"1234", new ArrayList<>()));
//			userService.saveUser(new User("James Smith", "james","user@gmail.com" ,"1234", new ArrayList<>()));
//			userService.saveUser(new User("Jane Carry", "jane","user@gmail.com" ,"1234", new ArrayList<>()));
//			userService.saveUser(new User("Chris Anderson", "chris","user@gmail.com" ,"1234", new ArrayList<>()));
//
//			userService.addRoleToUser("john", "TRAINER");
//			userService.addRoleToUser("james", "TRAINER");
//			userService.addRoleToUser("jane", "TRAINEE");
//			userService.addRoleToUser("chris", "TRAINEE");
//		};
//	}
}
