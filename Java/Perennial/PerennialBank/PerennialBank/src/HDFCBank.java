import java.util.ArrayList;
import java.util.Date;

public class HDFCBank implements Bank {
	DaoRepo db=new DaoRepo();
	@Override
	public String openAccount(String name, String address, int amount) throws InsufficientBalanceException {
		if(amount < Bank.MIN_BALANCE)
			throw new InsufficientBalanceException("Min balance required to open Account is "+Bank.MIN_BALANCE);
		int accno= db.getLastAccNo();
		Account acct = new Account(++accno,name, address,amount);
		if(db.openAccount(acct))
			return "HDFC Thanks u for opening acc new accno is "+acct.getAccno();
		return "Problem in account opening";
	}
	
	@Override
	public int closeAccount(int accno) throws InvalidAccountException {
		Account acct = db.getAccount(accno);
		if(acct==null)
			throw new InvalidAccountException();
		db.closeAccount(acct);
		return acct.getBalance();
	}


	@Override
	public int withdraw(int accno, int amount) throws InsufficientBalanceException, InvalidAccountException {
		Account acct = db.getAccount(accno);
		if(acct==null)
			throw new InvalidAccountException();
		int oldBalance = acct.getBalance();
		if(oldBalance-amount > Bank.MIN_BALANCE) {
			acct.setBalance(oldBalance-amount);
			db.updateTransaction(acct);
			Transaction txn = new Transaction(new Date(),"DEBIT",amount);
			db.addTransaction(txn, acct.getAccno());
		}else {
			throw new InsufficientBalanceException("Min balance requires is"+Bank.MIN_BALANCE);
		}
		return acct.getBalance();
	}

	@Override
	public int deposit(int accno, int amount) throws InvalidAccountException {
		Account acct = db.getAccount(accno);
		if(acct==null)
			throw new InvalidAccountException();
		int oldBalance = acct.getBalance();
		acct.setBalance(oldBalance+amount);
		db.updateTransaction(acct);
		Transaction txn = new Transaction(new Date(),"CREDIT",amount);
		db.addTransaction(txn, acct.getAccno());
		return acct.getBalance();
	}

	@Override
	public int transfer(int accfrom, int accto, int amount)throws InvalidAccountException, InsufficientBalanceException { 
		if(db.getAccount(accfrom)==null||db.getAccount(accto)==null)
				throw new InvalidAccountException();
		int newbalance = withdraw(accfrom,amount);
		try {
			deposit(accto,amount);			
		}catch(Exception ex) {
			deposit(accfrom,amount);			
		}
		return newbalance;

	}

	

	@Override
	public String printRecentTransaction(int accno, int notxns) throws InvalidAccountException {
		ArrayList<Transaction> txns = db.displayTransactions(accno,notxns);
		StringBuilder builder = new StringBuilder();
		for(int i=0; i < txns.size(); i++) {
			builder.append(txns.get(i).toString());
		}
		return builder.toString();
	}

}
