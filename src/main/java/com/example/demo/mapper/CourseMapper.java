package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.example.demo.dto.CourseDto;
import com.example.demo.entity.Course;

@Mapper(componentModel = "spring")
public interface CourseMapper {

	Course toEntity(CourseDto dto);

	CourseDto fromEntity(Course c);

	List<CourseDto> fromEntity(List<Course> list);

	void updateFromDto(Course c,@MappingTarget CourseDto dto);
	 
	
}
