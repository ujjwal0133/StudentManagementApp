package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.repositories.StudentRepo;

@Service
public class StudentService {

	@Autowired
	StudentRepo repo;
	
	@Autowired
	StudentMapper mapper;
	
	public void createStudent(StudentDto dto) {
		
		Student a = mapper.toEntity(dto);	
		repo.save(a);
	}
	
	public StudentDto getStudent(String a) {
		
		Student s = repo.findByRollNo(a);
		return mapper.fromEntity(s);
	}
	
	public List<StudentDto> getAll(){
		
		List<Student> list = repo.findAll();
		return mapper.fromEntity(list);
	}
	
	public void deleteStudent(String id) {
		
		repo.delete(repo.findByRollNo(id));
	}
	
	public void editStudent(String id,StudentDto dto) {
		
		Student s =  repo.findByRollNo(id);
		mapper.updateStudentFromDto(s,dto);
		repo.save(s);
	}
	
	
	
	
}
