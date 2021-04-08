import java.lang.reflect.Proxy;


public class BankFactory {

	public static Bank getBankInstance() {
		Bank bank = new BankImpl();
		Bank bankProxy = (Bank) Proxy.newProxyInstance(Bank.class.getClassLoader(), bank.getClass().getInterfaces(), new LoggerAspect(bank));
		return bankProxy;
	}

}
