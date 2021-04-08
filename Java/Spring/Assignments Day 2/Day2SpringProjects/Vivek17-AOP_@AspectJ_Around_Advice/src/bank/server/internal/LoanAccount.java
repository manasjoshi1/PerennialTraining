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
	public LoanAccount setLoanTerm(int loanTerm) {
		this.loanTerm = loanTerm;
		return this;
	}
	public LoanAccount(String loanType, int loanTerm) {
		super();
		this.loanType = loanType;
		this.loanTerm = loanTerm;
		
	}
	public float getRateOfInterest() {
		return rateOfInterest;
	}
	public LoanAccount setRateOfInterest(float rateOfInterest) throws Exception{
		try {
			changeRateOfInterest(rateOfInterest);
			this.rateOfInterest = rateOfInterest;
		} catch (InvalidInterestRateException e) {
			// TODO Auto-generated catch block
			System.out.println("Inside LoanAccount set method catch block "+e);
			e.printStackTrace();
			throw e;
		}
		return this;
		
	}
	@Override
	public String toString() {
		return "LoanAccount [loanTerm=" + loanTerm + ", lonanType=" + loanType
				+ ", rateOfInterest=" + rateOfInterest + "Loan Amount = "+loanAmount+ " ]";
	}
	
	public int updateBalance(int amount) {
		
		setLoanAmount(amount);
		return getLoanAmount();
	}
	public void changeRateOfInterest(float rate) throws InvalidInterestRateException {
		if(rate <7.0f || rate > 12.5f)
			throw new InvalidInterestRateException("Intrest rate is not allowed to be "+rate);
	
		rateOfInterest = rate;
	}
	

}
