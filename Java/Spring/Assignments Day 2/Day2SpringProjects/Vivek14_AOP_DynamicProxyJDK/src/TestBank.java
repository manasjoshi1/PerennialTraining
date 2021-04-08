
public class TestBank {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Bank bank = BankFactory.getBankInstance();
		System.out.println("Main : balance after withdrawal"+bank.withdraw(50));
		Product product = ProductFactory.newProduct("Umbrella");
		System.out.println("ClassName "+product.getClass().getName());
		System.out.println("Main Product price "+product.getPrice());
		System.out.println("Main : Description is "+product.getDescription());
	}

}
