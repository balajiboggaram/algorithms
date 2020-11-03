package me.learn.personal.month1;

import java.util.Arrays;

import me.learn.utli.Utils;

/**
 * Title : Quick Sort using in place partition - Luomoto Partitioning
 * 
 * @author bramanarayan
 * @date Apr 20, 2020
 * 
 * The worst time complexity when the array is already sorted is O[n2]
 * The average case is O[nlogn]
 */
public class QuickSortLumoto {

	public static void main(String args[]) {

		int a[] = new int[] { 1, 10, 6, 9, 8, 5 };
		quickSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));

		a = new int[] { 1, 5, 6, 7, 8 };
		quickSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));

		a = new int[] {};
		quickSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));

		a = new int[] { 1 };
		quickSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));

		a = new int[] { 80, 70, 60, 50, 40, 30 };
		quickSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
		
        a = new int[] {10, 7, 8, 9, 1, 5}; 
		quickSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));

	}

	public static void quickSort(int[] a, int low, int high) {
		int p;
		if (low < high) {
			p = partition(a, low, high);
			quickSort(a, low, p - 1);
			quickSort(a, p + 1, high);
		}
	}

	public static int partition(int[] a, int low, int high) {
		int i, j;
		i = low;
		int pivot = a[high];
		for (j = low; j < high; j++) {
			if (a[j] < pivot) {
				Utils.swap(a, i, j);
				i++;
			}
		}

		Utils.swap(a, i, high);
		return i;
	}
}
