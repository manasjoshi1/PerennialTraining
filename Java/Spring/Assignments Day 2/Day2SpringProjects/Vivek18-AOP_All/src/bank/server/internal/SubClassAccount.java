package bank.server.internal;

import bank.iserver.internal.service.AccountService;
import bank.iserver.internal.service.AccountServiceClass;

public class SubClassAccount extends AccountServiceClass {
	String loanType;
	int loanTerm;
	float rateOfInterest;
	int loanAmount;
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public int getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}
	public String getLonanType() {
		return loanType;
	}
	public void setLonanType(String lonanType) {
		this.loanType = lonanType;
	}
	public int getLoanTerm() {
		return loanTerm;
	}
	public void setLoanTerm(int loanTerm) {
		this.loanTerm = loanTerm;
	}
	public SubClassAccount(String loanType, int loanTerm) {
		super();
		this.loanType = loanType;
		this.loanTerm = loanTerm;
		
	}
	SubClassAccount(){super();}
	public float getRateOfInterest() {
		return rateOfInterest;
	}
	public void setRateOfInterest(float rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	@Override
	public String toString() {
		return "LoanAccount [loanTerm=" + loanTerm + ", lonanType=" + loanType
				+ ", rateOfInterest=" + rateOfInterest + "]";
	}
	@Override
	public int updateBalance(int amount) {
		
		setLoanAmount(amount);
		return getLoanAmount();
	}
	
	public void getException() throws RuntimeException{
		throw new RuntimeException("**Exception Msg **Comming from SubClass Account **");
	}

}
