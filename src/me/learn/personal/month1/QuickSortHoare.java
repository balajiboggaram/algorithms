package me.learn.personal.month1;

import java.util.Arrays;

import me.learn.utli.Utils;

/**
 * Title : Quick Sort using in place partition - Hoare Partitioning
 * 
 * In Haore partition scheme, we always pick the middle element as pivot.
 * 
 * @author bramanarayan
 * @date Apr 20, 2020
 */
public class QuickSortHoare {
	
	public static void main(String args[]) {
				
		int a[] = new int[] {1,10,6,9,8,5};
		quickSort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));

		a = new int[] {1,5,6,7,8};
		quickSort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));

		a = new int[] {};
		quickSort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));
		
		a = new int[] {1};
		quickSort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));

		a = new int[] {80,70,60,50,40,30};
		quickSort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));
		
        a = new int[] {10, 7, 8, 9, 1, 5}; 
		quickSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	
	}
	
	public static void quickSort(int[] a, int low, int high) {
		int p;
		if(low < high) {
			p = partition(a, low, high);

			quickSort(a,low,p);
			quickSort(a, p+1, high);
		}
			}
	
	public static int partition(int[] a, int low, int high) {
		
		// Choose the mid element as pivot here
		int mid = (high-low)/2 + low;
		int pivot = a[mid];
		
		// Initialize the two markers - i on left and j on right 
		int i = low;
		int j = high;
		
		while(i<j) { // Loop until both the markers meet

			while( a[i] < pivot) { 			// Increment from left side
				i++;
			}

			while( a[j] > pivot) {				// Decrement from right side
				j--;
			}
			Utils.swap(a, i, j);  // swap the elements at i and j index
		}
		return i;
	}	
}
