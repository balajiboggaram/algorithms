/**
 * 
 */
package me.learn.personal.month1;

import java.util.HashMap;
import java.util.Map;

/**
 * Title 523 :
 * 
 * Given a list of non-negative numbers and a target integer k, write a function
 * to check if the array has a continuous subarray of size at least 2 that sums
 * up to a multiple of k, that is, sums up to n*k where n is also an integer.
 * 
 * Example 1:
 * 
 * Input: [23, 2, 4, 6, 7], k=6 Output: True Explanation: Because [2, 4] is a
 * continuous subarray of size 2 and sums up to 6.
 * 
 * 
 * @author bramanarayan
 * @date Jun 11, 2020
 */
public class ContinuousSubArraySum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ContinuousSubArraySum solution = new ContinuousSubArraySum();
		System.out.println(solution.checkSubarraySum(new int[] {23,2,4,6,7}, 6));
		System.out.println(solution.checkSubarraySum(new int[] {23,2,6,4,7}, 0));
		System.out.println(solution.checkSubarraySum(new int[] {0,0}, 0));

	}

	public boolean checkSubarraySum(int[] a, int k) {

		int n = a.length;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		map.put(0, -1); // to handle the 0,0 case

		int curSum = 0;
		for (int i = 0; i < n; i++) {
			curSum += a[i];

			// we just care about the mod only, i.e sum values that lead to less than k.
			// Inturn In other words, this indicates the multiples of k
			if (k != 0)
				curSum = curSum % k;

			// If the same mod value appears in map, then there is a sub array
			// that is a multiple of k. Check the length is greater 1 as given in problem
			if (map.containsKey(curSum)) {
				if (i - map.get(curSum) > 1)
					return true;
			} else {
				map.put(curSum, i);

			}
		}
		return false;
	}

}
