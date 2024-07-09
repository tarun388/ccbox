package com.verma.tarun.ccbox.security;

import java.util.Base64;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
    private final long EXPIRATION_TIME = 864_000_000; // 10 day
    private final String SECRET = "your-secret-key";
    
    public String generateToken(String user) {
        return Jwts.builder()
            .setSubject(user)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encodeToString(SECRET.getBytes()))
            .compact();
    }

    public Claims extractClaims(String token) {
        return Jwts.parser()
            .setSigningKey(Base64.getEncoder().encodeToString(SECRET.getBytes()))
            .parseClaimsJws(token)
            .getBody();
    }

    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    public boolean validateToken(String token, String username) {
        return username.equals(extractUsername(token)) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }
}
