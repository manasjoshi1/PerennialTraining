import javax.xml.parsers.DocumentBuilderFactory;

/**
 * 
 */

/**
 * @author Manas
 *
 */
public class MyException extends Exception{
	static String exception1="java.util.InputMismatchException";
	static String exception2="java.sql.SQLException";
	static String exception3="java.lang.ArrayIndexOutOfBoundsException";
	static String exception4="java.io.IOException";
	static String exception5="java.io.FileNotFoundException";

	
	public static void myException(Exception E) {
		String caughtException=E.getClass().getCanonicalName();
		
		
		if(caughtException.equalsIgnoreCase(exception1)) {
			System.out.print("Input Mismatch Found");
		}
		else if (caughtException.equalsIgnoreCase(exception2)) {
			System.out.print("SQLException Found");
		}
		else if (caughtException.equalsIgnoreCase(exception3)) {
			System.out.print("ArrayIndexOutOfBounds Found");
		}
		else if (caughtException.equalsIgnoreCase(exception4)) {
			System.out.print("IOException Found");
		}
		else if (caughtException.equalsIgnoreCase(exception5)) {
			System.out.print("FileNotFoundException Found");
		}
		else {
			System.out.println("Unkown Exception");
		}
		
		
		
		
		
	}
}
public class Action() 
{ DocumentBuilderFactory fact= DocumentBuilderFactory.newInstance()
	void sendMail() {};
	void rollTransaction() {};
	void abortMission() {};
}
