package com.assignment.day2;



public class BusRoute {
	
	Thread t1,t2,t3,t4,t5,t6;
	
	private void process() {
		startBus();		
		stopBus();
	
	}
	
	
	private void startBus() {
		
		System.out.println(" Bus " + Thread.currentThread().getName() + " == Started");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private void stopBus() {
		
		if(Thread.currentThread().getName().equals("five")) {
			try {
				t4.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(Thread.currentThread().getName().equals("four")) {
			try {
				t3.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(Thread.currentThread().getName().equals("three")) {
			try {
				t2.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(Thread.currentThread().getName().equals("two")) {
			try {
				t1.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		System.out.println("Bus " + Thread.currentThread().getName() + " == Stopped");
		
		
	}
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		BusRoute busRoute = new BusRoute();
		
		busRoute.t1 = new Thread(new Runnable() {				
				public void run() {
					busRoute.process();
				}
				
		},"one");
		
		busRoute.t2 = new Thread(new Runnable() {				
			public void run() {
				busRoute.process();
			}
			
	},"two");
		
		
		busRoute.t3 = new Thread(new Runnable() {				
			public void run() {
				busRoute.process();
			}
			
	},"three");
		
		busRoute.t4 = new Thread(new Runnable() {				
			public void run() {
				busRoute.process();
			}
			
	},"four");
		
		busRoute.t5 = new Thread(new Runnable() {				
			public void run() {
				busRoute.process();
			}
			
	},"five");
		
		
		busRoute.t3.start();
		busRoute.t1.start();
		busRoute.t4.start();
		busRoute.t2.start();
		busRoute.t5.start();
		
		
		
		

	}

}
