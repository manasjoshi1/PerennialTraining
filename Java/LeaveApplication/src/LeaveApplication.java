
public class LeaveApplication {
	private String fname;
	private String lname;
	private int noofDays;
	private boolean hrApprovalStatus;
	private boolean mgrApprovalStatus;
	
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getNoofDays() {
		return noofDays;
	}

	public void setNoofDays(int noofDays) {
		this.noofDays = noofDays;
	}

	public boolean isHrApprovalStatus() {
		return hrApprovalStatus;
	}

	public void setHrApprovalStatus(boolean hrApprovalStatus) {
		this.hrApprovalStatus = hrApprovalStatus;
	}

	public boolean isMgrApprovalStatus() {
		return mgrApprovalStatus;
	}

	public void setMgrApprovalStatus(boolean mgrApprovalStatus) {
		this.mgrApprovalStatus = mgrApprovalStatus;
	}

	public LeaveApplication(String fname,String lname,int noofDays) {
		// TODO Auto-generated constructor stub
		this.fname=fname;
		this.lname=lname;
		this.noofDays=noofDays;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeaveApplication application =new LeaveApplication("Manas", "Joshi", 2);
		HRThread hr=new HRThread(application);
		hr.setName("HR-Thread");
		ManagerThread mgr=new ManagerThread(application);
		mgr.setName("Manager-Thread");
		hr.start();
		mgr.start();
		AccountsMgrThread accts=new AccountsMgrThread(application,new Thread[] {hr,mgr});
		accts.start();
	}

}
