/**
 * 
 */
package me.learn.personal.month5;

import java.util.Arrays;

/**
 * Title 300 :
 * 
 * Date : Dec 22, 2020
 * 
 * @author bramanarayan
 *
 */
public class LongestIncreasingSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();
		solution.lengthOfLIS(new int[] {10,9,2,5,3,7,101,18});
	}

	public int lengthOfLIS(int[] a) {
		int N = a.length;
		if (N <= 1)
			return N;
		int[] dp = new int[N]; // lengths[i] = length of longest ending in nums[i]
		Arrays.fill(dp, 1);

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < i; ++j)
				if (a[i] > a[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
		}

		System.out.println(Arrays.toString(dp));

		// Find the longest increasing subsequence 'x'
		int longest = 0;
		for (int length : dp) {
			longest = Math.max(longest, length);
		}
		System.out.println(longest);
		return longest;
	}

}
