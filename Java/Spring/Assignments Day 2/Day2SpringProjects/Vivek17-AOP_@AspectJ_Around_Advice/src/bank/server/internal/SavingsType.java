package bank.server.internal;

import org.springframework.beans.factory.annotation.Required;



public class SavingsType  {
	String custName;
	int balance;
	public int getBalance() {
		return balance;
	}
	SavingsType(){super();}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public SavingsType(String custName, float interestRate) {
		super();
		this.custName = custName;
		this.interestRate = interestRate;
	}
	public SavingsType(String custName) {
		super();
		this.custName = custName;
		
	}
	float interestRate;
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public float getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
		
	}
	@Override
	public String toString() {
		return "SavingsType [custName=" + custName + ", interestRate="
				+ interestRate + "]";
	}
	
	public int updateBalance(int amount) {
		
		setBalance(amount);
		return getBalance();
	}

}
