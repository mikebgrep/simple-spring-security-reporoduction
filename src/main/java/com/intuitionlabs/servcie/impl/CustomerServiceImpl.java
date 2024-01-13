package com.intuitionlabs.servcie.impl;


import com.intuitionlabs.model.Customer;
import com.intuitionlabs.repository.CustomerRepository;
import com.intuitionlabs.servcie.CustomerService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer save(Customer customer) {
        return repository.save(customer);
    }


    @Override
    public Customer findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Customer with that id %d does not exists", id)));
    }

    @Override
    public Customer findByEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Customer with that email %s does not exists", email)));
    }

    @Override
    public Optional<Customer> findByEmailOptional(String email) {
        return repository.findByEmail(email);
    }



}
