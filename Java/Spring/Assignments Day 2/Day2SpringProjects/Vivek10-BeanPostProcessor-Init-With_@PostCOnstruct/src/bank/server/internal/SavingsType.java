package bank.server.internal;

import bank.iserver.internal.service.AccountService;

public class SavingsType implements AccountService {
	String custName;
	public SavingsType(String custName, float interestRate) {
		super();
		this.custName = custName;
		this.interestRate = interestRate;
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

}
