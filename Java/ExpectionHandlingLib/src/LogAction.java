import java.io.IOException;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

class LogAction implements Action{
	 @Override
	 public void takeAction(Map<String, String> map) {

		 Logger logger = Logger.getLogger("MyLog");  
		 FileHandler fh;
		try {
			String fp=map.get("logFilePath");
			fh = new FileHandler(fp);
			logger.addHandler(fh);

	        logger.log(Level.INFO,map.get("exception"));;
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
		 
	 }
 }