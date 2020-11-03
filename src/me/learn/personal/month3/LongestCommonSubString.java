/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title : 
 * 
 * @author bramanarayan
 * @date Jul 14, 2020
 */
public class LongestCommonSubString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		LongestCommonSubString solution = new LongestCommonSubString();
		System.out.println(solution.longestCommonSubString("PresidentIndia", "India"));
		System.out.println(solution.longestCommonSubString("PresidentIndia", "President"));

	}

	// DYNAMIC PROGRAMMING
		public int longestCommonSubString(String s1, String s2) {
			int m = s1.length();
			int n = s2.length();
			
			// remember default value is 0 , no need for DP init
			int[][] dp = new int[m + 1][n + 1];


			int res = 0;
			for (int i = 1; i <= m; i++) {
				for (int j = 1; j <= n; j++) {
					
					// dp[i][j] represents longest repeated substrings where  the two substrings
					// each of them represent the string ending with ith and jth character resply. 
					// thus dp[][]
					if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
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
