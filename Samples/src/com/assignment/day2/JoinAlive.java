package com.assignment.day2;

public class JoinAlive implements Runnable  {	
	public void run() {
		System.out.println(" In run method");
	}
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new JoinAlive());
		System.out.println(" is t1 alive before start =" +  t1.isAlive());
		
		t1.start();
		try {
			System.out.println(" is t1 alive after start and before join =" +  t1.isAlive());
			t1.join();
			System.out.println(" is t1 alive after start and after join =" +  t1.isAlive());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(" is t1 alive at end =" +  t1.isAlive());
		
	}

}
