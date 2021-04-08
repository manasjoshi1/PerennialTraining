package bank.server.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class AccountInfo {
	@Value("#{accountInfo.balance}") int balance;
	@Value("#{accountInfo.name}") String name;
	@Value("#{accountInfo.acctNo}") int acctNo;

}
