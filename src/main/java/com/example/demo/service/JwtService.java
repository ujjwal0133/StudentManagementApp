package com.example.demo.service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.demo.security.UserDetailsClass;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
	@Value("${jwt.token}")
	private String secretKey;
	
	public boolean isTokenValid(String token, UserDetails user) {
	
		return user.getUsername().equals(getUsername(token)) && !expired(token);
	}
	
	public String getUsername(String token) {
		return extractClaims(token, Claims::getSubject);
	} 
	
	
	public boolean expired(String token) {
		return extractClaims(token, Claims::getExpiration).before(new Date());
	}
	  
	
	//-----------------------------------------------------------------------------------------
	
	public <T> T extractClaims(String token,Function<Claims,T> resolver) {
		Claims claims = parseAllClaims(token);
		return resolver.apply(claims);
	}
	
	public Claims parseAllClaims(String token) {
		
		return 	Jwts.parserBuilder()
					.setSigningKey(getSigningKey())
					.build()
					.parseClaimsJws(token)
					.getBody();
					
	}
	
	private Key getSigningKey() {
		byte[] keyBytes = Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(keyBytes);
	}
	
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // 24hr
                .signWith(getSigningKey())
                .compact();
    }

}
