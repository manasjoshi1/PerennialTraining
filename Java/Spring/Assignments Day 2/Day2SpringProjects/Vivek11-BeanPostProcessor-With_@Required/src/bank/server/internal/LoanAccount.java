package bank.server.internal;

import bank.iserver.internal.service.AccountService;

public class LoanAccount implements AccountService {
	String loanType;
	int loanTerm;
	float rateOfInterest;
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
	public LoanAccount(String loanType, int loanTerm) {
		super();
		this.loanType = loanType;
		this.loanTerm = loanTerm;
		
	}
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
	
	

}
