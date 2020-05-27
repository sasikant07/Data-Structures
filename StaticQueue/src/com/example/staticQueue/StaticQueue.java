package com.example.staticQueue;

public class StaticQueue {
	private int size;
	private int arr[];
	private int front;
	private int rear;
	
	public StaticQueue(int size) {
		this.size = size;
		this.arr = new int[size];
		this.front = 0;
		this.rear = 0;
	}
	
	public boolean isEmpty() {
		return (front == rear);
	}
	
	public boolean isFull() {
		return (size == rear);
	}
	
	public void enQueue(int element) {
		if(!isFull()) {
			arr[rear] = element;
			rear++;
			System.out.println("Added element : "+element);
		} else {
			System.out.println("Queue Overflow!");
		}
	}
	
	public void deQueue() {
		if(!isEmpty()) {
			int temp = arr[front++];
			System.out.println("Deleted Queue is : "+temp);
		} else {
			System.out.println("Queue Underflow!");
		}
	}
	
	public void display() {
		for(int i=front;i<rear;i++) 
			System.out.print(arr[i]+" ");
		System.out.println("\n");
	}
	
	public void menu() {
		System.out.println("******************************* Queue Menu **************************************");
		System.out.println("1. Add Element in the Queue.");
		System.out.println("2. Delete Element in the Queue.");
		System.out.println("3. Display Element in the Queue.");
		System.out.println("0. Exit.");
		System.out.println("*********************************************************************************");
	}
}