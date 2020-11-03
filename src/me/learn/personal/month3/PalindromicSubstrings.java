/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title 647 :
 * 
 *  Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:

Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".

Example 2:

Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

 * 
 * @author bramanarayan
 * @date Jun 26, 2020
 */
public class PalindromicSubstrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PalindromicSubstrings solution = new PalindromicSubstrings();
		System.out.println(solution.countSubstrings("abc"));
	}

	public int countSubstrings(String s) {
	    int n = s.length();
	    int res = 0;
	    boolean[][] dp = new boolean[n][n];
	    for (int i = n - 1; i >= 0; i--) {
	        for (int j = i; j < n; j++) {
	            dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i  + 1 < 3 || dp[i + 1][j - 1]);
	            if(dp[i][j]) ++res;
	        }
	    }
	    return res;
	}
	
	
	
	/*
	 * if i+1,j-1 is a palindrome, then if i ==j then its also a palindrome. 
	 * 
	 * IN this spl Dynamic programming the catch here is - 
	 * 
	 * you would have already solved i+1,j and i,j-1. so if i==j character 
	 * then the answer would be : 
	 * dp[i][j] = (i+1,j) + (i,j-1) + 1 (i,j on match ) - (i+1,j-1) remove the common
	 */
	public int countSubstringsMy(String s) {
		int n = s.length();
		int[][] dp = new int[n][n];
		boolean[][] pal = new boolean[n][n];

		// 1 length - fill it
		for (int i = 0; i < n; i++) {
			dp[i][i] = 1;
			pal[i][i] = true;
		}

		// 2 length - fill it
		for (int i = 1; i < n; i++) {
			if (s.charAt(i) == s.charAt(i - 1)) {
				dp[i][i - 1] = 2;
				pal[i][i - 1] = true;
			}
		}

		// > 3 length - fill it now.
		for (int k = 2; k < n; k++) { // 3, 4, 5 length....

			for (int i = 0; i < n - k; i++) { // pick a window of k each time.

				int j = i + k; // the last index in the fixed window of k.
				
				// i ==j and and i+1,j-1 is already a palindrome. Viola - you hit the jackpot
				if(s.charAt(i) == s.charAt(j) && pal[i+1][j-1]) {
					pal[i][j] = true;
				}
				
				if(pal[i][j]) {
					dp[i][j] = dp[i+1][j] + dp[i][j-1] + 1 - dp[i+1][j-1];
				} else {
					dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1];
				}
				
			}
		}
		
		return dp[0][n-1];
	}

}
