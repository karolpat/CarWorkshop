package pl.carWorkshop.dao;

public class Status {
	
	private int id;
	private int approved;
	private int costAccepted;
	private int inProgress;
	private int receiveReady;
	private int aborted;
	
	
	public Status() {}
	
	
	public Status(int approved, int costAccepted, int inProgress, int receiveReady, int aborted) {
		
		this.setApproved(approved);
		this.setCostAccepted(costAccepted);
		this.setInProgress(inProgress);
		this.setReceiveReady(receiveReady);
		this.setAborted(aborted);
	}

	public int getId() {
		return id;
	}
	public int getApproved() {
		return approved;
	}
	public void setApproved(int approved) {
		this.approved = approved;
	}
	public int getCostAccepted() {
		return costAccepted;
	}
	public void setCostAccepted(int costAccepted) {
		this.costAccepted = costAccepted;
	}
	public int getInProgress() {
		return inProgress;
	}
	public void setInProgress(int inProgress) {
		this.inProgress = inProgress;
	}
	public int getReceiveReady() {
		return receiveReady;
	}
	public void setReceiveReady(int receiveReady) {
		this.receiveReady = receiveReady;
	}
	public int getAborted() {
		return aborted;
	}
	public void setAborted(int aborted) {
		this.aborted = aborted;
	}
	
	

}
