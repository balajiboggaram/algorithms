/**
 * 
 */
package me.learn.personal.month5;

import java.util.Arrays;

/**
 * Title 674 :
 * 
 * Date : Dec 22, 2020
 * 
 * @author bramanarayan
 *
 */
public class LongestContinousIncreasingSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		LongestContinousIncreasingSubsequence solution = new LongestContinousIncreasingSubsequence();
		solution.findLengthOfLCIS(new int[] { 1, 3, 5, 4, 7 });
		solution.findLengthOfLCIS(new int[] { 1, 3, 5, 7 });

	}

	// pure sliding window
	public int findLengthOfLCIS(int[] a) {

		if (a.length == 0)
			return 0;
		int result = 1;
		int i = 0, j = 0;
		while (j < a.length) {
			while (j < a.length - 1 && a[j] < a[j + 1]) {
				j++;
			}
			result = Math.max(result, j - i + 1);
			j++;
			i = j;

		}
		return result;
	}

}
