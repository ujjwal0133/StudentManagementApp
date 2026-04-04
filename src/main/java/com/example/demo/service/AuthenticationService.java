package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserDetailsMapper;
import com.example.demo.repositories.UserDetailsRepo;

@Service
public class AuthenticationService {

	@Autowired
	UserDetailsMapper mapper;
	
	@Autowired
	UserDetailsRepo repo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	AuthenticationManager authManager;
	
	public void register(UserDto dto) { 
		
		User user = mapper.toEntity(dto);
		user.setPassword(passwordEncoder.encode(dto.getPassword()));
		user.setRole(Role.ADMIN);
		repo.save(user);
		
	}
	
	public void login(UserDto dto) {
		User user = mapper.toEntity(dto);
		Authentication token =  authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(token);
		
	}
	
}
