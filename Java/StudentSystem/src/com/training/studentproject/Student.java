package com.training.studentproject;

public class Student {
	
	String studentName;
	int studentRollNumber;
	Subject subjects[];
	Address studentAddress;
	
	
	public Student(String studentName, Subject[] subjects, Address studentAddress) {
		this.studentName = studentName;
		this.subjects = subjects;
		this.studentAddress = studentAddress;
	}


	public String getStudentName() {
		return studentName;
	}


	public int getStudentRollNumber() {
		return studentRollNumber;
	}


	public Subject[] getSubjects() {
		return subjects;
	}


	public Address getStudentAddress() {
		return studentAddress;
	}
	
	
}
