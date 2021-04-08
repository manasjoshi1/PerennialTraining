package com.perennial.training.rkit;

import java.lang.reflect.InvocationHandler;

public class MyBeanFactory {
	InvocationHandler annotationHandler = new AnnotationHandler();
	static Object getBeans(String className) {
		AnnotationHandler.setObj(Class.forName(className).newInstance());
		
	}
}
