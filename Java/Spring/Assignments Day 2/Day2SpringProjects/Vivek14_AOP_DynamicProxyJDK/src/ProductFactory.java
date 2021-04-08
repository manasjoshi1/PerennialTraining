import java.lang.reflect.Proxy;


public class ProductFactory {
	static Product newProduct(String className) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Product product = (Product) Class.forName(className).newInstance();
		Product proxy = (Product) Proxy.newProxyInstance(Product.class.getClassLoader(), new Class[]{Product.class}, new DiscountAspect(new LoggerAspect(product),product));
		return proxy;
	}

}
