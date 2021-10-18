package com.yash.synchronize;

public class InterviewProcess {
	public static void main(String[] args) {
		
		InterviewHall hall = new InterviewHall("Yash Technologies Pvt. Ltd.", "Indore BTC");
		Thread thread1 = new Thread(new Candidate("Kinshuk Jain", 110231, hall));
		Thread thread2 = new Thread(new Candidate("Saurav Nair", 110234, hall));
		Thread thread3 = new Thread(new Candidate("Jayesh Pathak", 110232, hall));
		Thread thread4 = new Thread(new Candidate("Madhur Atre", 110236, hall));
		Thread thread5 = new Thread(new Candidate("Jatin R.", 110238, hall));
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
	}
}
