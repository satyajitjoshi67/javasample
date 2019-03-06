package com.assignment.day2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DepositWithdraw {

	int balance = 0;
	Lock depositLock = new ReentrantLock();
	Lock withrawLock = new ReentrantLock();
	
	public  void deposit(int amount) {	
		depositLock.lock();
		balance = balance + amount;
		System.out.println("Added balance of " + amount + " by " + Thread.currentThread().getName() + " total is " + balance);
		depositLock.unlock();
	}
	
	public  void withdraw(int amount) {
		withrawLock.lock();
		if(amount >  balance) {
			System.out.println("can not withdraw " + amount + " as balance is " + balance + " Thread name " + Thread.currentThread().getName());
		} else {
			balance = balance -amount;
			System.out.println(" withdraw " + amount + " remaining balance is " + balance + " Thread name " + Thread.currentThread().getName());
		}
		withrawLock.unlock();
	}
	
	public static void main(String[] args) {
		DepositWithdraw depositWithdraw = new DepositWithdraw();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				depositWithdraw.withdraw(100);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				depositWithdraw.deposit(100);
			}
		});
		
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				depositWithdraw.deposit(100);
				
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				depositWithdraw.withdraw(100);
			}
		});
		
		
		t1.start();
		t2.start();
	}
	
	
}
