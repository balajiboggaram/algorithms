/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title :
 * 
 * Date : Dec 23, 2020
 * 
 * @author bramanarayan
 *
 */
public class MaximalSquareBinary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maximalSquare(char[][] a) {

		
		int m = a.length;
		if(m ==  0 ) return 0;
		int n = a[0].length;
		
		int[][] dp = new int[m+1][n+1];
		int result = 0;
		for(int i = 1;i<=m;i++) {
			for(int j = 1;j<=n;j++) {
				if(a[i-1][j-1] == '1') {
					dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;				
				}
				result = Math.max(result, dp[i][j]);
			}
		}
		return result * result;
	}

}
