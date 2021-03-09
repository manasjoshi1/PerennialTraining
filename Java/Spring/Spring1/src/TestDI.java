import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext container = new ClassPathXmlApplicationContext("application-config.xml");
		A a = (A) container.getBean("a");

	}

}
