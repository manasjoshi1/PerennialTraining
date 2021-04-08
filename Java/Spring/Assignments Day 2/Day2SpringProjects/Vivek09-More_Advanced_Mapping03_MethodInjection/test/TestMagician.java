





import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rits.Magician;







public class TestMagician {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		
	    ApplicationContext ctx = new ClassPathXmlApplicationContext("application-config.xml");
	    Magician magician1 = ctx.getBean("magician",Magician.class);
	    magician1.perform();
	    System.out.println("Magician 2 Will perform Now !!");
	    Magician magician2 = ctx.getBean("magician2",Magician.class);
	    magician2.perform();
		
		
		
	}

}
