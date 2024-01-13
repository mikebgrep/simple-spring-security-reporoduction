package com.intuitionlabs.model;

import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class JWTAuthResponse {

    private String accessToken;
    private String tokenType;
    private Long expiresIn;


}
