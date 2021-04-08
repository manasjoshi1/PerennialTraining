package bank.server.internal;



public class LoanAccount  {
	public String loanType;
	public int loanTerm;
	public float rateOfInterest;
	public int loanAmount;
	LoanAccount(){super();}
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
		System.out.println("LoanAccount set method called");
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
	
	public int updateBalance(int amount) {
		
		setLoanAmount(amount);
		return getLoanAmount();
	}
	public void changeRateOfInterest(float rate) throws InvalidInterestRateException {
		if(rate <7.0f || rate > 12.5f)
			throw new InvalidInterestRateException("Intrest rate is not allowed to be "+rate);
		System.out.println("Interest rate Changed from"+rateOfInterest+" to "+rate);
		rateOfInterest = rate;
	}
	

}
