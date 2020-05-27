package com.example.staticQueue;

import java.util.Scanner;

public class TestStaticQueue {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the size of the array : ");
		int size = sc.nextInt();
		
		StaticQueue sq = new StaticQueue(size);
		
		boolean exit = false;
		
		while (!exit) {
			sq.menu();
			System.out.println("Enter your choice : ");
			switch(sc.nextInt()) {
			case 0: System.out.println("You have been exited!");
					System.exit(0);
			case 1: System.out.println("Enter the element to push into Queue : "); 
					int element = sc.nextInt();
					sq.enQueue(element);
					break;
			case 2: sq.deQueue();
					break;
			
			case 3: sq.display();;
					break;
			
			default: System.out.println("Error : Enter valid choice!");
					break;
			}
		}
		sc.close();
	}

}
