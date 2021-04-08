package bank.iserver.internal.service;

import bank.server.internal.Account;

public interface AccountRepository {
	Account findAccountByAcctNumber(int acctNo);

}
