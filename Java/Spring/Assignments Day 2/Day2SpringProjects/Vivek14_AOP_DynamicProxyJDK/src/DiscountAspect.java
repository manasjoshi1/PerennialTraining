import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class DiscountAspect implements InvocationHandler {
	InvocationHandler handler;
	Product product;
	
	public DiscountAspect(InvocationHandler handler, Product product) {
		super();
		this.handler = handler;
		this.product = product;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object obj = handler.invoke(proxy, method, args);
		if(obj instanceof Integer){
			int price = Integer.parseInt(obj.toString());
			System.out.println("Original Price is "+price);
			System.out.println("Discount is "+25+"%");
			return (int)(price*0.75f);
		}
		return "My"+obj;
	}

}
