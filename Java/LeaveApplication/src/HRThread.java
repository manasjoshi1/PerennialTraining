
public class HRThread extends Thread{
	private LeaveApplication application;
	HRThread(LeaveApplication application){
		this.application=application;
	}
	public void run() {
		System.out.println("HR Recieves Application");
		try {
			Thread.sleep(5000);
		}
		catch(InterruptedException e) {}
		this.application.setHrApprovalStatus(false);
		System.out.println("HR DONE");
	}
}
