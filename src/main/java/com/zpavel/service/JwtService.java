package com.zpavel.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

public interface JwtService {
    String createToken(String username);

    Jws<Claims> validateToken(String token);
}
