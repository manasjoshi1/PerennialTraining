package bank.server.internal.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;

@Aspect
public class PropertyChangeTracker2 {

	@Order(value=1)
	@Around("! execution(* bank.server.internal.BankImpl.get*(*)) && (execution(* update*(..)) || execution(* set*(..))|| execution(* get*(..)))" )
	Object trackChange(ProceedingJoinPoint jp) throws Throwable{
		String methodName = jp.getSignature().getName();
		Object newValue =null;
		if(jp.getArgs().length>0){
			newValue  = jp.getArgs()[0];
		}
		System.out.println("Kind ="+jp.getKind());
		System.out.println("PropertyChangeTracker FIRST invoked for method "+methodName);
		System.out.println("BEFORE  Property Change About to change to "+newValue);
		Object value = jp.proceed();
		System.out.println("AROUND AFTER property change is complete value ="+value);
		if(value instanceof String)
			return value+"CHANGED BY ADVICE";
		return value;
	}


}
