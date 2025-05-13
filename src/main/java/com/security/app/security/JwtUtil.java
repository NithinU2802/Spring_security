package com.security.app.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    @Value("${security.jwt.secret-key}")
    private String secret_key_value;

    private SecretKey SECRET_KEY=null;

    public String generateToken(UserDetails userDetails){
        generateSecretKey();
        return
                Jwts.builder()
                        .subject(userDetails.getUsername())
                        .issuedAt(new Date())
                        .expiration(new Date(System.currentTimeMillis() + (1000*60*60)))
                        .signWith(SECRET_KEY, Jwts.SIG.HS256)
                        .compact();
    }

    public void generateSecretKey() {
        SECRET_KEY = Keys.hmacShaKeyFor(secret_key_value.getBytes());
    }

    public boolean validateToken(String token, UserDetails userDetails){
        return extractUsername(token).equals(userDetails.getUsername());
    }

    public String extractUsername(String token){
        return Jwts.parser()
                .verifyWith(SECRET_KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

}
