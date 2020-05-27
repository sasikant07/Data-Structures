package com.example.stack;

public class StackArray {
	private int size;
	private int arr[];
	private int top;
	
	public StackArray(int size) {
		this.size = size;
		this.arr = new int[size];
		this.top = -1;
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public boolean isFull() {
		return (top == size - 1);
	}
	
	public void push(int element) {
		if(!isFull()) {
			arr[++top] = element;
			System.out.println("Pushed element : "+element);
		} else {
			System.out.println("Stack Overflow!");
		}
	}
	
	public int pop() {
		if(!isEmpty()) {
			System.out.println("Popped element : "+arr[top]);
			return arr[top--];
		} else {
			System.out.println("Stack Underflow!");
			return -1; 
		}
	}
	
	public int peek() {
		if(!this.isEmpty()) {
			System.out.println("Top element : "+arr[top]);
			return arr[top];
		} else {
			System.out.println("Stack is Empty!");
			return -1;
		}
	}
	
	public void menu() {
		System.out.println("******************************* Stack Menu **************************************");
		System.out.println("1. Push Element.");
		System.out.println("2. Pop Element.");
		System.out.println("3. Peek Element.");
		System.out.println("0. Exit.");
		System.out.println("*********************************************************************************");
	}
}
