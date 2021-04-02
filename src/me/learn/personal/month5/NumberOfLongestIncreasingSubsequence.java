/**
 * 
 */
package me.learn.personal.month5;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Title 673 :
 * 
 * Date : Dec 22, 2020
 * 
 * @author bramanarayan
 *
 */
public class NumberOfLongestIncreasingSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		NumberOfLongestIncreasingSubsequence solution = new NumberOfLongestIncreasingSubsequence();
		System.out.println(solution.findNumberOfLIS(new int[] { 1, 3, 5, 4, 7 }));
	}

	public int findNumberOfLIS(int[] a) {
		int N = a.length;
		if (N <= 1)
			return N;
		int[] dp = new int[N]; // lengths[i] = length of longest ending in nums[i]
		int[] counts = new int[N]; // count[i] = number of longest ending in nums[i]
		Arrays.fill(counts, 1);

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < i; ++j)
				if (a[i] > a[j]) {
					
					// add counts[j] cause they lead to multiple solutions. (a,b)-----> c, you can reach to c from a or b
 					if (dp[j] + 1 == dp[i]) {
						counts[i] += counts[j];
					}
 					
 					// typical LIS
					if (dp[i] < dp[j] + 1) {
						dp[i] = dp[j] + 1;
						counts[i] = counts[j];
					} 
					
					
				}
		}

		System.out.println(Arrays.toString(dp));
		System.out.println(Arrays.toString(counts));
		
		// Find the longest increasing subsequence 'x'
		int longest = 0, ans = 0;
		for (int length : dp) {
			longest = Math.max(longest, length);
		}
		
		// Now, Count how many x's do we have ?
		for (int i = 0; i < N; ++i) {
			if (dp[i] == longest) {
				ans += counts[i];
			}
		}
		return ans;
	}
}
