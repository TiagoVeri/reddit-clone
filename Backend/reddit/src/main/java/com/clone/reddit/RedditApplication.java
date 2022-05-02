package com.clone.reddit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.clone.reddit.dto.RegisterRequest;
import com.clone.reddit.service.AuthService;

@SpringBootApplication
@EnableAsync
public class RedditApplication implements CommandLineRunner{
	

	@Autowired
	private AuthService authService;

	public static void main(String[] args) {
		SpringApplication.run(RedditApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		RegisterRequest registerRequest1 = new RegisterRequest();
		registerRequest1.setEmail("test1@test.com");
		registerRequest1.setPassword("1234");
		registerRequest1.setUsername("test1");

		authService.signup(registerRequest1);
		
		RegisterRequest registerRequest2 = new RegisterRequest();
		registerRequest2.setEmail("test2@test.com");
		registerRequest2.setPassword("1234");
		registerRequest2.setUsername("test2");

		authService.signup(registerRequest2);
	}

}
