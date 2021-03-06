import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Properties;

public class WorkerThread extends Thread{
	private String filePath;
	private Properties criteriaProps;
	private String fileName;
	FileWriter validFile;
	FileWriter	 invalidFile;
	WorkerThread(String filePath){
		this.filePath = filePath;
		this.fileName=Paths.get(filePath).getFileName().toString();
		try {
			this.invalidFile=new FileWriter(MyConstants.OUTPUT_DIR+"/"+fileName+"invalidFile.csv") ;
			this.validFile=new FileWriter(MyConstants.OUTPUT_DIR+"/"+fileName+"validFile.csv") ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	{
		criteriaProps=new Properties();
		try {
			criteriaProps.load(new FileReader("csvCriterion.props"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void run() {
		System.out.println("Worker Thread started for file "+filePath);
		try {
			csvReader(filePath);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	private void csvReader(String filePath) throws SQLException {
		String line="";
		String splitBy=",";
		try {
			BufferedReader br=new BufferedReader(new FileReader(filePath));
			while((line=br.readLine())!=null) {
				mainlogic(line,splitBy);
			}
			validFile.close();
			invalidFile.close();
			DataBaseLayer.closeConn();
			System.out.println("connection closed");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void mainlogic(String line,String splitBy) throws IOException, SQLException {
		
		String[] account=line.split(splitBy);
		DataBaseLayer db=new DataBaseLayer();
		boolean validator=true;
		for(int i=0;i<account.length;i++) {
			if (checkField(account[i],Integer.toString(i))){
				validator=true;
			}
			else {
				validator=false;
				break;
			}
		}
		if(validator) {
			writetoValidFile(line);
			db.writetoValidDB(line, fileName);
		}
		else {
		writetoInvalidFile(line);
		}
		
	}
	private void writetoInvalidFile(String line) throws IOException {
		this.invalidFile.write(line); 
		
	}
	private void writetoValidFile(String line) throws IOException{
		this.validFile.write(line);
	}
	private boolean checkField(String fieldValue, String field) {
		if(this.criteriaProps.containsKey(field)){
			int lengthofField=fieldValue.length();
			String fieldCritera=criteriaProps.getProperty(field);
			if(lengthofField<=Integer.parseInt(fieldCritera)) {
				return true;
			}
			return false;
		}
		return false;
	}
	

}
