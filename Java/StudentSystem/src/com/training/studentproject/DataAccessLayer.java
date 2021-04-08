package com.training.studentproject;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Properties;

import com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping;
public class DataAccessLayer {
	private static Connection conn=null;
	private static PreparedStatement ptmt=null;
	private static ResultSet rset=null;
	static{
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentSystem", "root", "mysqlpass");	
	}catch (Exception e) {
		// TODO: handle exception
	}
		}
	
	public void insertStudentIntoDb(Student student) throws SQLException {
		
		String insertQuery="Insert into STUDENTS values(?,?,?,?,?,?,?,?,?,?);";
		PreparedStatement ps=conn.prepareStatement(insertQuery);
		ps.setString(1,student.getStudentName());
		ps.setString(2, student.getStudentAddress().getBuilding());
		ps.setString(3, student.getStudentAddress().getCity());
		ps.setString(4, student.getStudentAddress().getZipcode());
		Subject[] subjects=student.getSubjects();
		for(int i=0;i<subjects.length;i++)
			{
				ps.setString(5+i,subjects[i].getSubjectName());
				ps.setInt(6+i, subjects[i].getSubjectMarks());

			}
		ps.executeUpdate();  
		
	}
	
	public int getRecentStudentId() throws SQLException {
		String query="Select studentId from students orderby desc Limit=1";
		Statement stmt=conn.createStatement();
		int studentRoll=0;
		ResultSet rset= stmt.executeQuery(query);
		while(rset.next()) {
			studentRoll	=rset.getInt("studentRollNumber");
	}
		return studentRoll;
	}
	

}
