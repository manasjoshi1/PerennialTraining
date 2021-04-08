package bank.server.internal.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
public class PropertyChangeTracker {
	@Pointcut(" execution(* update*(..)) || execution(* set*(..))")
	void updateORSetMethod(){}
	@Pointcut("(!execution(* bank.server.internal.BankImpl.get*(*))) && execution(* get*(..))")
	void getMethodAdvice(){}
	@Order(value=2)
	
	@Before("updateORSetMethod()")
	void trackChange(JoinPoint jp){
		String methodName = jp.getSignature().getName();
		Object newValue  = jp.getArgs()[0];
		System.out.println("trackchange method of PropertyChangeTracker1  invoked for method "+methodName);
		System.out.println("1 Property About to change to "+newValue);
	}
	@After("updateORSetMethod()")
	void trackChange2(JoinPoint jp){
		String methodName = jp.getSignature().getName();
		Object newValue  = jp.getArgs()[0];
		System.out.println("trackChange2 method in After Advice of PropertyChangeTracker1  invoked for method "+methodName);
		System.out.println("After 1 Property changed to "+newValue);
	}
	@AfterThrowing(value="getMethodAdvice()",throwing="e")
	void handleException(JoinPoint p, Throwable e){
		System.out.println("DEBUG AfterThrowing invoked due ot Exception "+e.getMessage()+"By method "+p.getSignature().getName()+" On Class "+p.getTarget().getClass().getName());
	}
	
   
}
