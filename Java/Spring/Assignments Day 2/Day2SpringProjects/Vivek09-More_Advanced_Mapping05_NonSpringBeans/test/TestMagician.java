
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rits.Magician;


public class TestMagician {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		
	    ApplicationContext ctx = new ClassPathXmlApplicationContext("application-config.xml");
 //Since this is a non-managed bean dependencies will not normally be injected.
//But since class Magician has been annotated @Configurable, Spring is injecting dependencies
	    Magician magician = new Magician();
	    magician.perform();
		
		
		
	}

}
