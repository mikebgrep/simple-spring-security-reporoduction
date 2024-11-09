package com.intuitionlabs.repository;

import com.intuitionlabs.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface CustomerRepository extends JpaRepository <Customer, Long> {

    Optional<Customer> findByEmail(String email);
}
