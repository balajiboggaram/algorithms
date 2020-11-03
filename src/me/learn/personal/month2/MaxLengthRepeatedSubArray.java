/**
 * 
 */
package me.learn.personal.month2;

/**
 * Title 718 :
 * 
 * Given two integer arrays A and B, return the maximum length of an subarray
 * that appears in both arrays.
 * 
 * Example 1:
 * 
 * Input: A: [1,2,3,2,1] B: [3,2,1,4,7] Output: 3 Explanation: The repeated
 * subarray with maximum length is [3, 2, 1].
 * 
 * 
 * @author bramanarayan
 * @date Jun 13, 2020
 */
public class MaxLengthRepeatedSubArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MaxLengthRepeatedSubArray solution = new MaxLengthRepeatedSubArray();
		System.out.println(solution.findLength(new int[] {1,2,3,2,1},new int[] {3,2,1,4,7}));
	}

	/**
	 * DYNAMIC PROGRAMMING - Bottom Up
	 */
	public int findLength(int[] a, int[] b) {

		int m = a.length;
		int n = b.length;

		int[][] dp = new int[m + 1][n + 1];
		int maxLength = 0;
		for (int i = m-1; i >= 0; i--) {
			for (int j = n-1; j >=0; j--) {
				if(a[i] == b[j]) {
					dp[i][j] =  dp[i+1][j+1] + 1;
				}
				maxLength = Math.max(maxLength, dp[i][j]);
			}
		}
		return maxLength;
	}

}
