/**
 * 
 */
package me.learn.personal.month5;

import java.util.Arrays;

/**
 * Title 279 :
 * 
 * Date : Dec 23, 2020
 * 
 * @author bramanarayan
 *
 */
public class PerfectSquaresSumToN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		PerfectSquaresSumToN solution = new PerfectSquaresSumToN();
		System.out.println(solution.numSquares(12));
	}

	// Find the least number of perfect squares that sum up to N
	public int numSquares(int n) {

		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j * j <= i; j++) {
				
				dp[i] = Math.min(dp[i], dp[i-j*j] +1 ); // You basically subtract J*J from i. so you add exactly 1 since you subtract a sqaure
			}
		}
		return dp[n];
	}

}
