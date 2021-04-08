import java.util.Collection;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class TestPhoneEditor {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		
	
		
		ApplicationContext ctx =new ClassPathXmlApplicationContext("application-list.config.xml");
		
		System.out.println(ctx.getBean("contact"));
		

	}

}
