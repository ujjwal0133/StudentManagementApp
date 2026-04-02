package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.demo.dto.MarksDto;
import com.example.demo.entity.Marks;

@Mapper(componentModel = "spring")
public interface MarksMapper {

	
	@Mapping(target = "exam_id", source = "examCode.examId")
	@Mapping(target = "enrollment_id", source = "enrollment.enrollmentId")
	public MarksDto fromEntity(Marks marks);
	

}

