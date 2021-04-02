/**
 * 
 */
package me.learn.personal.month5;

import java.util.Arrays;

/**
 * Title 871 :
 * 
 * Date : Dec 23, 2020
 * 
 * @author bramanarayan
 *
 */
public class MinNumOfRefuelingStops {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// stations[i][0] -> miles, [i][1] -> gas fuel
	// Dynamic Programming
	// Minimum number of refuel stops to reach the target miles.
	public int minRefuelStops(int target, int startFuel, int[][] stations) {
		int n = stations.length;
		long[] dp = new long[n + 1];
		dp[0] = startFuel;

		// dp[i] -> respresent the farthest location we can get with i refuel stops

		for (int i = 0; i < n; i++) {
			for (int j = i; j >= 0; j--) {
				if (dp[j] >= stations[i][0]) { // if I could reach more than my current milestone from previous stops ?
					dp[j + 1] = Math.max(dp[j + 1], dp[j] + stations[i][1]);
				}
			}
		}

		for (int i = 0; i <= n; i++) {
			if (dp[i] >= target) {
				return i; // the first index on which I can reach the target miles will be the minimum
							// stops required.
			}
		}
		return -1;

	}

}
