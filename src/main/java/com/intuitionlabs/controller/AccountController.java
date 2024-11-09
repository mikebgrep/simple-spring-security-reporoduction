package com.intuitionlabs.controller;


import com.intuitionlabs.model.Customer;
import com.intuitionlabs.model.LoginDto;
import com.intuitionlabs.model.enums.Role;
import com.intuitionlabs.servcie.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController {


    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public AccountController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }


    @PostMapping
    public ResponseEntity<HttpStatus> postCustomerAccount(@RequestBody LoginDto dto) {
        Customer build = Customer.builder()
                .email(dto.getUsername())
                .password(passwordEncoder.encode(dto.getPassword()))
                .role(Role.ADMIN)
                .build();

        Customer savedCustomer = userService.save(build);

        return ResponseEntity.ok().build();
    }

}
