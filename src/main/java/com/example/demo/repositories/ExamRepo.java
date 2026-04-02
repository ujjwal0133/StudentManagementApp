package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Exam;

public interface ExamRepo extends JpaRepository<Exam,Long>{

	Exam findByExamId(String exam_id); 

}
