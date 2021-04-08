package bank.server.internal.aspects;

import java.lang.reflect.Field;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
public class FieldValueChangeTracker {
	
	
	@AfterReturning("execution(* bank.server.internal.*.set*(..))")
	void trackChange(JoinPoint jp){
		String methodName = jp.getSignature().getName();
		Object newValue  = jp.getArgs()[0];
		Object target = jp.getTarget();
		Field[] fields = target.getClass().getFields();
		for(int i=0; i< fields.length; i++){
			try {
				System.out.println("FieldName "+fields[i].getName()+" Old Value ="+fields[i].get(target));
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("State of Object After returning "+target);
		System.out.println("FieldValueChangeTracker  a After Advice for method "+methodName+" on "+target.getClass().getName());
		System.out.println("Property changed to "+newValue);
	}
		
   
}
