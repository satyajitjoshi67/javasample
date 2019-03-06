package com.assignment.day2;

public class NumberPrinter{
	
	public void print1to10() {
		
		for(int i=1;i<=10;i++) {
			System.out.println(" Number " + i + " By " + Thread.currentThread().getName());
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
public void print11to20() {
		
		for(int i=11;i<=20;i++) {
			System.out.println(" Number " + i + " By " + Thread.currentThread().getName());
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberPrinter numberPrinter = new NumberPrinter();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				numberPrinter.print1to10();
			}
		});
		
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				numberPrinter.print11to20();
			}
		});
		
		t1.start();
		t2.start();

	}
	
	

}
