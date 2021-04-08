package com.rits;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class PerformMethodReplacer implements MethodReplacer {

	@Override
	public Object reimplement(Object obj, Method method, Object[] args)
			throws Throwable {
		System.out.println("performing magic");
		return null;
	}

}
