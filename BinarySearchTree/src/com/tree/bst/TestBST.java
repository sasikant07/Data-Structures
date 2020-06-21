package com.tree.bst;

import java.util.Scanner;

public class TestBST {
	
	public static TreeNode root = null;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BinarySearchTree bst = new BinarySearchTree();
		
		int ele;
		
		boolean exit = false;
		
		while(!exit) {
			System.out.println("\n");
			System.out.println("****************************** Tree Menu *********************************");
			System.out.println("0. Exit.");
			System.out.println("1. Insert Node.");
			System.out.println("2. Delete Node");
			System.out.println("3. Inorder of Node.");
			System.out.println("4. Preorder of Node.");
			System.out.println("5. Postorder of Node.");
			System.out.println("6. Find the root node.");
			System.out.println("7. Find the minimum element in the tree.");
			System.out.println("8. Find the maximum element in the tree.");
			System.out.println("9. Find an elemnt in the tree.");
			System.out.println("10. Find the total height of the tree.");
			System.out.println("11. Display the data in the tree.");
			System.out.println();
			System.out.println("**************************************************************************");
			System.out.println("\n");
			System.out.println("Enter your choice : ");
			
			switch(sc.nextInt()) {
				case 0 : System.out.println("You are exited !"); 
						 System.exit(0);
						 break;
						 
				case 1: System.out.println("Enter the elements you want to add : ");
						ele = sc.nextInt();
						bst.insert(ele);
						System.out.println(ele+" is inserted into the tree successfully!");
						break;
						
				case 2: System.out.println("Enter the element you want to delete in the tree : ");
						ele = sc.nextInt();
						bst.delete(bst.root, ele);
						break;
						
				case 3:	bst.inorder(bst.root);
						break;
						
				case 4: bst.preorder(bst.root);
						break;
						
				case 5: bst.postorder(bst.root);
						break;
						
				case 6: System.out.println("Root node is : "+bst.getRootNode());
						break;
						
				case 7: System.out.println("Minimum element in the tree is : "+bst.findMin(bst.root));
						break;
						
				case 8: System.out.println("Maximum element in the tree is : "+bst.findMax(bst.root));
						break;
						
				case 9: System.out.println("Enter the elemnets to search in the tree : ");
						ele = sc.nextInt();
						if(!bst.search(ele)) {
							System.out.println(ele+" not found in the tree.");
						} else {
							System.out.println(ele+" found in the tree.");
						}
						break;
						
				case 11: bst.displayData(); break;
				
				case 10: System.out.println("Total height of the tree : "+bst.heightOfTree(bst.root));
						break;
						
				default: System.out.println("Enter correct choice!");
						 break;
			}
		}
		sc.close();
	}

}
