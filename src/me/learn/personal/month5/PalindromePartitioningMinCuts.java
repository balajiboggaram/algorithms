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
public class PalindromePartitioningMinCuts {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		PalindromePartitioningMinCuts solution = new PalindromePartitioningMinCuts();
		System.out.println(solution.minCut("aab"));
	}

	// 1. you can either find the list of palindromes and see the list size and grab
	// the min.
	// 2. you can solve via dynamic programming too. check below

	// Return the minimum number of cuts required to make the whole string as list
	// of palindromes
	// Fill the DP - list of palindrome words - fill diagonally.
	// Now perform LIS to get the min cuts

	public int minCut(String s) {

		int n = s.length();
		boolean[][] dp = new boolean[n][n];
		int[] cuts = new int[n];

		// strings of length 1 are palindromes
		for (int i = 0; i < n; i++) {
			dp[i][i] = true;
		}

		// Now, lets see lengths of 2 and above
		for (int l = 2; l <= n; l++) { //alias 'k'
			for (int i = 0; i < n - l + 1; i++) {
				int j = i + l - 1;

				// Checking for 2 characters is very important
				if(l ==2) {
					dp[i][j] = s.charAt(i) == s.charAt(j);
				} else if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
					dp[i][j] = dp[i][j] || dp[i + 1][j - 1];
				}

			}
		}

		// ONce you find the palindrome, get the min cuts
		for (int i = 1; i < s.length(); i++) {
			if (dp[0][i] == true) {
				cuts[i] = 0;
			} else {
				cuts[i] = Integer.MAX_VALUE;
				for (int j = 0; j < i; j++) {
					if ( dp[j + 1][i] == true && cuts[i] > cuts[j] + 1) {
						cuts[i] = cuts[j] + 1;
					}
				}
			}

		}
		return cuts[n - 1];

	}

}
