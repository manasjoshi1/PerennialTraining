import java.util.Collection;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bank.iserver.internal.service.AccountRepository;
import bank.iserver.internal.service.AccountService;
import bank.server.Bank;
import bank.server.internal.Account;
import bank.server.internal.AccountRepositoryImpl;
import bank.server.internal.BankConfig;
import bank.server.internal.BankImpl;


public class TestBank {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		
	
		
	//	AnnotationConfigApplicationContext ctx =new AnnotationConfigApplicationContext(BankConfig.class);
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-With-Java_Based_Config.xml");
		
		Bank bank1 = (Bank) ctx.getBean("bankService");
		Bank bank2 = (Bank) ctx.getBean("bankService");
		System.out.println("Is it a singleton "+(bank1==bank2));
	  //  System.out.println(ctx.getClass().getName());
		System.out.println("New Balance after withdrawal= "+bank1.withdraw(50, 1234));
		Collection<AccountService> accountTypes = bank1.showAccountServices();
		for(AccountService acctType : accountTypes){
			System.out.println("Account Service "+acctType);
		}
		

	}

}
