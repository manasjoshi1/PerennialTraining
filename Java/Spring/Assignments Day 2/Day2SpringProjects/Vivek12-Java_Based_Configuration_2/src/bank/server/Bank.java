package bank.server;

import java.util.Collection;
import java.util.Map;

import bank.iserver.internal.service.AccountService;

public interface Bank {
	int withdraw(int amount , int acctNo);
	Collection<AccountService> showAccountServices();
	Map<String,AccountService> showAccountServicesByName();

}
