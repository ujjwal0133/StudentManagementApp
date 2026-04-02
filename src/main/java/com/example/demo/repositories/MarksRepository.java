package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Enrollment;
import com.example.demo.entity.Exam;
import com.example.demo.entity.Marks;

public interface MarksRepository extends JpaRepository<Marks,Long>{

	public Marks findByEnrollment(Enrollment byEnrollmentId);

	public List<Marks> findByExamCode(Exam examcode); 
	
}
