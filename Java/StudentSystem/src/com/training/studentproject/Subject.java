package com.training.studentproject;

public class Subject {
	String subjectName;
	int subjectMarks;
	public Subject(String subjectName, int subjectMarks) {
		this.subjectName = subjectName;
		this.subjectMarks = subjectMarks;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public int getSubjectMarks() {
		return subjectMarks;
	}
	
}
