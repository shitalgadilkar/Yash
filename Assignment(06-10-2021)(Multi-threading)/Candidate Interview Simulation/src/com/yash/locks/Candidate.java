package com.yash.locks;

import java.util.concurrent.locks.Lock;

public class Candidate implements Runnable {
	private String candidateName;
	private int resumeNo;
	private InterviewHall hall;
	private Lock lock;
	
	public Candidate(String candidateName, int resumeNo,InterviewHall hall, Lock lock) {
		super();
		this.candidateName = candidateName;
		this.resumeNo = resumeNo;
		this.hall=hall;
		this.lock=lock;
	}

	@Override
	public void run() {
		System.out.println("\n"+candidateName+" is waiting, Resume no. : "+resumeNo);
			lock.lock();
			hall.processInterview(candidateName);
			lock.unlock();
	}	
}
