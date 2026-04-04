package com.example.demo.controllers;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.example.demo.dto.ExamDto;
import com.example.demo.dto.MarksDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.service.AttendanceService;
import com.example.demo.service.CourseService;
import com.example.demo.service.EnrollmentService;
import com.example.demo.service.ExamService;
import com.example.demo.service.MarksService;
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
	
	@Autowired
	ExamService exservice;
	
	@Autowired
	MarksService marksService;
	
	@PreAuthorize("hasAuthority('STUDENT_EDIT')")
	@PostMapping
	public ResponseEntity<String> addStudent(@RequestBody StudentDto dto){
		
		service.createStudent(dto);
		return ResponseEntity.ok("Student Added");
		
	}

	@PreAuthorize("hasAuthority('STUDENT_READ')")
	@GetMapping("/{id}")
	public ResponseEntity<StudentDto> getStudent(@PathVariable String id){
		StudentDto s = service.getStudent(id);
		return ResponseEntity.ok(s);
	}
	
	@PreAuthorize("hasAuthority('STUDENT_READ')")
	@GetMapping
	public ResponseEntity<List<StudentDto>> getAll(){
		List<StudentDto> list = service.getAll();
		return ResponseEntity.ok(list);
	}
	
	@PreAuthorize("hasAuthority('COURSE_EDIT')")
	@PostMapping("/course")
	public ResponseEntity<CourseDto> addCourse(@RequestBody CourseDto dto){
		
		cservice.createCourse(dto);
		return ResponseEntity.created(URI.create("/course/"+ dto.getCode())).body(dto);
	}
	
	@PreAuthorize("hasAuthority('COURSE_READ')")
	@GetMapping("/course")
	public ResponseEntity<List<CourseDto>> getAllCourse(){
		return ResponseEntity.ok(cservice.getAll());
	}
	
	@PreAuthorize("hasAuthority('COURSE_READ')")
	@GetMapping("/course/{id}")
	public ResponseEntity<CourseDto> getCourse(@PathVariable String id){
		return ResponseEntity.ok(cservice.getCourse(id));
	}
	
	@PreAuthorize("hasAuthority('COURSE_READ')")
	@PutMapping("/course/{id}")
	public ResponseEntity<CourseDto> updateCourse(@PathVariable String id, @RequestBody CourseDto dto){
		cservice.update(id, dto);
		return ResponseEntity.ok(dto);
	}
	
	
	@PreAuthorize("hasAuthority('COURSE_EDIT')")
	@DeleteMapping("/course/{id}")
	public ResponseEntity<Void>  deleteCourse(@PathVariable String id){
		cservice.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasAuthority('ENROLLMENT_EDIT')")
	@PostMapping("/enrollment")
	public ResponseEntity<String> createEnrollment(@RequestBody EnrollmentDto dto){
		eservice.createEnrollment(dto);
		return ResponseEntity.ok("Enrollment Created");
	}
	
	@PreAuthorize("hasAuthority('ENROLLMENT_READ')")
	@GetMapping("/enrollment")
	public ResponseEntity<List<EnrollmentDto>> getAllEnrollment(){
		List<EnrollmentDto> list = eservice.getAll();
		return ResponseEntity.ok(list);
	}
	
	@PreAuthorize("hasAuthority('ATTENDANCE_EDIT')")
	@PostMapping("/attendance")
	public ResponseEntity<String> setAttendance(@RequestBody AttendanceDto dto){
		
		aservice.createAttendance(dto);
		return ResponseEntity.ok("Attendance marked");
		
	}

	@PreAuthorize("hasAuthority('ATTENDANCE_EDIT')")
	@GetMapping("/attendance/{date}")
	public ResponseEntity<List<AttendanceDto>> getAllAttendance(@PathVariable LocalDate date){
		
		List<AttendanceDto> list = aservice.getAll(date);
		
		return ResponseEntity.ok(list);
		
	}
	
	@PreAuthorize("hasAuthority('EXAM_EDIT')")
	@PostMapping("/exam")
	public ResponseEntity<String> createExam(@RequestBody ExamDto dto){
		exservice.createExam(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body("Exam Created Successfully !");
	}
	
	@PreAuthorize("hasAuthority('EXAM_EDIT')")
	@GetMapping("/exam")
	public ResponseEntity<List<ExamDto>> getAllExams(){
		List<ExamDto> list = exservice.getAll();
		return ResponseEntity.ok(list);
	}
	
	@PreAuthorize("hasAuthority('MARKS_EDIT')")
	@PostMapping("/marks")
	public ResponseEntity<Void> createMarks(@RequestBody MarksDto dto) {
	    marksService.createMarks(dto);
	    return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PreAuthorize("hasAuthority('MARKS_READ')")
	@GetMapping("/marks/{enrollmentId}")
	public ResponseEntity<MarksDto> getMarks(@PathVariable String enrollmentId) {
	    MarksDto dto = marksService.getMarks(enrollmentId);
	    return ResponseEntity.ok(dto);
	}

	@PreAuthorize("hasAuthority('MARKS_EDIT')")
	@GetMapping("/marks")
	public ResponseEntity<List<MarksDto>> getAllMarks() {
	    List<MarksDto> list = marksService.getAllMarks();
	    return ResponseEntity.ok(list);
	} 

	@PreAuthorize("hasAuthority('MARKS_EDIT')")
	@GetMapping("/marks/exam/{examId}")
	public ResponseEntity<List<MarksDto>> getMarksByExam(@PathVariable String examId) {
	    List<MarksDto> list = marksService.getMarksByExam(examId);
	    return ResponseEntity.ok(list);
	}
	
	
}
