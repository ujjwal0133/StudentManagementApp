package com.example.demo.entity;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

public enum Role {

	USER(List.of(
			
			Permission.STUDENT_READ,
			Permission.MARKS_READ,
			Permission.ENROLLMENT_READ,
			Permission.ATTENDANCE_READ
			
			)),
	
	
	
	
	ADMIN(List.of(
			
			Permission.STUDENT_READ,
			Permission.MARKS_READ,
			Permission.ENROLLMENT_READ,
			Permission.ATTENDANCE_READ,
			Permission.COURSE_READ,
			Permission.ATTENDANCE_EDIT,
			Permission.COURSE_EDIT,
			Permission.ENROLLMENT_EDIT,
			Permission.MARKS_EDIT,
			Permission.STUDENT_EDIT
			
			)),
	
	TEACHER(List.of(
			
			Permission.STUDENT_READ,
			Permission.MARKS_READ,
			Permission.ENROLLMENT_READ,
			Permission.ATTENDANCE_READ,
			Permission.COURSE_READ,
			Permission.ATTENDANCE_EDIT,
			Permission.MARKS_EDIT
			
			));
	
	
	private final List<Permission> permissions;
	
	Role(List<Permission> list) {
		this.permissions = list;
	}
	
	
	public List<Permission> getPermissions(){
		
		return permissions;
		
	}
	
	
}
