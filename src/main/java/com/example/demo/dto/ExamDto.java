package com.example.demo.dto;

import java.time.LocalDate;

public class ExamDto {
	
	private String examId;
	private int totmarks;
	private LocalDate date;
	
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
	
	

}
