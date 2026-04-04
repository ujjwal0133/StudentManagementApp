package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entity.User;

public interface UserDetailsRepo extends JpaRepository<User,Long>{

	Optional<User> findByUsername(String username);
 
}
