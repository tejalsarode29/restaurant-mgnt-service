package com.shantisagar.restaurant_mgnt_service.util;

import java.security.Key;
import java.util.Date;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
    private String generateToken(Map<String,Object> extraClaims, UserDetails details) {
        return Jwts.builder()
                    .setClaims(extraClaims)
                    .setSubject(details.getUsername())
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .setExpiration(new Date(System.currentTimeMillis() + 1000*60*60*24))
                    .signWith(getSigningKey(), SignatureAlgorithm.HS256).compact();
    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode("SldUU3VwZXJTZWNyZXQ=");
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
