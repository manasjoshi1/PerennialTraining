import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bank.server.internal.Account;
import bank.server.internal.LoanAccount;
import bank.server.internal.SubClassAccount;

class TestBank{
	
	public static void main(String[] args){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-list.config.xml");
		LoanAccount loan = ctx.getBean(LoanAccount.class);
		loan.setLoanAmount(2000000);
		loan.setLoanTerm(40);
		loan.setLoanType("Long Term Home Loan");
		try {
			loan.setRateOfInterest(12.9f);
			System.out.println("Rate of Interest changed successfully??");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Inside Main cathc block "+e);
		//	e.printStackTrace();
		}
		System.out.println("Main returns without any problem");
		
	}
}