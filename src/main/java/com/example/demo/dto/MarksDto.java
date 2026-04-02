package com.example.demo.dto;

public class MarksDto {
		
	private String exam_id;
	private String enrollment_id;
	private int marksObtained;

	
	public String getExam_id() {
		return exam_id;
	}
	public void setExam_id(String exam_id) {
		this.exam_id = exam_id;
	}
	public String getEnrollment_id() {
		return enrollment_id;
	}
	public void setEnrollment_id(String enrollment_id) {
		this.enrollment_id = enrollment_id;
	}
	public int getMarksObtained() {
		return marksObtained;
	}
	public void setMarksObtained(int marksObtained) {
		this.marksObtained = marksObtained;
	}
	
	
	
}
