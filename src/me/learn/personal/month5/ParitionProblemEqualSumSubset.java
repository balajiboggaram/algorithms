/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 416 :
 * 
 * Date : Dec 22, 2020
 * 
 * @author bramanarayan
 *
 */
public class ParitionProblemEqualSumSubset {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// in to two subsets? ? find subset with target sum = sum/2
	public boolean canPartition(int[] a) {

		int sum = 0;
		int n = a.length;
		for (int i = 0; i < n; i++) {
			sum += a[i];
		}

		if (sum % 2 == 1)
			return false;

		// now, our idea is to find a subset in a which equal to sum/2.

		// we will use Dyanmic programming for this part
		boolean[][] dp = new boolean[sum / 2 + 1][n + 1];

		// if sum is 0
		for (int j = 0; j <= n; j++) {
			dp[0][j] = true;
		}

		// if no elements at all
		for (int i = 1; i <= sum / 2; i++) {
			dp[i][0] = false;
		}

		for (int i = 1; i <= sum / 2; i++) {
			for (int j = 1; j <= n; j++) {
				// do not pick the element 'j'
				dp[i][j] = dp[i][j - 1];
				if (i >= a[j - 1]) {
					dp[i][j] = dp[i][j] || dp[i - a[j - 1]][j - 1]; // subtract the a[j-1]'th element from sum
				}
			}
		}

		return dp[sum / 2 + 1][n];

	}
}
