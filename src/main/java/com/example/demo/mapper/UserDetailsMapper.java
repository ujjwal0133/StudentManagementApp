package com.example.demo.mapper;

import org.mapstruct.Mapper;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;

@Mapper(componentModel = "spring")
public interface UserDetailsMapper {

	public User toEntity(UserDto dto);
	
}
 