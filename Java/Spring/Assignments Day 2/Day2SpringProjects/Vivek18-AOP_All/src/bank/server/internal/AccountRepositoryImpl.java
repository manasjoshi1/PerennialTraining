package bank.server.internal;

import static java.lang.String.format;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import bank.iserver.internal.service.AccountRepository;

public class AccountRepositoryImpl implements AccountRepository {

	Set<Account> accounts = new HashSet<Account>();
	DriverManagerDataSource dataSource;
	
	public AccountRepositoryImpl(DriverManagerDataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	public AccountRepositoryImpl() {
	/*	try {
			Connection conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			stmt.execute("create table SPRING_ACCOUNTS_11 (CUSTOMER_NAME varchar(50), ACCT_NO NUMBER, BALANCE NUMBER) ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println("AccountRepository Impl constructor called");
	   Account acct1 = new Account(100, "Vivek", 1234);
	   accounts.add(acct1);
	   Account acct2 = new Account(200, "Krishna", 12345);
	   accounts.add(acct2);
	   Account acct3 = new Account(300, "Shriram", 123456);
	   accounts.add(acct3);
	}
	@Override
	public Account findAccountByAcctNumber(int acctNo) {
		for(Account acct : accounts){
			if( acct.getAcctNo() == acctNo)
			return acct;
		}
		return null;
	}
	public  Account createAccount(String name, int balance, int acctNo){
		return new Account(balance,name,acctNo);
	}

}
