package com.example.demo.dto;

public class EnrollmentDto {
	
	private String student_id;
	private String course_id;
	
	
	
	public String getStudent_code() {
		return student_id;
	}
	public void setStudent_code(String student_code) {
		this.student_id = student_code;
	}
	public String getCourse_code() {
		return course_id;
	} 
	public void setCourse_code(String course_code) {
		this.course_id = course_code;
	}
	
	

}
