package com.java8NewFeatures.parallelSorting;
import java.util.Arrays;
public class ParallelArraySortingWithFromIndexToIndex {
	public static void main(String[] args) { 
		// Creating an integer array 
		int[] arr = {5,8,1,0,6,9,50,-3};
		// Iterating array elements 
		for (int i : arr) { System.out.print(i+" ");
		}
		// Sorting array elements parallel and passing start, end index
		Arrays.parallelSort(arr,0,4);
		System.out.println("\n Array elements after sorting");
		// Iterating array elements
		for (int i : arr) { System.out.print(i+" "); 
		} 
		} 
	
	}
