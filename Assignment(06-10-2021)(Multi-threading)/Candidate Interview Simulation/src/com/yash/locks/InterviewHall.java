package com.yash.locks;

public class InterviewHall 
{
	private String companyName;
	private String venue;
	
	public InterviewHall(String companyName, String venue) {
		super();
		this.companyName = companyName;
		this.venue = venue;
	}
	
	public void processInterview(String candidateName) {
		System.out.println(candidateName+" interview started");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(candidateName+" interview completed");
		int ch = (int)(Math.random() * 10);
		
		if(ch>5) {
			System.out.println("****** "+candidateName+" selected ******\n");
		}
		else {
			System.out.println("****** "+candidateName+" rejected ******\n");			
		}
		
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getVenue() {
		return venue;
	}
	
	
}
