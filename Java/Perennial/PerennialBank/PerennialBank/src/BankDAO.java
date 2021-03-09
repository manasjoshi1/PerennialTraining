import java.util.ArrayList;

public interface BankDAO {
	boolean openAccount(Account acc);
	int updateTransaction(Account acc);
	void closeAccount(Account acc);
	Account getAccount(int accNo);
	 int getLastAccNo();
	ArrayList<Transaction> displayTransactions(int accNo,int notxns);

}
