/**
 * 
 */
package me.learn.personal.month5;

import java.util.HashMap;
import java.util.Map;

/**
 * Title 494 :
 * 
 * Date : Jan 8, 2021
 * 
 * @author bramanarayan
 *
 */
public class TargetSumPlusMinus {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TargetSumPlusMinus solution = new TargetSumPlusMinus();
		System.out.println(solution.findTargetSumWaysBEST(new int[] { 1, 1, 1, 1, 1 }, 3));
	}

	// TC : O(2 power n)
	int result = 0;

	public int findTargetSumWays(int[] nums, int S) {
		calculate(nums, 0, 0, S);
		return result;
	}

	// if you have seen this sum already, then track it somewhere so that you do not recompute again and again
	public void calculate(int[] nums, int i, int sum, int S) {
		if (i == nums.length) {
			if (sum == S)
				result++;
		} else {
			calculate(nums, i + 1, sum + nums[i], S);
			calculate(nums, i + 1, sum - nums[i], S);
		}
	}

	// TC : better

	private static Map<String, Integer> memo; // key: serialized curIndex and targetSum, value: its corresponding number
												// of ways

	public int findTargetSumWaysBEST(int[] nums, int S) {
		memo = new HashMap<>();
		return findTargetSumWaysRecur(nums, S, 0, S);
	}

	private static int findTargetSumWaysRecur(int[] nums, int targetSum, int curIndex, int cursum) {

		String curSerial = serialize(curIndex, cursum);
		if (memo.containsKey(curSerial)) {
			return memo.get(curSerial);
		}

		if (curIndex == nums.length) {
			if (cursum == 0) {
				return 1;
			}
			return 0;
		}

		int numWaysIfMinus = findTargetSumWaysRecur(nums, targetSum, curIndex + 1, cursum + nums[curIndex]); // -nums[curIndex]
		int numWaysIfAdd = findTargetSumWaysRecur(nums, targetSum, curIndex + 1, cursum - nums[curIndex]); // +nums[curIndex]

		int numWays = numWaysIfMinus + numWaysIfAdd;
		memo.put(curSerial, numWays);
		return numWays;
	}

	private static String serialize(int curIndex, int targetSum) {
		return curIndex + "," + targetSum;
	}

}
