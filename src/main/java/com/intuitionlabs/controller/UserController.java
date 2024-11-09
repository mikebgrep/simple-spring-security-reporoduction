package com.intuitionlabs.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/user/me")
	Object getMe(Authentication authentication) {
		return authentication.getPrincipal();
	}

}
