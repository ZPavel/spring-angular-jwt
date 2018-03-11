package com.zpavel.service;

import com.zpavel.request.AuthenticationRequest;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.springframework.security.core.Authentication;

public interface AuthenticationService {
    Authentication getAuthentication(Jws<Claims> request);

    Authentication authenticate(AuthenticationRequest authenticationRequest);
}
