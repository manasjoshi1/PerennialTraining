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
	
	@After("execution(* bank.server.internal.*.change*(..))")
	
	void trackChange2(JoinPoint jp){
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
				
		System.out.println("State of Object Before Change "+target);
		
		System.out.println("DEBUG :  After ADVICE for method "+methodName+" on "+target.getClass().getName());
		
	}
	@AfterThrowing(value="execution(* bank.server.internal.*.change*(..))",throwing="ex")

	void trackChange(JoinPoint jp, Throwable ex){
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
		System.out.println("After Throwing Advice Printing StackTrace ");
		
		ex.printStackTrace();
		System.out.println("State of Object after throwing exception "+ex.getClass().getName()+" is "+target);
		System.out.println("DEBUG :  After throwing ADVICE for method "+methodName+" on "+target.getClass().getName());
		System.out.println("Property About did not change change to "+newValue);
	}
		
   
}
