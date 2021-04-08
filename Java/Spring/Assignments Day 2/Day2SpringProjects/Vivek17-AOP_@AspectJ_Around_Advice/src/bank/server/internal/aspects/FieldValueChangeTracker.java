package bank.server.internal.aspects;

import java.lang.reflect.Field;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import bank.server.internal.LoanAccount;

@Aspect
public class FieldValueChangeTracker {
	
	
	@Around(value="execution(* bank.server.internal.*.set*(..))")

	void trackChange(ProceedingJoinPoint jp){
		String methodName = jp.getSignature().getName();
		Object newValue  = jp.getArgs()[0];
		Object target = jp.getTarget();
		
	    System.out.println("Property is about to change");
	    System.out.println("DEBUG BEFOR State "+target);
	    try {
			Object o = jp.proceed();
			System.out.println("Inside AROUND advise and returned value is "+o);
			System.out.println("Chaning retunred value ");
			((LoanAccount)o).setLoanAmount(-200);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			System.out.println("DEBUG : Inside Around ADVISE catch block");
			e.printStackTrace();
		}
	    System.out.println("DEBUG : AFTER state "+target);
	
	}
		
   
}
