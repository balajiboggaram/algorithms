package me.learn.personal.month2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Title 39 : Given a collection of candidate numbers (candidates) and a target
 * number (target), find all unique combinations in candidates where the
 * candidate numbers sums to target.
 * 
 * Each number in candidates may only be used once in the combination.
 * 
 * Note:
 * 
 * All numbers (including target) will be positive integers. The solution set
 * must not contain duplicate combinations.
 * 
 * 
 * 
 * @author bramanarayan
 * @date May 21, 2020
 */
public class CombinationSumTwo {

	public static void main(String args[]) {
		CombinationSumTwo solution = new CombinationSumTwo();
		// System.out.println(solution.combinationSum2(new int[] { 2, 3, 6, 7 }, 7));
		System.out.println(solution.combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8));

	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {

		/**
		 * Sort the candidates here
		 */
		Arrays.sort(candidates);

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		findNumbers(result, candidates, target, new ArrayList<Integer>(), target, 0);

		return result;
	}

	/**
	 * Keep decrementing the sum until its 0.
	 */
	public void findNumbers(List<List<Integer>> result, int[] a, int target, List<Integer> res, int sum, int i) {
		if (sum < 0)
			return;
		else if (sum == 0) {
			result.add(new ArrayList<>(res));
			return;
		} else {
			// start at every element and see if you can make target 
			// until end of the array
			for (int j = i; j < a.length; j++) {
				// Always include first element. i.e where you start from so j>i is needed.
				if(j > i && a[j] == a[j-1]) continue;
				res.add(a[j]);
				findNumbers(result, a, target, res, sum - a[j], j + 1); // Increment i since you can chose the element only once
				res.remove(res.size()-1);
			}
		}

	}

}
