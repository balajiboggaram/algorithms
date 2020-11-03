/**
 * 
 */
package me.learn.personal.month3;

import java.util.Arrays;

/**
 * Title 72 : 
 * 
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

    Insert a character
    Delete a character
    Replace a character

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')

Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')


 * 
 * @author bramanarayan
 * @date Jun 30, 2020
 */
public class EditDistance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EditDistance solution = new EditDistance();
		System.out.println(solution.minDistance("horse", "ros"));
	}

	
	// DYNAMIC PROGRAMMING
	public int minDistance(String s, String t) {
		
		if(s == null) return t.length();
		if(t == null) return s.length();
		
		int m = s.length();
		int n = t.length();
		
		if(m == 0) return n;
		if(n == 0) return m;
		
		int[][] dp  = new int[m+1][n+1];
		
		
		// DP - init
		dp[0][0] = 0;
		for(int i = 0;i< m;i++) {
			dp[i][0] = i; // On second string being null, you need to remove all j chars
		}
		for(int j=0;j<n;j++) {
			dp[0][j] = j; // Similarly, if the first string is null here
		}
	
		// DP - Runner
		for(int i =1;i<=m;i++) {
			for(int j = 1; j<=n;j++) {
				
				// If both the char match 
				if(s.charAt(i-1) == t.charAt(j-1)) { 
					dp[i][j] = dp[i-1][j-1];
				} else {
					// the character do not match here
					// Imagine two string and try to apply the DP on n-1 character
					dp[i][j] = Math.min(dp[i-1][j], //  delete the character from string s
										Math.min(dp[i][j-1],  // insert the character from string s 
												dp[i-1][j-1])) + 1; // replace the character here
					
				}
			}
		}
		return dp[m][n];
		
	}

}
