package com.tree.bst;

public class BinarySearchTree {
	TreeNode root;
	
	//constructor
	public BinarySearchTree() {
		this.root = null;
	}
	
	
	// To get the root node.
	public TreeNode getRootNode() {
		return root;
	}
	
	// Display the data in the tree.
	public void displayData(){
        System.out.println("Tree Contents : ");
		System.out.print(root.getData()+ " ---> ");
    }
	
	//Insert element in the tree node.
	public void insert(int ele) {
		TreeNode t = new TreeNode();
		t.setLeft(null);
		t.setData(ele);
		t.setRight(null);
		
		if(root == null) {
			root = t;
		} else {
			TreeNode current = root;
			
			while(current != null) {
				if(ele == current.getData()) {
					System.out.println("Duplicate values.");
				}
				
				if(ele < current.getData()) {
					if(current.getLeft() == null) {
						current.setLeft(t);
						return;
					} else {
						current = current.getLeft();
					}
				} else {
					if(current.getRight() == null) {
						current.setRight(t);
						return;
					} else {
						current = current.getRight();
					}
				}
			}
		}
	}
	
	
	//Delete the element in the tree node.
	public TreeNode delete(TreeNode root, int ele) {
		if(root == null) {
			return null;
		}
		if(root.getData() > ele) {
			root = delete(root.getLeft(), ele);
		} else if(root.getData() < ele) {
			root = delete(root.getRight(), ele);
		} else {
			if(root.getLeft() != null && root.getRight() != null) {
				TreeNode temp = root;
				TreeNode minNode = findMin(temp.getRight());
				root = minNode;
				
				root = delete(root.getRight(), ele);
			} else if(root.getLeft() != null) {
				root = root.getLeft();
			} else if(root.getRight() != null) {
				root = root.getRight();
			} else {
				root = null;
			}
		}
		return root;
	}
	
	
	/*  public void delete(TreeNode temp) {
			if(temp != null) {
				delete(temp.getLeft());
				delete(temp.getRight());
			} else {
				temp = null;
			}
	    }
	*/
	
	// Inorder operation
	public void inorder(TreeNode temp) {
		
		if(temp != null) {
			inorder(temp.getLeft());
			System.out.println(temp.getData()+" \t ");
			inorder(temp.getRight());
		}
	}
	
	// Preorder operation
	public void preorder(TreeNode temp) {
		
		if(temp != null) {
			System.out.println(temp.getData()+" \t ");
			preorder(temp.getLeft());
			preorder(temp.getRight());
		}
	}
	
	
	//Postorder operation
	public void postorder(TreeNode temp) {
		
		if(temp != null) {
			postorder(temp.getLeft());
			postorder(temp.getRight());
			System.out.println(temp.getData()+" \t ");
		}
	}
	
	
	// Search a element in the tree node.
	public boolean search(int ele) {
		
		TreeNode temp = root;
		
		while(temp != null) {
			if( ele == temp.getData()) {
				return true;
			} else if(ele < temp.getData()) {
				temp = temp.getLeft();
			} else {
				temp = temp.getRight();
			}
		}
		
		return false;
	}
	
	// Find the minimum element in the tree.
	public TreeNode findMin(TreeNode temp) {
		if( temp == null || temp.getLeft() == null) {
			return temp;
		} else {
			return findMin(temp.getLeft());
		}
	}
	
	// Find the maximum element in the tree.
	public TreeNode findMax(TreeNode temp) {
		if( temp == null || temp.getRight() == null) {
			return temp;
		} else {
			return findMax(temp.getRight());
		}
	}
	
	// FInd the total height of the tree.
	public int heightOfTree(TreeNode temp) {
		
		int l = 0, r = 0;
		
		if(temp == null) {
			return 0;
		}
		
		l = heightOfTree(temp.getLeft());
		r = heightOfTree(temp.getRight());
		
		if(l > r || l == r) {
			return (l+1);
		} else {
			return (r+1);
		}
	}
}
