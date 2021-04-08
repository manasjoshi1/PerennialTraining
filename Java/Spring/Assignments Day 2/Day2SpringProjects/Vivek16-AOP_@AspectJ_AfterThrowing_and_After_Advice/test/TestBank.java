import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bank.server.internal.Account;
import bank.server.internal.LoanAccount;
import bank.server.internal.SubClassAccount;

class TestBank{
	
	public static void main(String[] args){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-list.config.xml");
		LoanAccount loan = ctx.getBean(LoanAccount.class);
		try{
		loan.changeRateOfInterest(6.0f);
		}catch(Exception ex){
			System.out.println("Inside TestBank caught exception "+ex.getMessage());
		}
	//	SubClassAccount subAcct = ctx.getBean(SubClassAccount.class);
		//subAcct.setLoanAmount(2222);
		//Account acct = ctx.getBean(Account.class);
		//acct.setName("Ram Krishna");
	}
}