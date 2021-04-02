package me.learn.personal.month5;

/**
 * 
 * Title 1335 : amazon favorite question
 * 
 * Date : Dec 23, 2020
 * 
 * @author bramanarayan
 *
 */
public class MinimumDifficultyJobSchedule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minDifficulty(int[] jobDifficulty, int d) {

		int n = jobDifficulty.length;
		if (n < d)
			return -1;
		int[][] dp = new int[d][n];

		
		dp[0][0] = jobDifficulty[0];
		
		// first row
		// we have only one day, then the max difficulty would the highest difficulty task
		for (int i = 1; i < n; i++) {
			dp[0][i] = Math.max(jobDifficulty[i], dp[0][i - 1]);
		}

		//dp[i][j] holds the minimum difficulty with jobDifficulty[i:] which are done in d days
		// only right diagonal upper		
		for (int i = 1; i < d; i++) {
			for (int j = i; j < n; j++) {
				int localMax = jobDifficulty[j];
				dp[i][j] = Integer.MAX_VALUE;
				for (int r = j; r >= i; r--) {
					localMax = Math.max(localMax, jobDifficulty[r]);
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][r - 1] + localMax);
				}
			}
		}

		return dp[d - 1][n - 1];
	}

}
