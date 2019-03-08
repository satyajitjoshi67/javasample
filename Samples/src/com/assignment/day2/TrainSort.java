package com.assignment.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class TrainSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createData();
		//added comment

	}
	
	public static void createData() {
		
		TreeSet<String> set = new TreeSet();
		set.add("4210|10:21|Pune");
		set.add("4211|10:22|Lonavala");
		set.add("4209|10:22|Karjet");
		set.add("4209|10:22|Karjet");
		System.out.println(set);
		
		ArrayList<String> al = new ArrayList<String>();
		al.add("4210|10:21|Pune");
		al.add("4211|10:22|Lonavala");
		al.add("4209|10:22|Karjet");
		al.add("4209|10:22|Karjet");
		
		Collections.sort(al);
		System.out.println(al);
		
		//Arrays.sort(a);
	}

}
