import java.io.IOException;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Map<String,Student> map=new TreeMap<String,Student>();
Student s1=new Student("Manas", "Joshi",1);
Student s2=new Student("Pepper","Potts",2);
Student s3=new Student("Harry","Potter",3);
Student s4=new Student("Tony","Stark",3);
Student s5=new Student("Tony","Park",3);
	map.put("Manas", s1);
	map.put("Pepper", s2);
	map.put("Harry", s3);
	map.put("Tony", s4);
	map.put("Tony", s5);
	
	System.out.println(map.size());

	}
	public static void printSortbyFirst(TreeSet<Student> set) {
		System.out.println("Sorting by first names");
		for(Student student : set) {
			System.out.println(student.getFname() +" "+ student.getLname());
		}
		
	}
		public static void printSortbyLast(TreeSet<Student> students) {
			
			Comparator<Student> com =(s1,s2)->{
				return s1.getLname().compareTo(s2.getLname());};
			
		TreeSet<Student> s2=new TreeSet<Student>(com);
		s2.addAll(students);
		
		System.out.println("Sorting by last name");
		for(Student s:s2) {
			System.out.println(s.getFname()+" "+s.getLname());
		
		}

}
		}
