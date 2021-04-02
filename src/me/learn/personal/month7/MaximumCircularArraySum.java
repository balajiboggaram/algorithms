/**
 * 
 */
package me.learn.personal.month7;

/**
 * Title 918 :
 * 
 * Date : Feb 26, 2021
 * 
 * @author bramanarayan
 *
 */
public class MaximumCircularArraySum {

	// SIMILAR TO KADANE BUT THIS IS CIRCULAR
	public int maxSubarraySumCircular(int[] A) {

		// COmpute non-circular sum - Regular kadane algorithm
		int nonCircularSum = kadaneMaxSum(A);
		int totalSum = 0;
		for (int i = 0; i < A.length; i++) {
			totalSum += A[i];
			A[i] = -A[i]; // try to make this as negative as you need to account for circular sum in next
							// step. find minSum, totalSum - minSum = maxCircularSum
		}

		
		// Compute max circular sum
		int circularSum = totalSum + kadaneMaxSum(A);
		if (circularSum == 0)
			return nonCircularSum;
		return Math.max(circularSum, nonCircularSum);
	}

	int kadaneMaxSum(int[] A) {
		int currentSum = A[0];
		int maxSum = A[0];
		for (int i = 1; i < A.length; i++) {
			if (currentSum < 0)
				currentSum = 0;
			currentSum = A[i] + currentSum;
			maxSum = Math.max(maxSum, currentSum);
		}
		return maxSum;
	}

}
