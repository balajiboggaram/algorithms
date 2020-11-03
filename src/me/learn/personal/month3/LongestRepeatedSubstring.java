/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title 1062 :
 * 
 * Given a string S, find out the length of the longest repeating substring(s).
 * Return 0 if no repeating substring exists.
 * 
 * Example 1:
 * 
 * Input: "abcd" Output: 0 Explanation: There is no repeating substring.
 * 
 * Example 2:
 * 
 * Input: "abbaba" Output: 2 Explanation: The longest repeating substrings are
 * "ab" and "ba", each of which occurs twice.
 * 
 * Example 3:
 * 
 * Input: "aabcaabdaab" Output: 3 Explanation: The longest repeating substring
 * is "aab", which occurs 3 times.
 * 
 * 
 * @author bramanarayan
 * @date Jul 14, 2020
 */
public class LongestRepeatedSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LongestRepeatedSubstring solution = new LongestRepeatedSubstring();
		System.out.println(solution.longestRepeatingSubstring("abbaba"));
		System.out.println(solution.longestRepeatingSubstring("abcd"));

	}

	// DYNAMIC PROGRAMMING
	public int longestRepeatingSubstring(String s) {
		int n = s.length();

		int[][] dp = new int[n + 1][n + 1];

	/*	for(int i = 0;i<=n;i++) {
			dp[0][i] = 0;
			dp[i][0] = 0;
		}*/
		
		int res = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j  ) {
					dp[i][j] = 0; // the repeat cannot have same index :)
				}
				
				// dp[i][j] represents longest repeated substrings where  the two substrings
				// each of them represent the string ending with ith and jth character resply. 
				// thus dp[][]
				else if (s.charAt(i - 1) == s.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;

				} else {
					dp[i][j] = 0;
				}
				res = Math.max(dp[i][j], res);
			}
		}

		return res;
	}

}
