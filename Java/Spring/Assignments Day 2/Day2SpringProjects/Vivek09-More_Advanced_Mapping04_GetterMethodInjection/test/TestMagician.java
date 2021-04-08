import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rits.MagicBox;
import com.rits.Magician;


public class TestMagician {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		
	    ApplicationContext ctx = new ClassPathXmlApplicationContext("application-config.xml");
	    Magician magician = ctx.getBean(Magician.class);
	    magician.perform();
	//    magician.perform(ctx.getBean(MagicBox.class),"hello");
		
		
		
	}

}
