package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CourseDto;
import com.example.demo.dto.EnrollmentDto;
import com.example.demo.entity.Course;
import com.example.demo.entity.Enrollment;
import com.example.demo.entity.Student;
import com.example.demo.repositories.CourseRepo;
import com.example.demo.repositories.EnrollmentRepo;
import com.example.demo.repositories.StudentRepo;

@Service
public class EnrollmentService {

	@Autowired
	EnrollmentRepo repo;
	
	@Autowired
	StudentRepo srepo;
	
	@Autowired
	CourseRepo crepo;
	
	
	public void createEnrollment(EnrollmentDto dto) {
		
		Student s = srepo.findByRollNo(dto.getStudent_id());
		Course c = crepo.findByCode(dto.getCourse_id());
		
		Enrollment enr = new Enrollment();
		
		enr.setStudent(s);
		enr.setCourse(c);
		enr.setEnrollmentId(dto.getEnrollment_id());
		
		
		repo.save(enr);
		
	}
	
	public EnrollmentDto getEnrollment(String id) {
			
		Enrollment enr = repo.findByEnrollmentId(id);
		
		EnrollmentDto dto = new EnrollmentDto();
		
		dto.setCourse_id(enr.getCourse().getCode());
		dto.setStudent_id(enr.getStudent().getRollNo());
		dto.setEnrollment_id(id);
		
		return dto;

	}
	
	public List<EnrollmentDto> getAll(){
		
		List<Enrollment> list = repo.findAll();
		
		return 
			list	
			.stream()
			.map(enr -> {
				
				EnrollmentDto dto = new EnrollmentDto();
				dto.setStudent_id(enr.getStudent().getRollNo());
				dto.setCourse_id(enr.getCourse().getCode());
				dto.setEnrollment_id(enr.getEnrollmentId());
				
				return dto;
			})
			.toList();
	}
	
	public void update(EnrollmentDto dto) {
		
		Enrollment enr = new Enrollment();
		
		Course c = crepo.findByCode(dto.getCourse_id());
		Student s = srepo.findByRollNo(dto.getStudent_id());
		
		
		enr.setCourse(c);
		enr.setStudent(s);
		enr.setEnrollmentId(dto.getEnrollment_id());
		
		repo.save(enr);
		
	}
	
	public void delete(String id) {
		
		repo.delete(repo.findByEnrollmentId(id));
		
	}
	
}
