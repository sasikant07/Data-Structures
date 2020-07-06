package com.mergesort;

import java.util.Scanner;

public class MergeSort {

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
		
		mergeSort(arr, 0, size - 1);
		
		System.out.println("Array elements after sorting are as follows : ");
		for(int i=0;i<arr.length;i++) {
			System.out.print("["+arr[i]+"] ");
		}
		
		System.out.println();
		
		sc.close();

	}

	private static void mergeSort(int[] arr, int low, int high) {
		
		if(low < high) {							// check if low is smaller than high, if not then the array is sorted
			
			int middle = low + (high - low) / 2;	// Get the index of the element which is in the middle
			
			mergeSort(arr, low, middle);			// Sort the left side of the array
			
			mergeSort(arr, middle + 1, high);		// Sort the right side of the array
			
			merge(arr, low, middle, high);			// Combine them both
		}
		
	}

	private static void merge(int arr[], int low, int middle, int high) {
		
		int i = low;
		int j = middle + 1;
		int k = low;
		int index = low;
		
		int temp[] = new int[arr.length];
		
		// Copy the smallest values from either the left or the right side back to the original array
		
		while(i <= middle && j <= high) {
			if(arr[i] < arr[j]) {
				temp[index] = arr[i];
				i++;
			} else {
				temp[index] = arr[j];
				j++;
			}
			index++;
		}
			
		if(i > middle) {
			while(j <= high) {
				temp[index] = arr[j];
				index++;
				j++;
			}
		} else {
			while (i <= middle) {
				temp[index] = arr[i];
				index++;
				i++;
			}
		}
		
		while(k < index) {
			arr[k] = temp[k];
			k++;
		}
			
	}

}
