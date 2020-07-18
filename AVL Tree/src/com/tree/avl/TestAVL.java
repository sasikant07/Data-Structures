package com.tree.avl;

import java.util.Scanner;

public class TestAVL {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		AVLTree tree = new AVLTree();
		
		// int ele;
		
		boolean exit = false;
		
		while(!exit) {
			System.out.println("\n");
			System.out.println("****************************** Tree Menu *********************************");
			System.out.println("0. Exit.");
			System.out.println("1. Insert Node.");
			System.out.println("2. Delete Node");
			System.out.println("3. Display the data in the tree.");
			System.out.println();
			System.out.println("**************************************************************************");
			System.out.println("\n");
			System.out.println("Enter your choice : ");
			
			switch(sc.nextInt()) {
				case 0 : System.out.println("You are exited !"); 
						 System.exit(0);
						 break;
			 
				case 1: System.out.println("Enter the elements you want to add : ");
						int ele = sc.nextInt();
						tree.root = tree.insert(tree.root, ele);
						tree.printTree(tree.root, "", true);
						break;
				
				case 2:
						break;
						
				case 3: tree.printTree(tree.root, "", true);
						break;
						
				default: System.out.println("Enter correct choice!");
				 		 break;
			}
		}
		
		sc.close();
	}

}
