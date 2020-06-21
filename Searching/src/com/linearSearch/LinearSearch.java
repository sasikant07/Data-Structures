package com.linearSearch;

import java.util.Scanner;

public class LinearSearch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the size of the array : ");
		int size = sc.nextInt();
		
		int arr[] = new int[size];
		
		System.out.println("Enter the elements of the array : ");
		for(int i=0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println("Enter the elements you want to search : ");
		int ele = sc.nextInt();
		
		int index = linearSearch(arr, ele);
		
		for(int i=0;i<arr.length;i++) {
			System.out.print("["+arr[i]+"] ");
		}
		
		System.out.println();
		
		if(index == -1) {
			System.out.println("Element "+ele+" not found in the array.");
		} else {
			System.out.println("Element "+ele+" found at index "+index);
		}
		
		sc.close();
	}

	private static int linearSearch(int[] arr, int ele) {
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i] == ele) {
				return i;
			}
		}
		
		return -1;
	}

}
