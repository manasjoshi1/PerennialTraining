package bank.server.internal.aspects;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
public class FieldValueChangeTracker {
	
	
	Logger logger = Logger.getLogger(getClass().getName());
	@Before("execution(* bank.server.internal.*.set*(..))")
	void trackChange(JoinPoint jp){
		String methodName = jp.getSignature().getName();
		Object newValue  = jp.getArgs()[0];
		Object target = jp.getTarget();
		Field[] fields = target.getClass().getFields();
		for(int i=0; i< fields.length; i++){
			try {
				logger.setLevel(Level.INFO);
				//logger.log(Level.INFO,"This is a trackChanger Logg");
				logger.info("FieldName "+fields[i].getName()+" Old Value ="+fields[i].get(target));
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("State of Object Before Change "+target);
		System.out.println("FieldValueChangeTracker  Before Advice for method "+methodName+" on "+target.getClass().getName());
		System.out.println("Property About to change to "+newValue);
	}
		
   
}
