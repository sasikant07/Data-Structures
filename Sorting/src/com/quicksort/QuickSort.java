package com.quicksort;

import java.util.Scanner;

public class QuickSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the size of the array : ");
		int size = sc.nextInt();
		
		int arr[] = new int[size];
		
		System.out.println("Enter the elements of the array : ");
		for(int i=0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println("Array elements before sorting");
		for(int i=0;i<arr.length;i++) {
			System.out.print("["+arr[i]+"] ");
		}
		
		System.out.println("\n");
		
		quickSort(arr, 0, size - 1);
		
		System.out.println("Array elements after sorting are as follows : ");
		for(int i=0;i<arr.length;i++) {
			System.out.print("["+arr[i]+"] ");
		}
		
		System.out.println();
		
		sc.close();
	}

	private static void quickSort(int[] arr, int start, int end) {
		
		int pivot,i,j;
		
		if(start < end) {
			pivot = start;
			i = start;
			j = end;
			
			while(i < j) {
				while(arr[i] < arr[pivot]) 
					i++;
				while(arr[j] > arr[pivot])
					j--;
				
				if(i < j) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			
			int temp = arr[pivot];
			arr[pivot] = arr[j];
			arr[j] = temp;
			
			quickSort(arr, start, j-1);
			quickSort(arr, j+1, end);
		}
	}

	

}
