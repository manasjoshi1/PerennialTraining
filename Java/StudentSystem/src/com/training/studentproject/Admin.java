package com.training.studentproject;

import java.sql.SQLException;

public class Admin {

	DataAccessLayer accessLayer=new DataAccessLayer();
	public int insertStudent(String name, String building, String city, String zipcode,Subject subjects[]) throws SQLException {
			Address address=new Address(building,city,zipcode);
			Student student=new Student(name,subjects,address);
			accessLayer.insertStudentIntoDb(student);
			return accessLayer.getRecentStudentId();
	}
}

