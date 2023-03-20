package service;

import datastr.MyHeap;

public class MainService {

	public static void main(String[] args) {
		MyHeap intHeap = new MyHeap<>();
		intHeap.add(3);
		intHeap.add(7);
		intHeap.add(10);
		intHeap.add(11);
		try {
			
		intHeap.print();
		System.out.println("-------------------------");
		intHeap.prefixPrint();
		System.out.println("-------------------------");
		intHeap.remove();
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
