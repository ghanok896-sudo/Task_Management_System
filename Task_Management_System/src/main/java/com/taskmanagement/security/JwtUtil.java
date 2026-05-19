package com.taskmanagement.security;

	import java.security.Key;
   import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

	@Component
	public class JwtUtil {

	    private final String SECRET =
	            "mysecretkeymysecretkeymysecretkey12345";

	    private final Key key =
	            Keys.hmacShaKeyFor(SECRET.getBytes());

	    // Generate Token
	    public String generateToken(String email) {

	        return Jwts.builder()
	                .setSubject(email)
	                .setIssuedAt(new Date())
	                .setExpiration(
	                        new Date(System.currentTimeMillis()
	                                + 1000 * 60 * 60))
	                .signWith(key, SignatureAlgorithm.HS256)
	                .compact();
	    }

	    // Extract Username
	    public String extractUsername(String token) {

	        return Jwts.parserBuilder()
	                .setSigningKey(key)
	                .build()
	                .parseClaimsJws(token)
	                .getBody()
	                .getSubject();
	    }

	    // Validate Token
	    public boolean validateToken(String token) {

	        try {

	            Jwts.parserBuilder()
	                    .setSigningKey(key)
	                    .build()
	                    .parseClaimsJws(token);

	            return true;

	        } catch (Exception e) {

	            return false;
	        }
	    }
	}


