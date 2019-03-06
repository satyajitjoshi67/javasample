package com.assignment.day2;

import java.util.ArrayList;

public class ProducerConsumer {
	
	ArrayList<String> source = new ArrayList<String>(); 
	
	private synchronized void consumer( ) {
		while(true) {
		if(source.size() > 0) {
			source.remove(0);
			System.out.println("Removed value from source");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			notify();
			
		} else {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	}
	
	private synchronized void producer() {
		while(true) {
		if(source.size()==0) {
			source.add("Value");
			System.out.println("Added value to source");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			notify();
			
		} else {
			
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	}

	
	public static void main(String[] args) {
		ProducerConsumer producerConsumer = new ProducerConsumer();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				producerConsumer.producer();
			}
		});
		
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				producerConsumer.consumer();
			}
		});
		
		
		t1.start();
		t2.start();
	}
}
