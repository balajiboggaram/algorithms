/**
 * 
 */
package me.learn.personal.month6;

import java.util.Arrays;

/**
 * Title 486 :
 * 
 * Date : Jan 15, 2021
 * 
 * @author bramanarayan
 *
 */
public class PredictTheWinner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean PredictTheWinner(int[] nums) {

		int scoreFirst = predictTheWinnerFrom(nums, 0, nums.length - 1);
		int scoreTotal = Arrays.stream(nums).sum();

		// Compare final scores of two players.
		// first person score is higher than second person score (total - first)
		return scoreFirst >= scoreTotal - scoreFirst;
	}

	private int predictTheWinnerFrom(int[] nums, int i, int j) {
		if (i > j) {
			return 0;
		}
		if (i == j) {
			return nums[i];
		}

		// what is the max score , a first person can make ? Assume that second person
		// will score the minimumest possible based on first person move
		int curScore = Math.max(
				nums[i] + Math.min(predictTheWinnerFrom(nums, i + 2, j), predictTheWinnerFrom(nums, i + 1, j - 1)), // select
																													// first
																													// element
				nums[j] + Math.min(predictTheWinnerFrom(nums, i, j - 2), predictTheWinnerFrom(nums, i + 1, j - 1))); // select
																														// last
																														// element
		return curScore;
	}

// or 

	// you can also solve using memoisation
	// the only changing variable here is i to j -> you would have already solved
	// it. so track it somewhere

}
