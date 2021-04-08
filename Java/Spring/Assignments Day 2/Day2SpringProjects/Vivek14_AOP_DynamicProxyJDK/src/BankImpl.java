
public class BankImpl implements Bank {
	Account acct = new Account(1000,"vivek",123);
	@Override
	public int deposit(int amount) {
		return -1;
	}

	@Override
	public int withdraw(int amount) {
		if(acct.getBalance()>amount){
			acct.setBalance(acct.getBalance()-amount);
			System.out.println("Bank : Withdrawal Succeesful");
			return acct.getBalance();
		}else{
			System.out.println("Bank : Insufficient funds");
		}
		return -1;
	}

}
