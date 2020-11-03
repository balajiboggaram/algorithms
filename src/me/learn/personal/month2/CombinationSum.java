package me.learn.personal.month2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Title 39 : Given a set of candidate numbers (candidates) (without duplicates)
 * and a target number (target), find all unique combinations in candidates
 * where the candidate numbers sums to target.
 * 
 * The same repeated number may be chosen from candidates unlimited number of
 * times.
 * 
 * Note:
 * 
 * All numbers (including target) will be positive integers. The solution set
 * must not contain duplicate combinations.
 * 
 * 
 * @author bramanarayan
 * @date May 21, 2020
 */
public class CombinationSum {


	public static void main(String args[]) {
		CombinationSum solution = new CombinationSum();
		System.out.println(solution.combinationSum(new int[] { 2, 3, 6, 7 }, 7));
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {

		/**
		 * Sort the candidates here
		 */
		Arrays.sort(candidates);

		List<List<Integer>> result = new ArrayList<List<Integer>>();		
		findNumbers(result, candidates, target, new ArrayList<Integer>(), target, 0);
		System.out.println(result);

		return result;
	}

	/**
	 * Keep decrementing the sum until its 0.
	 */
	public void findNumbers(List<List<Integer>> result, int[] a, int target, List<Integer> res, int sum, int i) {
		if (sum < 0)
			return;
		if (sum == 0) {
			System.out.println(res);
			result.add(new ArrayList<>(res));
			return;
		}

		while (i < a.length && sum - a[i] >= 0) {
			System.out.println(sum + " i value " + i);
			res.add(a[i]);
			findNumbers(result, a, target, res, sum - a[i], i);
			i++;
			res.remove(res.size() - 1);
		}

	}
}
