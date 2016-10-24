package ds.arrays;

import java.util.Arrays;

/**
 * Copy/merge array1 of size 'm' to an array2 of size 'm+n' 
 * Array1 : contains only m elements 
 * array2 : contains n elements stored in array of size 'm+n'
 * 
 * O/p : sorted arr2 with copies contents of array1
 * 
 * array1 : 1,3,4,6  (m=4)
 * array2 : 4, -1, 5,-8, -1, -1, -1 (m+n = 7), -1 indicates empty place holders
 * 
 * 
 * Note : assuming arrays have positive integers only, no dups
 * 
 * @author bboggaramrama
 *
 */
public class ArrayMerger {

	public static void main(String args[]) {
		ArrayMerger driver = new ArrayMerger();
		driver.copyArrays(new int[] {5,7,9,25},new int[] {2,8,-1,-1,-1,13,-1,15,20});
		
		// Tests
	}
	
	/**
	 * 1. Move all the elements in array2 to end
	 * 2. Then start merge step from array1 and array2 (from end), Keep adding the smallest to start of array2. thats it !! 
	 */
	public void copyArrays(int[] arr1, int[] arr2) {
		
		// Move all the elements in array2 to end. Keep two pointers i and j, Start decrementing them over copying on non -1's
		int m = arr1.length;
		int n = arr2.length;
		int i = n-1, j = n-1;
		while(i >= 0) {
			if(arr2[i] != -1) {
				arr2[j] = arr2[i];
				i--;
				j--;
			} else {
				i--;
			}
		}
		
	// Lets start the  merge step and comparing, copying resply
	 i = 0; // Start of first array
	 j = n - m -1 ; // start of second array
	 int k = 0;
		while (k < n-1 && j<n ) {
			int element1 = arr1[i];
			int element2 = arr2[j];

			if (element1 > element2) {
				arr2[k] = element2;
				j++;
			} else {
				arr2[k] = element1;
				i++;
			}

			k++; // Increment the k to keep track of where we are at copying the
					// arr2
		}
		System.out.println(Arrays.toString(arr2));
	}
	
}
