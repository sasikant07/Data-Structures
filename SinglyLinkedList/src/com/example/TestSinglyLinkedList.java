package com.example;

import java.util.Scanner;

public class TestSinglyLinkedList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		SinglyLinkedList list = new SinglyLinkedList();
		int ele;
		
		boolean exit = false;
		
		while(!exit) {
			System.out.println("*********************************** List Menu ************************************");
			System.out.println("0.Exit");
			System.out.println("1. Add at begining.");
			System.out.println("2. Add at end.");
			System.out.println("3. Add at a position.");
			System.out.println("4. Delete at begining.");
			System.out.println("5. Delete at end.");
			System.out.println("6. Delete at position.");
			System.out.println("7. Reverse List Contents.");
			System.out.println("8. Find if list conatin any loop.");
			System.out.println("9. Display List Contents.");
			System.out.println("**********************************************************************************");
			System.out.println();
			System.out.println("Enter your Choice : ");
			switch(sc.nextInt()) {
				case 0: System.out.println("You have been exited!");
						System.exit(0);
				case 1: System.out.println("Enter the elements to add : ");
						ele = sc.nextInt();
						if(!list.addAtBegining(ele)) {
							System.out.println("Element "+ele+" not inserted!");
						} else {
							System.out.println("Element "+ele+" inserted successfully!");
						}
						break;
						
				case 2: System.out.println("Enter the elements to add : ");
						ele = sc.nextInt();
						if(!list.addAtEnd(ele)) {
							System.out.println("Element "+ele+" inserted successfully!");
						} else {
							System.out.println("Element "+ele+" not inserted!");
						}
						break;
						
				case 3: System.out.println("Enter the position you want to insert : ");
						int pos = sc.nextInt();
						System.out.println("Enter the elements to add : ");
						ele = sc.nextInt();
						
						if(!list.addAtPosition(pos, ele)) {
							System.out.println("Element "+ele+" not inserted into the linked list!");
							System.out.println("Because list is empty. Try option 1 first.");
						}
						else
							System.out.println(ele+" inserted at "+pos+" position sucessfully!");
						break;
				case 4: {
							ele = list.deleteAtBegining();
							System.out.println("Element "+ele+" is deleted Successfully!");
							list.display();
						}
						break;
						
				case 5: {
							ele = list.deleteAtEnd();
							System.out.println("Element "+ele+" is deleted Successfully!");
							list.display();
						}
						break;
						
				case 6: System.out.println("Enter the position you want to delete : ");
						pos = sc.nextInt();
						if(list.deleteAtPosition(pos)) {
							System.out.println("Element not deleted from the linked list!");
						} else {
							System.out.println("Element is deleteded from the linked list successfully!");
							list.display();
						}
						break;
						
				case 7: {
							if(!list.reverseList()) {
								System.out.println("Reversing operation failed!");
							} else {
								System.out.println("List revered successfully!");
							}
							list.display();
							break;
						}
						
				case 8: {
							if(!list.findLoopInList()) {
								System.out.println("Loop found in the list.");
							} else {
								System.out.println("No loop found in the list.");
							}
							break;
						}
						
				case 9: list.display();
						 break;
						 
				default: System.out.println("Enter correct choice!");
						 break;
			}
		}
		
		sc.close();
	}

}
