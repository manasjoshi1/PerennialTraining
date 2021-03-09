import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Demo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Calendar cal = new GregorianCalendar();
		cal.setTime(new Date());
		String timeString = "15:05:10";
		int hour = Integer.parseInt(timeString.split(":")[0]);
		int min = Integer.parseInt(timeString.split(":")[1]);
		int seconds = Integer.parseInt(timeString.split(":")[2]);
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.MINUTE, min);
		cal.set(Calendar.SECOND, seconds);
		long expectedTime = cal.getTimeInMillis();
		File f = new File("/Users/vivekkulkarni/eclipse-workspace/CalendarDemo/src/Demo.java");
		long actualFileTime = f.lastModified();
		if(actualFileTime < expectedTime) {
			System.out.println("File is Intime");
		}else {
			System.out.println("File is LATE");
		}
		
		
	}

}
