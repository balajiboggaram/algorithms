/**
 * 
 */
package me.learn.personal.month5;

import java.util.Arrays;

/**
 * Title 977 :
 * 
 * Date : Dec 30, 2020
 * 
 * @author bramanarayan
 *
 */
public class SquareOfSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	/**
	 * 
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]

 

Constraints:

    1 <= nums.length <= 104
    -104 <= nums[i] <= 104
    nums is sorted in non-decreasing order.

Accepted
383,165
Submissions
529,610
Seen this question in a real interview before?
Merge Sorted Array
Easy
Sort Transformed Array
Medium
/154

	 */
	
	
	// given an integer array in increasing order, return the sorted array of their squares in increasing order too. 
	// the catch here is with -ve number squares lead to +ve result
	
	// O(n lg n )
	public int[] sortedSquares(int[] a) {
		
		// take the absolute value of num
		for(int i= 0;i< a.length;i++) {	
			a[i] = Math.abs(a[i]);
		}
		
		// sort the array
		Arrays.sort(a);
		
		
		// convert to  swaures
		for(int i= 0;i< a.length;i++) {	
			a[i] = a[i] * a[i];
		}
		
		return a;
	}
	
	// actually this can be done in O(n). 
	// since the array is sorted, iterate the negative elements in reverse order, and positive elements in forward direction. 
	// while you do that, keep computing squares and put in the result array
	
	
	// Algorithm : 
	// #1 - find the highest negative index.
	// #2 - Compute the squares of negative numbers ( negative index -> all the way to 0th index)
	// #3 - compute the squares of positive numbers (negative index + 1 -> all the way till n-1th index)

}
