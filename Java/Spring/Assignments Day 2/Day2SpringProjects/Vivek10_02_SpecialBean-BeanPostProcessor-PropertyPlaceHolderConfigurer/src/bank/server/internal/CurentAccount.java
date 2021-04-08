package bank.server.internal;

import bank.iserver.internal.service.AccountService;

public class CurentAccount extends Account {
   String custName;

public String getCustName() {
	return custName;
}

public void setCustName(String custName) {
	this.custName = custName;
}

public CurentAccount(String custName, int balance) {
	super(balance,custName);
	this.custName = custName;
}

@Override
public String toString() {
	// TODO Auto-generated method stub
	return "CustomerName : "+custName+super.toString();
}
   
}
