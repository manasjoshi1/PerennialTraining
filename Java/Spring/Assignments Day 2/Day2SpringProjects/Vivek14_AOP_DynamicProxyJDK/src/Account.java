
public class Account {
	int balance;
	String name;
	int acctNo;
	
	public Account(int balance, String name, int acctNo) {
		super();
		this.balance = balance;
		this.name = name;
		this.acctNo = acctNo;
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
	public int getAcctNo() {
		return acctNo;
	}
	public void setAcctNo(int acctNo) {
		this.acctNo = acctNo;
	}
	

}
