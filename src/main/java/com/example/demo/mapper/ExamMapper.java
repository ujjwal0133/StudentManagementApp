package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.demo.dto.ExamDto;
import com.example.demo.entity.Exam;

@Mapper(componentModel = "spring")
public interface ExamMapper {

	public Exam toEntity(ExamDto dto); 
	
	@Mapping(target = "course_id", source = "course.code")
	public ExamDto fromEntity(Exam ex);
	
}
