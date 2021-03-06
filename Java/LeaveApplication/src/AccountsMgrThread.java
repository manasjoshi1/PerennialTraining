
public class AccountsMgrThread extends Thread{
	private LeaveApplication application;
	private Thread[] dependantThreads= new Thread[2];
	public AccountsMgrThread(LeaveApplication app,Thread[] threads) {
		this.application=app;
		this.dependantThreads=threads;	
	}
	public void run() {
		System.out.println("Accounts Manager Recieved he will do some preprocessing and others will wait");
		for(Thread t: dependantThreads) {
			try {
				t.join();
				System.out.println("Wait over for "+t.getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			}
		if(this.application.isHrApprovalStatus()&&this.application.isMgrApprovalStatus()) {
			System.out.println("AccountMgr Thread : Leave Application of "+application.getFname()+"is approved");
		}
		else {
			System.out.println("Leave Application Rejected");
		}
	}

}
