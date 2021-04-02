/**
 * 
 */
package me.learn.personal.month7;

import java.util.Arrays;

/**
 * Title 1626 :
 * 
 * Date : Feb 26, 2021
 * 
 * @author bramanarayan
 *
 */
public class BestScoreBasketBallTeam {
	
	
	// sort on descending order - based on ages
	// then sort on the score descending order
	// now perform LIS 
	// for a dp[i] is the best score for ith player
	// i.e dp[i] = max score of all others from 0 to i-1 [dp [0] to dp [i-1]]
	
	public int bestTeamScore(int[] scores, int[] ages) {
		int n = ages.length;
		
		// Tranform the input
		int[][] candidate = new int[n][2];
		for (int i = 0; i < n; i++) {
			candidate[i][0] = ages[i];
			candidate[i][1] = scores[i];
		}
	
		// sort
		Arrays.sort(candidate, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
		
		// DP runner same as LIS
		int[] dp = new int[n];
		dp[0] = candidate[0][1];
		int max = dp[0];
		for (int i = 1; i < n; i++) {
			dp[i] = candidate[i][1];
			for (int j = 0; j < i; j++) {
				if (candidate[j][1] <= candidate[i][1]) {
					dp[i] = Math.max(dp[i], candidate[i][1] + dp[j]);
				}
			}
			max = Math.max(dp[i], max);
		}
		return max;
	}

}
