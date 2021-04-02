/**
 * 
 */
package me.learn.personal.month6;

import java.util.Arrays;

/**
 * Title 1198 :
 * 
 * Date : Jan 14, 2021
 * 
 * @author bramanarayan
 *
 */
public class FindSmallestCommonElementInRowSortedMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// initializing unsorted array
		int arr[] = { 2, 10, 22, 29 };

		// sorting array
		Arrays.sort(arr);

		// let us print all the elements available
		System.out.println("The sorted array is:");
		for (int number : arr) {
			System.out.println("Number = " + number);
		}

		// entering the value to be searched
		int searchVal = 7;

		int retVal = Arrays.binarySearch(arr, searchVal);

		System.out.println("The index of element 22 is : " + retVal);
	}

	// you can simply sort this using kway merge technique

	// or take every element of first array
	// now search its existence in all other arrays i.e index 1 to n-1
	// the first element you find in all the arrays, that would be the smalles
	// common element
	public int smallestCommonElement(int[][] mat) {

		int m = mat.length;
		int n = mat[0].length;

		for (int j = 0; j < n; j++) {
			int element = mat[0][j];

			// now search for element in rest of the matrices

			boolean notFound = false;
			for (int i = 1; i < m; i++) {
				if (Arrays.binarySearch(mat[i], element) < 0) {
					notFound = true;
					break;
				}
			}

			if (!notFound) // if all found
				return element;

		}

		return -1;

	}
}
