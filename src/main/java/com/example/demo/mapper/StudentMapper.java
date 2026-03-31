package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    Student toEntity(StudentDto dto);

    StudentDto fromEntity(Student student); 

	List<StudentDto> fromEntity(List<Student> list);

	void updateStudentFromDto(Student s,@MappingTarget  StudentDto dto);
	
}