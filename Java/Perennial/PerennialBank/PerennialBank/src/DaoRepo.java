
import java.sql.*;
import java.util.ArrayList;
import java.util.InputMismatchException;

import com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping;

public class DaoRepo implements BankDAO {
	private static Connection conn=null;
	private static PreparedStatement ptmt=null;
	private static ResultSet rset=null;

	
	static{
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "manas", "mysqlpass");
		conn.setAutoCommit(false);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		ExpectionHandle.exceptionHandler("Bank", "Module 1", e);

	}
		
	}
	@Override
	public boolean openAccount(Account acc )throws InputMismatchException{
		try {
			String query="Insert into Account (name,address,balance) VALUES(?,?,?)";
			ptmt = conn.prepareStatement(query);
			ptmt.setString(1, acc.getName());
			ptmt.setString(2, acc.getAddress());
			ptmt.setInt(3, acc.getBalance());
			ptmt.executeUpdate();
			conn.commit();
		    return true;
		}	
		catch(SQLException e){
			try {
			conn.rollback();
			}
				catch(SQLException e2)
			{
					ExpectionHandle.exceptionHandler("Bank", "Module 1", e2);
			}
			ExpectionHandle.exceptionHandler("Bank", "Module 1", e);
		}
		return false;
	}

	@Override
	public int updateTransaction(Account acc) {
		try {
			
			String query="Update Account SET balance=? WHERE accNo=? ";
			ptmt=conn.prepareStatement(query);
			
			ptmt.setInt(1, acc.getBalance());
			ptmt.setInt(2, acc.getAccno());
			ptmt.executeUpdate();
			conn.commit();


		}
		catch(SQLException e) {
			try {
				conn.rollback();
			}
			catch(SQLException e2) {
				ExpectionHandle.exceptionHandler("Bank", "Module 1", e2);
			}
			ExpectionHandle.exceptionHandler("Bank", "Module 1", e);
}
		
		return 0;
	}

	

	@Override
	public Account getAccount(int accNo) {
		
		try {
			String query="Select * from account where accNo=? AND Flag =1";
			ptmt=conn.prepareStatement(query);
			ptmt.setInt(1, accNo);
			rset=ptmt.executeQuery();
			while(rset.next()) {
			return 	new Account(rset.getInt("accNo"),rset.getString("name"),rset.getString("address"),rset.getInt("balance"));
		}
			}
		catch(SQLException e) {
		
		ExpectionHandle.exceptionHandler("Bank", "Module 1", e);	
		}
		return null;
	}
@Override
	public int getLastAccNo() {
		try {
		String query ="SELECT accno FROM account ORDER BY accno  DESC LIMIT 1;";
		ptmt=conn.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		rset=ptmt.executeQuery();
		while (rset.next()) {
	
		return rset.getInt("accNo");
		}}
		catch(SQLException e) {
			
			ExpectionHandle.exceptionHandler("Bank", "Module 1", e);	
		}
		return 0;
	}
	public boolean addTransaction(Transaction txn, int accno) {
		try {
			String query="Insert into Transactions (accno,amount,type,transactionDate) VALUES(?,?,?,CURDATE())";
			ptmt = conn.prepareStatement(query);
			ptmt.setInt(1, accno);
			
			ptmt.setInt(2, txn.getAmount());
			ptmt.setString(3, txn.getType());
			ptmt.executeUpdate();
			conn.commit();

			return true;			
		}
		catch(SQLException e){
			try {
				conn.rollback();
			}
			catch(SQLException e2) {
				ExpectionHandle.exceptionHandler("Bank", "Module 1", e2);	
					}
			ExpectionHandle.exceptionHandler("Bank", "Module 1", e);	
			}
		
		
		return false;
	}

	@Override
	public ArrayList<Transaction> displayTransactions(int accNo,int notxns) {
		try {
			String query ="SELECT * FROM transactions where accno=? ORDER BY transactionID  DESC LIMIT ?;";
			ptmt=conn.prepareStatement(query);
			ptmt.setInt(1, accNo);
			ptmt.setInt(2, notxns);
			rset=ptmt.executeQuery();
			ArrayList <Transaction> t =new ArrayList<Transaction>();
			while (rset.next()) {

				t.add(new Transaction( rset.getDate("transactionDate"),rset.getString("type"),rset.getInt("amount")));
				
			}
			
			return t;
			}
		catch(SQLException e){
			ExpectionHandle.exceptionHandler("Bank", "Module 1", e);	
			
		}
		
		return null;
		
	}
@Override
	public void closeAccount(Account acct) {
		try{
	
		String query="Update Account SET flag=? WHERE accNo=? ";
		ptmt=conn.prepareStatement(query);
		
		
		
		ptmt.setInt(1, 0);
		ptmt.setInt(2, acct.getAccno());
		ptmt.executeUpdate();
		conn.commit();

	}
	catch(SQLException e){
		try {
			conn.rollback();
		}
		catch(SQLException e2) {
			ExpectionHandle.exceptionHandler("Bank", "Module 1", e2);	
					}	
		ExpectionHandle.exceptionHandler("Bank", "Module 1", e);	
					
	
	}
		}
	}
	
		
	
	
	


