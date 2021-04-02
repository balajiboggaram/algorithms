/**
 * 
 */
package me.learn.personal.month7;

import java.util.Arrays;

/**
 * Title 354 :
 * 
 * Date : Feb 26, 2021
 * 
 * @author bramanarayan
 *
 */
public class MaximumEnvelopesRussianDoll {

	// Sort based on the area
	//
	public int maxEnvelopes(int[][] envelopes) {
		
		if (envelopes == null)
			return 0;
		
		if (envelopes.length <= 1)
			return envelopes.length;
		
		int max = 1, n = envelopes.length;
		
		// sort envelopes based on area (descending order)
		Arrays.sort(envelopes, (x, y) -> Integer.compare(y[0] * y[1], x[0] * x[1])); // sort by area
		
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			dp[i] = 1;
			int[] inner = envelopes[i];
			for (int j = 0; j < i; j++) {
				int[] outer = envelopes[j];
				if (outer[0] > inner[0] && outer[1] > inner[1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}

}
