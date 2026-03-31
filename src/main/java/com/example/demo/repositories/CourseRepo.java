package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Course;

public interface CourseRepo extends JpaRepository<Course,Long>{

	Course findByCode(String id);
 
}
