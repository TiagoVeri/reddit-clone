package com.clone.reddit.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clone.reddit.dto.RegisterRequest;

@RestController
@RequestMapping(value = "/api/auth")
public class AuthController {

	@PostMapping
	public void signup(@RequestBody RegisterRequest registerRequest) {
		
	}
}
