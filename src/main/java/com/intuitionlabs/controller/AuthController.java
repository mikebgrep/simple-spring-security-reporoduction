package com.intuitionlabs.controller;


import com.intuitionlabs.model.JWTAuthResponse;
import com.intuitionlabs.model.LoginDto;
import com.intuitionlabs.servcie.AuthService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
 public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JWTAuthResponse> authenticate(@RequestBody LoginDto loginDto){
        JWTAuthResponse token = authService.login(loginDto);

        return ResponseEntity.ok(token);
    }



}
