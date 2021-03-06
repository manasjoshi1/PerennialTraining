import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class FileDriver {
	static String folderPath;
	static Scanner sc= new Scanner(System.in);

	private static void listFiles() throws IOException {
		
		Set<String> setKeys = FileServer.deserializing().keySet();
		for(String key : setKeys){
		    System.out.println( key+": "+ FileServer.deserializing().get(key) );
		}
		showMenu();
		
	}


	private static void newFile() throws IOException {
		System.out.println("Enter File Name");
		String newFileName=sc.next();
		FileServer.createFile(folderPath, newFileName);
		System.out.println("File Created Successfully");
		showMenu();
	}
	
	private static void showMenu() throws IOException {
		System.out.println("1. Create File \n2. List Files\n3. Exit");
		int menuInput;
		while(true) {
			menuInput = sc.nextInt();
			switch(menuInput) {
			case 1: newFile();break;
			case 2: listFiles();break;
			case 3: System.out.println("Bye");System.exit(0);break;
			}
		}
	}
	
	private static void serverSetup() {
		System.out.println("Enter Folder Path");
		folderPath =sc.next();

	
		
	}

	public static void main(String[] args) throws IOException {
		serverSetup();
		showMenu();
	}

}
