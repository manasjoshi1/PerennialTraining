package com.rits;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class ElephantReplacer implements MethodReplacer {

	@Override
	public Object reimplement(Object arg0, Method arg1, Object[] arg2)
			throws Throwable {
				System.out.println("Object whos method is to be replaced"+arg0.toString()+" Name of Method "+arg1.getName()+" MYSORE ELEPHANT "+arg2[0]);
				return "RE ELEPHANT ";
		
	}

}
