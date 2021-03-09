
public class ManagerThread extends Thread{
	private LeaveApplication application;
	ManagerThread(LeaveApplication application){
		this.application=application;
	}
	public void run() {
		System.out.println("MGR Recieves Application");
		try {
			Thread.sleep(5000);
		}
		catch(InterruptedException e) {}
		this.application.setMgrApprovalStatus(true);
		System.out.println("MGR DONE");
	}
}
