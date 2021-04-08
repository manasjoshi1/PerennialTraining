import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class LoggerAspect implements InvocationHandler {
	Object obj;
	LoggerAspect(Object obj){
		this.obj=obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("Logger : Enrty Method : "+method.getName());
		Object retVal = method.invoke(obj, args);
		System.out.println("Logger : Exit Method  : "+method.getName());
		return retVal;
	}

}
