package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CourseDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Course;
import com.example.demo.mapper.CourseMapper;
import com.example.demo.repositories.CourseRepo;

@Service
public class CourseService {

	@Autowired
	CourseMapper mapper;
	
	@Autowired
	CourseRepo repo;
	
	public void createCourse(CourseDto dto) {
		
		Course c = mapper.toEntity(dto);
		repo.save(c);
	}
	
	public CourseDto getCourse(String id) {
		
		Course c = repo.findByCode(id);
		return mapper.fromEntity(c);		
	}
	
	public List<CourseDto> getAll(){
		
		List<Course> list = repo.findAll();
		return mapper.fromEntity(list);
	}
	
	public void update(String id,CourseDto dto) {
		
		Course c = repo.findByCode(id);
		mapper.updateFromDto(c,dto);
		
		repo.save(c);
		
	}
	
	public void delete(String id) {
		repo.delete(repo.findByCode(id));
	}
	
}
