package bank.server.internal;

import org.springframework.beans.factory.annotation.Required;

import bank.iserver.internal.service.AccountService;

public class SavingsType implements AccountService {
	String custName;
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
	@Required
	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
		System.out.println("Saving Account : @Required set SO must be in config file");
	}
	@Override
	public String toString() {
		return "SavingsType [custName=" + custName + ", interestRate="
				+ interestRate + "]";
	}

}
