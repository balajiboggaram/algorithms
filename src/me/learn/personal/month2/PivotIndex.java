/**
 * 
 */
package me.learn.personal.month2;

/**
 * Title 724 : Given an array of integers nums, write a method that returns the "pivot" index of this array.

We define the pivot index as the index where the sum of all the numbers to the left of the index is equal to the sum of all the numbers to the right of the index.

If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.

Example 1:

Input: nums = [1,7,3,6,5,6]
Output: 3
Explanation:
The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
Also, 3 is the first index where this occurs.

 * 
 * @author bramanarayan
 * @date Jun 11, 2020
 */
public class PivotIndex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PivotIndex solution = new PivotIndex();
		System.out.println(solution.pivotIndex(new int[] {1,7,3,6,5,6}));
		System.out.println(solution.pivotIndex(new int[] {1,2,3}));

	}

	public int pivotIndex(int[] a) {
		int n = a.length;
		int[] leftSum = new int[n];

		if(n ==0) return -1;
		// Compute the left sum
		leftSum[0] = a[0];
		for (int i = 1; i < n; i++) {
			leftSum[i] = a[i] + leftSum[i - 1];
		}

		// COmpute the rightSum as variable
		int rSum = 0, result = -1;
		for (int i = n - 1; i >= 0; i--) {
			rSum = rSum + a[i];
			if (rSum == leftSum[i]) {
				result = i;
			}
			
		}

		return result;
	}
}
