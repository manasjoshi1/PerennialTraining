import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Tester {

	public static void main(String[] args) {
		try {
			throw new IOException();
			
			}
		catch(IOException e) {
			System.out.println("IOE CALL");
		Map<String,Map> map=	ConvertToMap.exceptionHandler("Project1", "Module1", e);
		  List<String> keys = new ArrayList<String>(map.keySet());

		    for (String key : keys) {
//		    System.out.println(key +": "+ map.get(key));
		    }
		
		}
		try {
			throw new SQLException();
			}
			catch(SQLException e) {
				System.out.println("SQL CALL");

			Map<String,Map> map=	ConvertToMap.exceptionHandler("Project1", "Module1", e);
		
			
		}
		
	}

}
