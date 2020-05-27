package com.example;

public class SinglyLinkedList {
	
	private Node head;
	private Node tail;
	private int count;
	
	public SinglyLinkedList() {
		this.head = null;
		this.tail = null;
		this.count = 0;
	}
	
	// returns size of the list.
	public int size() {
		return count;
	}
	
	// Check whether list is empty;
	public boolean isListEmpty() {
		if(head == null && tail == null)
			return true;
		else
			return false;
	}
	
	// Insert data at the beginning of the list.
	public boolean addAtBegining(int ele) {
		Node t = new Node();                 // create a node
		t.setData(ele);                      // set its data
		
		if(isListEmpty()) {
			t.setNext(null);				// attach it
			head = t;
			tail = t;
			count++;
			return true;
		} else {
			t.setNext(head);
			head = t;
			count++;
			return true;
		}
	}
	
	// Insert data at the end of the list.
	public boolean addAtEnd(int ele) {
		Node t = new Node();
		t.setData(ele);
			
		if(isListEmpty()) {
			t.setNext(null);
			head = t;
			tail = t;
			count++;
			return true;
		} else {
			t.setNext(null);
			tail.setNext(t);
			tail = t;
			count++;
			return false;
		}
	}
	
	// Insert data at a desired position of the list.
	public boolean addAtPosition(int pos, int ele) {
		if(count > 0) {
			if(count >= pos-1) {							//Check sufficient node or not.
				Node p = head;
				Node q = head.getNext();
				
				int num = 0;
				
				while(num != pos-2) {
					p = p.getNext();
					q = q.getNext();						// Position the pointer before and after the node.
					num++;
				}
				
				Node temp = new Node();						// Create a node
				temp.setNext(q);
				temp.setData(ele);							// Set it's Data
				p.setNext(temp);							// attach it
				count++;
				return true;
			}
		}
		return false;
	}
	
	// Delete a data at the beginning of the list.
	public int deleteAtBegining() {
		
		int ele = head.getData();				//Get the data
		
		if(!isListEmpty()) {
			if(head == tail) {
				head = null;				// Detach the node
				tail = null;
				count--;					// Delete the node 
			} else {
				head = head.getNext();
				count--;
			}
		} else {
			System.out.println("No element is present in the node to delete.");
		}
		return ele;
	}
	
	// Delete a data at the end of the list
	public int deleteAtEnd() {
		
		int ele = tail.getData();
		
		if(!isListEmpty()) {
			
			if(head == tail) {
				head = null;
				tail = null;
				count--;
			} else {
				Node t = head;
				
				while(tail != t.getNext()) {
					t = t.getNext();
				}
				
				t.setNext(null);
				tail = t;
				count--;
			}
		} else {
			System.out.println("No element is present in the node to delete.");
		}
		
		return ele;
	}
	
	// Delete a data at a desired choice of the list
	public boolean  deleteAtPosition(int pos) {
		if(!isListEmpty() && pos > 1) {
			if(head == tail) {
				head = null;
				tail = null;
				count--;
			} else {
				Node p = head;					// Position your pointer before and after the node.
				Node q = head.getNext();
				
				int num = 0;
				while (num != pos-2) {
					p = p.getNext();			// Traverse to the node to be deleted.
					q = q.getNext();
					num++;
				}
				q = q.getNext();            // Point the pointer to the next node of to be deleted node.
				p.setNext(q);				// Attach the node with the next node of the to be deleted node.
				count--;
			}
		} else {
			deleteAtBegining();
		}
		
		return false;
	}
	
	// Reverse the contents of the list.
	public boolean reverseList() {
		if(!isListEmpty()) {
			Node newHead = head, t = null;				//Detach head from the original one.
			
			head = head.getNext();
			
			newHead.setNext(null);
			
			tail = newHead;
			
			while(head != null) {
				t = head;
				head = head.getNext();
				t.setNext(newHead);
				newHead = t;
			}
			head = newHead;							// Attach head in the new one.
			return true;
		}
		
		return false;
	}
	
	// Check whether the list contains any loop inside it.
	public boolean findLoopInList() {
		Node p = head;
		Node q = head;
		
		while(p!=null && q != null && p.getNext() != null) {
			p = p.getNext().getNext();
			q = q.getNext();
		}
		
		if(p == q) {
			return true;
		}
		
		return false;
	}
	
	// Display the contents of the list.
	public void display() {
		if(isListEmpty()) {
			System.out.println("No item to display.");
			return;
		}
		System.out.println("List Contents : ");
		Node t = null;
		t = head;
		while(t != null) {
			System.out.print("[ "+t.getData()+" ]---");
			t = t.getNext();
		}
		System.out.println("NULL");
	}
}
