package bank.server.internal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.annotation.PostConstruct;

import bank.iserver.internal.service.AccountRepository;
import bank.iserver.internal.service.AccountService;
import bank.server.*;


import bank.server.Bank;

public class BankImpl implements Bank {
	
    AccountRepository accountRepo;
    String bankName;
    int branchCode;
    Collection<AccountService> accountTypes = new ArrayList<AccountService>();
    @PostConstruct
    void init(){
    	System.out.println("Init method of BankImpl With @PostConstruct Some initialization COde ");
    }
    @PostConstruct
    void init2(){
    	System.out.println("Init 2 method of BankImpl With @PostConstruct Some initialization COde ");
    }
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public int getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(int branchCode) {
		this.branchCode = branchCode;
	}

	public AccountRepository getAccountRepo() {
		return accountRepo;
	}

	public void setAccountRepo(AccountRepository accountRepo) {
		this.accountRepo = accountRepo;
	}

	private BankImpl() {
		super();
		System.out.println("Private constructor called");
		// TODO Auto-generated constructor stub
	}

	private BankImpl(AccountRepository accountRepo,Collection<AccountService> acctTypes) {
		super();
		this.accountRepo = accountRepo;
		this.accountTypes = acctTypes;
		System.out.println("Private Overloaded constructor called");
	}

	@Override
	public int withdraw(int amount, int acctNo) {
		Account acct = accountRepo.findAccountByAcctNumber(acctNo);
		acct.setBalance(acct.getBalance()-amount);
		return acct.getBalance();

	}

	@Override
	public Collection<AccountService> showAccountServices() {
		return accountTypes;
	}
	public Map<String, AccountService> showAccountServicesByName() {
		return null;
	}

}
