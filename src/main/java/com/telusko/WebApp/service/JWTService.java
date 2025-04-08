package com.telusko.WebApp.service;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTService {
    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<String, Object>();

        return Jwts.builder()
                .claims()
                .add( claims )
                .subject( username )
                .issuedAt( new Date( System.currentTimeMillis() ) )
                .expiration( new Date( System.currentTimeMillis() ) * 60 * 60 * 10 );
    }
}
