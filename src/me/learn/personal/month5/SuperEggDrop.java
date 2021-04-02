/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 887 :
 * 
 * Date : Dec 22, 2020
 * 
 * @author bramanarayan
 *
 */
public class SuperEggDrop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	// THis gets to TLE. You can solve it via binomial co efficient too, Check notes
	// n - eggs
	// k - floors
	// Minimum trials required to check critical floow by drop n eggs from k floors
	public int superEggDrop(int k, int n) {

		if (k == 0)
			return 1;
		if (n == 0)
			return 0;

		int[][] dp = new int[n + 1][k + 1];

		// no egg
		for (int j = 1; j <= k; j++) {
			dp[0][j] = Integer.MAX_VALUE; // no egg at all, I need infinite tries
			dp[1][j] = j; // only one egg.. so I need same tries as # of floors are.
		}

		// no floors
		for (int i = 1; i <= n; i++) {
			dp[i][0] = 0; // no floors
			dp[i][1] = 1;// one floor
		}

		// runner
		for (int i = 2; i <= n; i++) {
			for (int j = 2; j <= k; j++) {
				dp[i][j] = Integer.MAX_VALUE;
				for (int x = 1; x <= j; x++) {
					int trail1 = dp[i - 1][x - 1]; // trails when egg breaks, I have one less egg i-1 and have to try x-1
													// floors yet.
					int trail2 = dp[i][j - x]; // trails when egg do not break, I have not lost any egg, so i. and have
												// j-x floors to try yet.
					
					dp[i][j] = Math.min(dp[i][j], 1 + Math.max(trail1, trail2)); // add one as you lost one trial, max is for worst case
				}

			}
		}

		return dp[n][k];

	}

}
