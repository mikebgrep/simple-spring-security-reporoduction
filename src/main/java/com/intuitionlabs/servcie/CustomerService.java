package com.intuitionlabs.servcie;


import com.intuitionlabs.model.Customer;

import java.util.Optional;

public interface CustomerService {

    Customer save(Customer customer);


    Customer findById(Long id);
    Customer findByEmail(String email);
    Optional<Customer> findByEmailOptional(String email);


}
