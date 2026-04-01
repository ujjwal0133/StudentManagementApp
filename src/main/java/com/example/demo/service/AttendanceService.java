package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AttendanceDto;
import com.example.demo.entity.Attendance;
import com.example.demo.entity.Enrollment;
import com.example.demo.mapper.AttendanceMapper;
import com.example.demo.repositories.AttendanceRepo;

@Service
public class AttendanceService {
	
	@Autowired
	AttendanceMapper mapper;
	
	@Autowired
	AttendanceRepo repo;
	
	@Autowired
	EnrollmentService eser;

	public void createAttendance(AttendanceDto dto) {
		Attendance a = mapper.toEntity(dto);
		repo.save(a);
	}
	
	public AttendanceDto getAttendance(String sid, String cid) {
		
		Enrollment e = eser.fromStudentAndCourse(sid, cid);
		Attendance a = repo.findByEnrollment(e);
		
		return mapper.fromEntity(a);
	}
	
	public List<AttendanceDto> getAll(LocalDate date) {
		
		List<Attendance> list = repo.findByDate(date);
		return list	
				.stream()
				.map(mapper::fromEntity)
				.toList();
	}
	
	public void updateAttendance(AttendanceDto dto) {
		Enrollment e = eser.fromStudentAndCourse(dto.getStudent_id(), dto.getCourse_id());
		Attendance a = repo.findByEnrollment(e);
		
		a.setPresent(dto.isPresent());
		
		repo.save(a);
		
	}
	
	public void deleteAttendance(AttendanceDto dto) {
		Enrollment e = eser.fromStudentAndCourse(dto.getStudent_id(), dto.getCourse_id());
		Attendance a = repo.findByEnrollment(e);
		
		repo.delete(a);
		
	}	 
}
