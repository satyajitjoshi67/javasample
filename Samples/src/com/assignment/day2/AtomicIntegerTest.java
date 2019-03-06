package com.assignment.day2;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
	int x=0;
	AtomicInteger atomicInteger = new AtomicInteger();
	
	
	private void sum() {
		
		for(int i=0;i<5;i++) {
			process();
			x=x+1;
			
		}
	}
	
	
private void sumAtomic() {
		
		for(int i=0;i<5;i++) {
			process();
			atomicInteger.getAndIncrement();
			
		}
	}
	
	private void process() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AtomicIntegerTest atomicIntegerTest = new AtomicIntegerTest();
		Thread t1 = new Thread(new Runnable() {
			
			public void run() {
				atomicIntegerTest.sum();
				atomicIntegerTest.sumAtomic();
			}
		});
		
		
Thread t2 = new Thread(new Runnable() {
			
			public void run() {
				atomicIntegerTest.sum();
				atomicIntegerTest.sumAtomic();
			}
		});
		
t1.start();
t2.start();

try {
	t1.join();
	t2.join();
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


System.out.println("Value os x is " + atomicIntegerTest.x);

System.out.println("Value of Atomic is " + atomicIntegerTest.atomicInteger.get());

	}

}
