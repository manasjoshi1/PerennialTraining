package com.perennial.training.rkit;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AnnotationHandler implements InvocationHandler{

		Object obj;
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (method.getAnnotation(EntryLog.class)!=null) {
			System.out.println("Entering :  Entry Log"+method.getName());
			
		}
		return method.invoke(obj, args);
	}
	public static void setObj(Object obj) {
	}
	
}
