package com.example.demo.controllers;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AttendanceDto;
import com.example.demo.dto.CourseDto;
import com.example.demo.dto.EnrollmentDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.service.AttendanceService;
import com.example.demo.service.CourseService;
import com.example.demo.service.EnrollmentService;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	StudentService service;
	
	@Autowired
	CourseService cservice;
	
	@Autowired
	EnrollmentService eservice;
	
	@Autowired
	AttendanceService aservice;
	
	@PostMapping
	public ResponseEntity<String> addStudent(@RequestBody StudentDto dto){
		
		service.createStudent(dto);
		return ResponseEntity.ok("Student Added");
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StudentDto> getStudent(@PathVariable String id){
		StudentDto s = service.getStudent(id);
		return ResponseEntity.ok(s);
	}
	
	@GetMapping
	public ResponseEntity<List<StudentDto>> getAll(){
		List<StudentDto> list = service.getAll();
		return ResponseEntity.ok(list);
	}
	
	@PostMapping("/course")
	public ResponseEntity<CourseDto> addCourse(@RequestBody CourseDto dto){
		
		cservice.createCourse(dto);
		return ResponseEntity.created(URI.create("/course/"+ dto.getCode())).body(dto);
	}
	
	@GetMapping("/course")
	public ResponseEntity<List<CourseDto>> getAllCourse(){
		return ResponseEntity.ok(cservice.getAll());
	}
	
	@GetMapping("/course/{id}")
	public ResponseEntity<CourseDto> getCourse(@PathVariable String id){
		return ResponseEntity.ok(cservice.getCourse(id));
	}
	
	@PutMapping("/course/{id}")
	public ResponseEntity<CourseDto> updateCourse(@PathVariable String id, @RequestBody CourseDto dto){
		cservice.update(id, dto);
		return ResponseEntity.ok(dto);
	}
	
	@DeleteMapping("/course/{id}")
	public ResponseEntity<Void>  deleteCourse(@PathVariable String id){
		cservice.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/enrollment")
	public ResponseEntity<String> createEnrollment(@RequestBody EnrollmentDto dto){
		eservice.createEnrollment(dto);
		return ResponseEntity.ok("Enrollment Created");
	}
	
	@GetMapping("/enrollment")
	public ResponseEntity<List<EnrollmentDto>> getAllEnrollment(){
		List<EnrollmentDto> list = eservice.getAll();
		return ResponseEntity.ok(list);
	}
	
	@PostMapping("/attendance")
	public ResponseEntity<String> setAttendance(@RequestBody AttendanceDto dto){
		
		aservice.createAttendance(dto);
		return ResponseEntity.ok("Attendance marked");
		
	}
	
	@GetMapping("/attendance/{date}")
	public ResponseEntity<List<AttendanceDto>> getAllAttendance(@PathVariable LocalDate date){
		
		List<AttendanceDto> list = aservice.getAll(date);
		
		return ResponseEntity.ok(list);
		
	}
	
	
	
}
