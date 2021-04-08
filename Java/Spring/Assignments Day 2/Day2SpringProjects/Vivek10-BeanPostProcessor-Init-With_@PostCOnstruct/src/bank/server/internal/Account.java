package bank.server.internal;

import bank.iserver.internal.service.AccountService;

public class Account implements AccountService{
	int balance;
	String name;
	int acctNo;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + acctNo;
		result = prime * result + balance;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (acctNo != other.acctNo)
			return false;
		if (balance != other.balance)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Account [acctNo=" + acctNo + ", balance=" + balance + ", name="
				+ name + "]";
	}
	public Account(int balance, String name, int acctNo) {
		super();
		this.balance = balance;
		this.name = name;
		this.acctNo = acctNo;
	}
	public int getAcctNo() {
		return acctNo;
	}
	public void setAcctNo(int acctNo) {
		this.acctNo = acctNo;
	}
	public Account(int balance, String name) {
		super();
		this.balance = balance;
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
