package com.example.demo.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.AttendanceDto;
import com.example.demo.entity.Attendance;
import com.example.demo.entity.Enrollment;
import com.example.demo.repositories.EnrollmentRepo;
import com.example.demo.service.EnrollmentService;

@Component
public class AttendanceMapper {
	
	
	@Autowired
	EnrollmentService eservice;

	public Attendance toEntity(AttendanceDto dto) {
		
		Attendance a = new Attendance();
		Enrollment e = eservice.fromStudentAndCourse(dto.getStudent_id(), dto.getCourse_id());
		
		a.setEnrollment(e);
		a.setDate(dto.getDate());
		a.setPresent(dto.isPresent());
		
		return a;
		
	}

	public AttendanceDto fromEntity(Attendance a) {
		
		AttendanceDto dto = new AttendanceDto();
		Enrollment e = a.getEnrollment();
		
		dto.setStudent_id(e.getStudent().getRollNo());
		dto.setCourse_id(e.getCourse().getCode());
		dto.setPresent(a.isPresent());
		dto.setDate(a.getDate());
		return dto;
	}
	
}
