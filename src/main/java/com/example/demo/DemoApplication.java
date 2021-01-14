package com.example.demo;

import com.example.demo.config.User;
import com.example.demo.config.UserSecurityController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	private UserSecurityController userSecurityController;

	@PostConstruct
	private void initUsers(){

		List<User> users = Stream.of(
				new User((long) 101,"Kostya","123","kostya@gmail.com"),
				new User((long)	102,"Andrey","123","Andrey@gmail.com")

		).collect(Collectors.toList());

		userSecurityController.saveAll(users);

	}


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}
}
