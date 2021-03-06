
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Date;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileServer {
	
	static HashMap<String,String> fileMap = new HashMap<String,String>();
	 static SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	 static {
		 //Getting all the folders to map
			File folder = new File(FileDriver.folderPath);
			File[] listOfFiles = folder.listFiles();
			for (File file : listOfFiles) {
			    if (file.isFile()) {
			        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

			        FileServer.fileMap.put(file.getName(), sdf.format(file.lastModified()));
			    }
			}
	 }
	 
	public static void createFile(String folderPath, String newFileName) throws IOException {
		
		if(!fileMap.containsKey(newFileName)){
			
		File newFile= new File(folderPath+"\\" + newFileName);
		if(newFile.createNewFile()) {
			BasicFileAttributes attr = Files.readAttributes(newFile.toPath(), BasicFileAttributes.class);
			 fileMap.put(newFile.getName(), sdf.format(attr.creationTime()));
		}
			serializing();
		}
	else {
		String oldFileDate=fileMap.get(newFileName);
		String todaysDate= LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		if(!oldFileDate.equals(todaysDate) ) {
			File newFile= new File(folderPath+"\\" + newFileName+ "-Copy");
			if(newFile.createNewFile()) {
				 fileMap.put(newFile.getName(), sdf.format(newFile.lastModified()));
			}
				serializing();
			}
		}
	}
	

		public static void serializing() {
		       try{
		           FileOutputStream fos= new FileOutputStream("myfile");
		           ObjectOutputStream oos= new ObjectOutputStream(fos);
		           oos.writeObject(fileMap);
		           oos.close();
		           fos.close();
		         }catch(IOException ioe){
		              ioe.printStackTrace();
		          }
		}
	public static HashMap<String,String> deserializing(){
			 HashMap<String, String> retfileMap = null;
			try
		        {
		            FileInputStream fis = new FileInputStream("myfile");
		            ObjectInputStream ois = new ObjectInputStream(fis);
		            retfileMap = (HashMap<String, String>) ois.readObject();
		            ois.close();
		            fis.close();
		         }catch(IOException ioe){
		             ioe.printStackTrace();
		          }catch(ClassNotFoundException c){
		             c.printStackTrace();
		          }
			return retfileMap;
		}
		

}