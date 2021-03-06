
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Properties;

import com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping;
public class DataBaseLayer {
	private static Connection conn=null;
	private static PreparedStatement ptmt=null;
	private static ResultSet rset=null;
	static DatabaseMetaData dbm ;
	static Properties createTableValues = new Properties();
	static{
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fileDB", "root", "mysqlpass");
		conn.setAutoCommit(false);
		dbm = conn.getMetaData();

		try {
			createTableValues.load(new FileReader("ValidFiles.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		
		}
		DatabaseMetaData dbm = conn.getMetaData();
		// check if "employee" table is there
		
		for(Object s:createTableValues.keySet()) {
			if(s.toString().contains("data")){
				ResultSet tables = dbm.getTables(null, null, s.toString(), null);
				if (tables.next()) {
				 System.out.println("Table "+ s.toString()+"exists");
				}
				else {
					String createTable="CREATE TABLE "+ s.toString()+" ("+createTableValues.getProperty((String) s)+");";
					System.out.println(createTable);
					Statement stmt=conn.createStatement();
					stmt.execute(createTable);
					System.out.println("Table Created");
				}
				
			}
			else {
				System.out.println("Sometning went wrong");
			}
			
		}
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	

		}
	static void closeConn() throws SQLException {
		conn.close();
		

		
		
	}
	private static String getFileNameWithoutExtension(String name) {
        String fileName = "";
 
        try {
                fileName = name.replaceFirst("[.][^.]+$", "");
        } catch (Exception e) {
            e.printStackTrace();
            fileName = "";
        }
 
        return fileName;
 
    }
	private void enterData() {
		
	}
	public  void writetoValidDB(String line, String fileName) throws SQLException {
		String values[]=line.split(",");
		String insertHdfc="Insert into dataBasehdfc values(?,?,?,?);";
		PreparedStatement ps=conn.prepareStatement(insertHdfc);
		ps.setString(1, values[0]);
		ps.setString(2, values[1]);
		ps.setInt(3, Integer.parseInt(values[2]));
		ps.setInt(4, Integer.parseInt(values[3]));
		System.out.println(ps.toString());
		int i=ps.executeUpdate();  
		System.out.println(i+" records inserted");  
		
	}

}
