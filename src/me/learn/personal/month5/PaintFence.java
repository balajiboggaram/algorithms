/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 276 :
 * 
 * Date : Jan 12, 2021
 * 
 * @author bramanarayan
 *
 */
public class PaintFence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numWays(int n, int k) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return k;
		}
		int[] dp = new int[n + 1];
		// initialize special cases
		dp[1] = k;
		dp[2] = k * k;

		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) * (k - 1);
		}
		return dp[n];
	}

}
