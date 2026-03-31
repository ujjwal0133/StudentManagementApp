package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {

	Student findByRollNo(String a); 

	
	
}
