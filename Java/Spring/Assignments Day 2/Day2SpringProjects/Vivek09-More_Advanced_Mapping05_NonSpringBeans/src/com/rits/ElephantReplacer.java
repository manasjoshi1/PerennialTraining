package com.rits;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class ElephantReplacer implements MethodReplacer {

	@Override
	public Object reimplement(Object arg0, Method arg1, Object[] arg2)
			throws Throwable {
				return " MYSORE ELEPHANT ";
		
	}

}
