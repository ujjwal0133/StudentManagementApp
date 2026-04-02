package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.MarksDto;
import com.example.demo.entity.Marks;
import com.example.demo.mapper.MarksMapper;
import com.example.demo.repositories.EnrollmentRepo;
import com.example.demo.repositories.ExamRepo;
import com.example.demo.repositories.MarksRepository;

@Service
public class MarksService {
	
	@Autowired
	MarksMapper mapper;
	
	@Autowired
	MarksRepository repo;
	
	@Autowired
	ExamRepo erepo;
	
	@Autowired
	EnrollmentRepo enrepo;
	
	public void createMarks(MarksDto dto) {
		
		Marks a = new Marks();
		a.setMarksObtained(dto.getMarksObtained());
		a.setExamCode(erepo.findByExamId(dto.getExam_id()));;
		a.setEnrollment(enrepo.findByEnrollmentId(dto.getEnrollment_id()));
		
		repo.save(a);
		
	}
	
	public MarksDto getMarks(String enr) {
		
		Marks m = repo.findByEnrollment(enrepo.findByEnrollmentId(enr));
		return mapper.fromEntity(m);
		
	}
	
	public List<MarksDto> getAllMarks(){
		
		List<Marks> list = repo.findAll();
		return list
				.stream()
				.map(mapper::fromEntity)
				.toList();
	}
	
	public List<MarksDto> getMarksByExam(String exam_id){
		
		List<Marks> list = repo.findByExamCode(erepo.findByExamId(exam_id));
		return list
					.stream()
					.map(mapper::fromEntity)
					.toList();
	}
	
}
