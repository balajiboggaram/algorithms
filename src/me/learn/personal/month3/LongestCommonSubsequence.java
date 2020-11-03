/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title 1143 :
 * 
 * Given two strings text1 and text2, return the length of their longest common
 * subsequence.
 * 
 * A subsequence of a string is a new string generated from the original string
 * with some characters(can be none) deleted without changing the relative order
 * of the remaining characters. (eg, "ace" is a subsequence of "abcde" while
 * "aec" is not). A common subsequence of two strings is a subsequence that is
 * common to both strings.
 * 
 * 
 * 
 * If there is no common subsequence, return 0.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: text1 = "abcde", text2 = "ace" Output: 3 Explanation: The longest
 * common subsequence is "ace" and its length is 3.
 * 
 * 
 * 
 * @author bramanarayan
 * @date Jul 6, 2020
 */
public class LongestCommonSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LongestCommonSubsequence solution = new LongestCommonSubsequence();
		System.out.println(solution.longestCommonSubsequence("abcde", "ace"));
		System.out.println(solution.printLongestCommonSubsequence("abcde", "ace"));
		System.out.println(solution.printLongestCommonSubsequence("abc", "def"));
		System.out.println(solution.printLongestCommonSubsequence("unitedstatesofamerica", "states"));

	}

	// DYNAMIC PROGRAMMING
	public int longestCommonSubsequence(String s1, String s2) {

		int m = s1.length();
		int n = s2.length();
		int[][] dp = new int[m + 1][n + 1];

		// DP init
		// an empty string on s1 or s2 will have 0 as max sub sequence
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				}
			}
		}

		// DP runner
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {

				char x = s1.charAt(i - 1);
				char y = s2.charAt(j - 1);

				if (x == y) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[m][n];

	}

	// PRINT LONGEST COMMON SUBSEQUENCE
	public String printLongestCommonSubsequence(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int[][] dp = new int[m + 1][n + 1];

		// DP init
		// an empty string on s1 or s2 will have 0 as max sub sequence
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				}
			}
		}

		// DP runner
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {

				char x = s1.charAt(i - 1);
				char y = s2.charAt(j - 1);

				if (x == y) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		// print routine
		StringBuilder sb = new StringBuilder();
		int i = m, j = n;
		while (i > 0 && j > 0) {

			char x = s1.charAt(i - 1);
			char y = s2.charAt(j - 1);
			
			if(x == y) {
				sb.append(x);
				i--;
				j--;
			} else {
				if(dp[i-1][j] > dp[i][j-1]) {
					i--;
				}else {
					j--;
				}
			}
		}
		return sb.reverse().toString();

	}
}
