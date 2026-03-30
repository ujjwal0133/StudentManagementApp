package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Enrollment;

public interface EnrollmentRepo extends JpaRepository<Enrollment,Long> {

}
