package com.intuitionlabs.servcie;

import com.intuitionlabs.model.JWTAuthResponse;
import com.intuitionlabs.model.LoginDto;

public interface AuthService {
    JWTAuthResponse login(LoginDto loginDto);


}
