import java.lang.Comparable;
import java.util.Comparator;

public class Student implements Comparable {
	String fname;
	String lname;
	int rollno;
	Student(String fname,String lname, int rollno){
		this.fname=fname;
		this.lname=lname;
		this.rollno=rollno;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public int hashCode() {
		int a=10;
		System.out.println("Hashcode Called");
		return a+a;
		
	}
	@Override
	public int compareTo(Object o) {
		Student s =(Student)o;
		int a=this.getFname().compareTo(s.getFname());
		
		return a;
		
		
	}
	
	public boolean equals(Object tc) 
	{ 
	    if( tc instanceof Student && this.getFname() == ( (Student)tc).getFname() ) 
	    { 
	        if(this != tc) return true; 
	        else return false; 
	    } 
	    else return false; 
	} 
}
