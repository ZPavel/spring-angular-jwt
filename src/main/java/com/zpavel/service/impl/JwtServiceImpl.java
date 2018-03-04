package com.zpavel.service.impl;

import com.zpavel.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class JwtServiceImpl implements JwtService {

    @Value("${token.secret}")
    private String secret;

    @Value("${token.expire}")
    private Integer expire;

    @Override
    public String createToken(String username) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, expire);

        Claims claims = new DefaultClaims();
        claims.setSubject(username);

        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, secret)
                .setClaims(claims)
                .setExpiration(calendar.getTime())
                .setIssuedAt(new Date())
                .compact();
    }

    @Override
    public Jws<Claims> validateToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
    }
}
