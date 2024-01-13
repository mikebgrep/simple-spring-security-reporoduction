package com.intuitionlabs.servcie.impl;


import com.intuitionlabs.model.User;
import com.intuitionlabs.repository.UserRepository;
import com.intuitionlabs.servcie.CustomerService;
import com.intuitionlabs.servcie.UserService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl  implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public <S extends User> S save(S user) {
        return repository.save(user);
    }


    @Override
    public User findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException(String.format("User with that id %d does not found", id)));
    }

    @Override
    public Optional<? extends User> findByEmail(String email) {
        return repository.findByEmail(email);
    }

}
