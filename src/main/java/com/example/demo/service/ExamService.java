package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ExamDto;
import com.example.demo.entity.Course;
import com.example.demo.entity.Exam;
import com.example.demo.mapper.ExamMapper;
import com.example.demo.repositories.CourseRepo;
import com.example.demo.repositories.ExamRepo;

@Service
public class ExamService {

	@Autowired
	ExamRepo repo;
	
	@Autowired
	CourseRepo crepo;
	
	@Autowired
	ExamMapper mapper;
	
	public void createExam(ExamDto dto) {
		
		Exam e = mapper.toEntity(dto);
		Course c = crepo.findByCode(dto.getCourse_id());
		e.setCourse(c);		
		repo.save(e);
		
	}
	
	public List<ExamDto> getAll(){
		
		List<Exam> list = repo.findAll();
		
		return list
				.stream()
				.map(mapper::fromEntity)
				.toList();
		
	}
	
}
