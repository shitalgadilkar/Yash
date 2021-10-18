package com.yash.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InterviewProcess {
	public static void main(String[] args) {
		
		InterviewHall hall = new InterviewHall("Yash Technologies Pvt. Ltd.", "Indore BTC");
		Lock lock = new ReentrantLock(true);
		
		Thread thread1 = new Thread(new Candidate("Kinshuk Jain", 110231, hall,lock));
		Thread thread2 = new Thread(new Candidate("Saurav Nair", 110234, hall,lock));
		Thread thread3 = new Thread(new Candidate("Jayesh Pathak", 110232, hall,lock));
		Thread thread4 = new Thread(new Candidate("Madhur Atre", 110236, hall,lock));
		Thread thread5 = new Thread(new Candidate("Jatin R.", 110238, hall,lock));
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
	}
}
