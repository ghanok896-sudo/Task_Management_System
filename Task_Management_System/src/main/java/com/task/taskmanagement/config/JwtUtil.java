package com.task.taskmanagement.config;
import java.util.Date;
import javax.crypto.SecretKey;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
public class JwtUtil {
   private static final String SECRET =
           "mysecretkeymysecretkeymysecretkey123456";
   private static final SecretKey SECRET_KEY =
           Keys.hmacShaKeyFor(SECRET.getBytes());
   public static String generateToken(String username) {
       return Jwts.builder()
               .setSubject(username)
               .setIssuedAt(new Date())
               .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
               .signWith(SECRET_KEY)
               .compact();
   }
}
