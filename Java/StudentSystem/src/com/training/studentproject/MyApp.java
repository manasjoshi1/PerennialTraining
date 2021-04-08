package com.training.studentproject;

import java.sql.SQLException;
import java.util.Scanner;

public class MyApp {
	static Scanner sc= new Scanner(System.in);
	public static void main(String[] args) throws SQLException {
		
		int i=0;
		do {
		
			System.out.println("1. Insert Student");
			System.out.println("2. Delete Student");
			System.out.println("3. Display Students");
			System.out.println("4.Update Student");
			System.out.println("5.Exit");
			i =sc.nextInt();
			switch(i) {
			case 1	:	insertStudent();//insert student
				break;
			case 2: 
				break;
			case 3: 
				break;
			case 4: 
				break;
			}
		
		
		}while(i==5);
		
	}
	
	static void insertStudent() throws SQLException {
		System.out.println("Enter Name");
		String name= sc.next();
		String building =sc.next();
		String city= sc.next();
		String zipcode=sc.next();
		
		int maxSubjects=0;
		do {
		System.out.println(" Enter Number of Subjects , = 3");
		 maxSubjects=sc.nextInt();
		}while(maxSubjects!=3);
		Subject subjects[] =new Subject[maxSubjects] ;
		for(int i=0;i<maxSubjects;i++) {
			String subjectName =sc.next();
			int subjectMarks =sc.nextInt();
			Subject subject=new Subject(subjectName,subjectMarks);
			subjects[i] =subject;
		}
		Admin server=new Admin();
		int roll=server.insertStudent(name,building,city,zipcode,subjects);
		System.out.println("Roll number of "+ name +" is : "+ roll);
		
		
	}
}
