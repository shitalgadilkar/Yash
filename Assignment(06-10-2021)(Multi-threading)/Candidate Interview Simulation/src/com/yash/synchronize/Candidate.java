package com.yash.synchronize;

public class Candidate implements Runnable {
	private String candidateName;
	private int resumeNo;
	private InterviewHall hall;
	
	public Candidate(String candidateName, int resumeNo,InterviewHall hall) {
		super();
		this.candidateName = candidateName;
		this.resumeNo = resumeNo;
		this.hall=hall;
	}

	@Override
	public void run() {
		System.out.println("\n"+candidateName+" is waiting, Resume no. : "+resumeNo);
		synchronized(hall) {
			hall.processInterview(candidateName);
		}
	}	
}
