package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;
import com.example.demo.repositories.UserDetailsRepo;

@Component
public class UserDetailsServiceClass implements UserDetailsService{

	
	@Autowired
	UserDetailsRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			
		User user = repo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found!")); 
		return new UserDetailsClass(user);	
	}
	
	

}
