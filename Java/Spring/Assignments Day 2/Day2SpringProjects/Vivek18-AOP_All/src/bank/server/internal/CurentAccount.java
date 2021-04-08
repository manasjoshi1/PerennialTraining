package bank.server.internal;

import bank.iserver.internal.service.AccountService;

public class CurentAccount extends Account {
   String custName;

   void initialize(){
	   System.out.println("DEBUG : CurrentAccount initialize method called");
   }
public String getCustName() {
	return custName;
}

public void setCustName(String custName) {
	this.custName = custName;
}
public  CurentAccount() {
	super();

}
public CurentAccount(String custName, int balance) {
	super(balance,custName);
	this.custName = custName;
	System.out.println("Current Account constructor called");
}

@Override
public String toString() {
	// TODO Auto-generated method stub
	return "CustomerName : "+custName+super.toString();
}
   
}
