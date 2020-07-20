package com.tree.avl;

public class AVLTree {
	Node root;
	
	public int height(Node N) {
		if (N == null)
			return 0;
		return N.height;
	}
	
	public int max(int a, int b) {
		return (a > b) ? a : b;
	}
	
	public Node leftRotate(Node x) {
		Node y = x.right;
		Node z = y.left;
		
		y.left = x.right;
		x.right = z;
		
		x.height = max(height(x.left), height(x.right)) + 1;
		y.height = max(height(y.left), height(y.right)) + 1;
		
		return y;
	}
	
	public Node rightRotate(Node y) {
		Node x = y.left;
		Node z = x.right;
		
		x.right = y;
		y.left = z;
		
		y.height = max(height(y.left), height(y.right)) + 1;
		x.height = max(height(x.left), height(x.right)) + 1;
		
		return x;
	}
	
	// Get the balance factor of the node
	public int getBalanceFactor(Node N) {
		if (N == null)
			return 0;
		return height(N.left) - height(N.right);
	}
	
	// Insert a node 
	public Node insert(Node node, int ele) {
		// Find the position and insert the node
		if (node == null)
			return (new Node(ele));
		else if (ele < node.item)
			node.left = insert(node.left, ele);
		else if(ele > node.item)
			node.right = insert(node.right, ele);
		else
			return node;
		
		// Update the balance factor of each node
		// And, re balance the tree
		
		node.height = 1 + max(height(node.left), height(node.right));
		int balanceFactor = getBalanceFactor(node);
		
		if (balanceFactor > 1) {
			if (ele < node.left.item) {			// If element is in less and all in left order, use Right Rotation(RR)
				return rightRotate(node);
			} else if (ele > node.left.item) {  // If element is greater and in right and left order, use Left then Right rotation(L-RR)
				node.left = leftRotate(node.left);
				return rightRotate(node);
			}
		}
		
		if (balanceFactor < -1) {		// If element is greater and all in right order, use Left Rotation(LR)
			if (ele > node.right.item) {
				return leftRotate(node);
			} else if (ele < node.right.item) {		// If element id less and in left and right order, use Right rotation and then Left Rotation(R-LR)
				node.right = rightRotate(node.right);
				return leftRotate(node);
			}
		}
		return node;
	}
	
	public Node nodeWithMinimumValue(Node node) {
		Node current = node;
		
		while (current != null)
			current = current.left;
		return current;
	}
	
	// Delete a node
	public Node delete(Node root, int ele ) {
		// Find the node to be deleted and remove it
		if (root == null)
			return root;
		else if (ele < root.item)
			root.left = delete(root.left, ele);
		else if (ele > root.item)
			root.right = delete(root.right, ele);
		else {
			// the element has been found, now delete it
			if ((root.left == null) || (root.right == null)) {
				Node temp = null;
				if (temp == root.left)
					temp = root.right;
				else
					temp = root.left;
				if (temp == null) {
					temp = root;
					root = null;
				} else 
					root = temp;
			} else {
				Node temp = nodeWithMinimumValue(root.right);
				root.item = temp.item;
				root.right = delete(root.right, ele);
			}
		}
		
		if (root == null)
			return root;
		
		// Update the balance factor of each node and balance the tree
		root.height = max(height(root.left), height(root.right)) + 1;
		int balanceFactor = getBalanceFactor(root);
		
		if (balanceFactor > 1) {
			if (getBalanceFactor(root.left) >= 0) {
				return rightRotate(root);
			} else {
				root.left = leftRotate(root.left);
				return rightRotate(root);
			}
		}
		
		if (balanceFactor < -1) {
			if (getBalanceFactor(root.right) <= 0) {
				return leftRotate(root);
			} else {
				root.right = rightRotate(root.right);
				return rightRotate(root);
			}
		}
		
		return root;
	}
	
	// PreOrder processor
	public void preOrder(Node node) {
		if (node !=  null) {
			System.out.println(node.item + "\t");
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	// Print the tree
	public void printTree(Node current, String indent, boolean last) {
		if (current != null) {
			System.out.println(indent);
			if (last) {
				System.out.println("R----");
				indent += "   ";
			} else {
				System.out.println("L----");
				indent += "|   ";
			}
			System.out.println(current.item);
			printTree(current.left, indent, false);
			printTree(current.right, indent, true);
		}
	}
}
