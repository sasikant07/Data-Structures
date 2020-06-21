package com.binarySearch;

import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the size of the array : ");
		int size = sc.nextInt();
		
		int arr[] = new int[size];
		
		System.out.println("Enter the elements of the array : ");
		for(int i=0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
		
		//Binary search works only on sorted array
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		for(int i=0;i<arr.length;i++) {
			System.out.print("["+arr[i]+"] ");
		}
		
		System.out.println();
		
		System.out.println("Enter the elements you want to search : ");
		int ele = sc.nextInt();
		
		//Recursive implementation of Binary Search
		int index = binarySearch(arr, 0, size-1, ele);
		
		//int index = binarySearch(arr, ele);   //Iterative implementation of Binary Search
		
		if(index == -1) {
			System.out.println("Element "+ele+" not found in the array.");
		} else {
			System.out.println("Element "+ele+" found at index "+index);
		}
		
		sc.close();
	}
	
	//Recursive implementation of Binary Search
	private static int binarySearch(int[] arr, int beg, int end, int ele) {
		
		if(end >= beg) {
			int mid = beg + (end - beg) / 2;
			
			if(arr[mid] == ele) {
				return mid;
			} else if(arr[mid] > ele) {
				return binarySearch(arr, beg, mid-1, ele);
			} 
			
			return binarySearch(arr, mid+1, end, ele);
		}
		return -1;
	}
	
	//Iterative implementation of Binary Search
	private static int binarySearch(int arr[], int ele) 
    { 
        int start = 0, end = arr.length - 1; 
        while (start <= end) { 
            int mid = start + (end - start) / 2; 
  
            // Check if element is present at mid 
            if (arr[mid] == ele) 
                return mid; 
  
            // If element greater, ignore left half 
            if (arr[mid] < ele) 
                start = mid + 1; 
  
            // If element is smaller, ignore right half 
            else
                end = mid - 1; 
        } 
  
        // if we reach here, then element was 
        // not present 
        return -1; 
    } 
}
