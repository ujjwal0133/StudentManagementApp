package com.example.demo.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Attendance;
import com.example.demo.entity.Enrollment;

public interface AttendanceRepo extends JpaRepository<Attendance,Long>{

	Attendance findByEnrollment(Enrollment e);

	List<Attendance> findByDate(LocalDate date);
	
	
 
}
