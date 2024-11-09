package com.intuitionlabs.servcie;


import com.intuitionlabs.model.Customer;
import com.intuitionlabs.model.User;

import java.util.Optional;
import java.util.Set;

public interface UserService  {

    <S extends User> S save(S entity);;

    User findById(Long id);

    Optional<? extends User> findByEmail(String email);

}
