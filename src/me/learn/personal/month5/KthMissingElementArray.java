/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 1539 : kth positive integer missing element from starting of array
 * 
 * Date : Dec 18, 2020
 * 
 * @author bramanarayan
 *
 */
public class KthMissingElementArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int findKthPositive(int[] arr, int k) {
	        int left = 0, right = arr.length - 1;
	        while (left <= right) {
	            int mid = left + (right - left) / 2;
	            // If number of positive integers
	            // which are missing before arr[pivot]
	            // is less than k -->
	            // continue to search on the right.
	            if (arr[mid] - mid - 1 < k) {
	                left = mid + 1;
	            // Otherwise, go left.
	            } else {
	                right = mid - 1;
	            }
	        }

	        // At the end of the loop, left = right + 1,
	        // and the kth missing is in-between arr[right] and arr[left].
	        // The number of integers missing before arr[right] is
	        // arr[right] - right - 1 -->
	        // the number to return is
	        // arr[right] + k - (arr[right] - right - 1) = k + left
	        return left + k;
	    }

}
