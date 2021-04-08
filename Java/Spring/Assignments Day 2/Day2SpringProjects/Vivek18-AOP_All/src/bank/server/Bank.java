package bank.server;

import java.util.Collection;
import java.util.Map;

import bank.iserver.internal.service.AccountService;
import bank.server.internal.Account;

public interface Bank {
	int withdraw(int amount , int acctNo);
	Collection showAccountServices();
	Account getAccountByNumber(int acctNo);
	Map<String,AccountService> showAccountServicesByName();

}
