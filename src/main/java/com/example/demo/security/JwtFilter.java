package com.example.demo.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.service.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter{

	@Autowired
	JwtService service;
	
	@Autowired
	UserDetailsServiceClass userService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String header = request.getHeader("Authorization");
		
		if(header == null || !header.startsWith("Bearer "))
		{
			filterChain.doFilter(request, response);
			return;
		} 
		
		String token = header.substring(7);
		String username = service.getUsername(token);
		
		if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			
			UserDetails user = userService.loadUserByUsername(username);
			
					if(service.isTokenValid(token, user)){
						
		                UsernamePasswordAuthenticationToken authToken =
		                        new UsernamePasswordAuthenticationToken(
		                            user,
		                            null,
		                            user.getAuthorities()
		                        );
		                
		                SecurityContextHolder.getContext().setAuthentication(authToken);
						
						
					}
			
		}
		
		filterChain.doFilter(request, response);
		
	}

}
