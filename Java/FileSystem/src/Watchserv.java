import static java.nio.file.StandardWatchEventKinds.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
 
public class Watchserv {
 
    private final WatchService watcher;
    private final Map<WatchKey, Path> keys;
 

    Watchserv(Path dir) throws IOException {
        this.watcher = FileSystems.getDefault().newWatchService();
        this.keys = new HashMap<WatchKey, Path>();
 
        walkAndRegisterDirectories(dir);
    }

    private void registerDirectory(Path dir) throws IOException 
    {
        WatchKey key = dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
        keys.put(key, dir);
    }

    private void walkAndRegisterDirectories(final Path start) throws IOException {
        // register directory and sub-directories
        Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                registerDirectory(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }
 
    /**
     * Process all events for keys queued to the watcher
     */
    void processEvents() {
    	
    	Properties props=new Properties();
      	try {
      		FileReader fh =new FileReader("A:\\Perrenial\\Java\\FileSystem/file.properties");
      		props.load(fh);
      		}
      		catch(Exception e) {
      			
      		}   	System.out.println(props.keySet());
          
        for (;;) {
 
            WatchKey key;
            try {
                key = watcher.take();
            } catch (InterruptedException x) {
                return;
            }
 
            Path dir = keys.get(key);
            if (dir == null) {
                System.err.println("WatchKey not recognized!!");
                continue;
            }
 
            for (WatchEvent<?> event : key.pollEvents()) {
                @SuppressWarnings("rawtypes")
                WatchEvent.Kind kind = event.kind();
 
                // Context for directory entry event is the file name of entry
                @SuppressWarnings("unchecked")
                Path name = ((WatchEvent<Path>)event).context();
                Path child = dir.resolve(name);
 
                // print out event
                System.out.format("%s: %s\n", event.kind().name(), child);
                if (event.kind() == ENTRY_CREATE ) {
                // if directory is created, and watching recursively, then register it and its sub-directories
           
                	if(props.containsKey(child.getFileName().toString())) {
                		arrivalCompare(child.toString(),child.getFileName().toString());
                	}
                	else {
                		new File(child.toString()).delete();
                	}
                	
                	}
            }
 
            boolean valid = key.reset();
            if (!valid) {
                keys.remove(key);
 
                if (keys.isEmpty()) {
                    break;
                }
            }
        }
    }
    public static void arrivalCompare(String pathofDir, String key) {
    	Properties props=new Properties();
      	try {
      		FileReader fh =new FileReader("A:\\Perrenial\\Java\\FileSystem/file.properties");
      		props.load(fh);
      		}
      		catch(Exception e) {
      			
      		}   
    	Calendar cal = new GregorianCalendar();
		cal.setTime(new Date());
		
		String timeString =(String) props.get(key);;
		int hour = Integer.parseInt(timeString.split(":")[0]);
		int min = Integer.parseInt(timeString.split(":")[1]);
		int seconds = Integer.parseInt(timeString.split(":")[2]);
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.MINUTE, min);
		cal.set(Calendar.SECOND, seconds);
		long expectedTime = cal.getTimeInMillis();
		File f = new File(pathofDir);
		long actualFileTime = f.lastModified();
		
		System.out.println(cal.getTime());

		if(actualFileTime < expectedTime) {
			System.out.println("File is Intime");
			
		}else {
			System.out.println("File is LATE & will be deleted");
			f.delete();
			
		}
    }
   
 
    public static void main(String[] args) throws IOException {
        Path dir = Paths.get("A:\\Perrenial\\filecheck");
        new Watchserv(dir).processEvents();
    
    }
}