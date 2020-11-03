/**
 * 
 */
package me.learn.personal.month3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Title 300 :
 * 
 * Given an unsorted array of integers, find the length of longest increasing
 * subsequence.
 * 
 * Example:
 * 
 * Input: [10,9,2,5,3,7,101,18] Output: 4 Explanation: The longest increasing
 * subsequence is [2,3,7,101], therefore the length is 4.
 * 
 * @author bramanarayan
 * @date Jul 6, 2020
 */
public class LongestIncreasingSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();
		solution.printLIS(new int[] { 1, 3, 6, 7, 9, 4, 10, 5, 6 });

		System.out.println(solution.lengthOfLIS(new int[] { 1, 3, 6, 7, 9, 4, 10, 5, 6 }));
		System.out.println(solution.lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));

	}

	// DYNAMIC PROGRAMMING
	public int lengthOfLIS(int[] a) {

		int n = a.length;

		if (n == 0)
			return 0;
		if (n == 1)
			return 1;

		// DP init
		int[] dp = new int[n];
		Arrays.fill(dp, 1);

		// DP - Runner
		int result = 1; // you need to track the max longest as the dp[n-1] may not always give you the
						// max answer.
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i] > a[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					result = Math.max(result, dp[i]);
				}
			}
		}

		return result;
	}

	// DYNAMIC PROGRAMMING - fix it
	public void printLIS(int[] a) {

		int n = a.length;

		if (n == 0)
			return;
		if (n == 1)
			return;

		// DP init
		int[] dp = new int[n];
		Arrays.fill(dp, 1);

		// DP - Runner
		int[] s = new int[n];
		int endIndex = 0;
		int result = 1; // you need to track the max longest as the dp[n-1] may not always give you the
						// max answer.
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i] > a[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
					s[i] = j;
					endIndex = i;
					result = Math.max(result, dp[i]);
				}
			}
		}

		int count = 0;
		List<Integer> l = new ArrayList<Integer>();
		while (endIndex >= 0 && result > count) {
			System.out.println(a[endIndex]);
			l.add(a[endIndex]);
			count++;
			endIndex = s[endIndex];
		}

	}
}
