package com.example.demo.dto;

import java.time.LocalDate;

public class ExamDto {
	
	private String examId;
	private int totmarks;
	private LocalDate date;
	private String course_id;
	private String type;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getExamId() {
		return examId;
	}
	public void setExamId(String examId) {
		this.examId = examId;
	}
	public int getTotmarks() {
		return totmarks;
	}
	public void setTotmarks(int totmarks) {
		this.totmarks = totmarks;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	
	
	
	

}
