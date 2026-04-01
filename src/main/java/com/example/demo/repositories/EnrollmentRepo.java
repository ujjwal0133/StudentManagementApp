package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Course;
import com.example.demo.entity.Enrollment;
import com.example.demo.entity.Student;

public interface EnrollmentRepo extends JpaRepository<Enrollment,Long> {


	Enrollment findByEnrollmentId(String id);
	
	Enrollment findByStudentAndCourse(Student s,Course c);
	
} 
