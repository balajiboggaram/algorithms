/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 198 : 
 * 
 * Date : Dec 15, 2020
 * 
 * @author bramanarayan
 *
 */
public class HouseRobberMaxProfit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int[] dp;

	public int rob(int[] a) {
		int n = a.length;
		if (n == 0)
			return 0;
		if (n == 1)
			return a[0];
		dp = new int[n];

		dp[0] = a[0];
		dp[1] = Math.max(a[0], a[1]);
		for (int i = 2; i < n; i++) {
			dp[i] = Math.max(dp[i - 2] + a[i], dp[i - 1]); // either I rob or dont rob the home 'i'
		}

		return Math.max(dp[n - 1], dp[n - 2]);

	}

}
