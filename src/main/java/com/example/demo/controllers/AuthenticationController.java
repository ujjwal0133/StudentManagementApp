package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.service.AuthenticationService;
import com.example.demo.service.JwtService;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

	@Autowired
	AuthenticationService service;
	
	@Autowired
	JwtService jwtService;
	 
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody UserDto dto){
		
		service.register(dto);
		return ResponseEntity.ok("User created!\nJWT TOKEN : "+jwtService.generateToken(dto.getUsername()));
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UserDto dto){
		System.out.println("Login endpoint working");
		service.login(dto);
		return ResponseEntity.ok("Login Successful!\n JWT TOKEN : " + jwtService.generateToken(dto.getUsername()));
		
	}
	
	
	
}
