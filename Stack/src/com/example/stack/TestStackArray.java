package com.example.stack;

import java.util.Scanner;

public class TestStackArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the size of the array : ");
		int size = sc.nextInt();
		
		StackArray stack = new StackArray(size);
		stack.menu();
		
		boolean exit = false;
		
		while (!exit) {
			System.out.println("Enter your choice : ");
			switch(sc.nextInt()) {
			case 0: System.out.println("You have been exited!");
					System.exit(0);
			case 1: System.out.println("Enter the element to push into Stack : "); 
					int element = sc.nextInt();
					stack.push(element);
					break;
			case 2: stack.pop();
					break;
			
			case 3: stack.peek();
					break;
			
			default: System.out.println("Error : Enter valid choice!");
			}
		}
		sc.close();
	}

}
