package me.learn.personal.month2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import me.learn.utli.Utils;

/**
 * 
 * Title 46 : Given a collection of distinct integers, return all possible
 * permutations.
 * 
 * Nice post :  https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
 * 
 * @author bramanarayan
 * @date May 21, 2020
 */
public class PermutationArray {

	public static void main(String args[]) {
		PermutationArray solution = new PermutationArray();
		System.out.println(solution.permute(new int[] { 1, 2, 3 }));
	}

	public List<List<Integer>> permute(int[] nums) {

		int n = nums.length;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		permuteUtil(result, nums, n, 0);
		return result;
	}

	private void permuteUtil(List<List<Integer>> result, int[] a, int n, int i) {

		if (i == n) {
			result.add(new ArrayList<Integer>(Arrays.stream(a).boxed().collect(Collectors.toList())));
		} else {
			for (int j = i; j < n; j++) {
				Utils.swap(a, i, j);
				permuteUtil(result, a, n, i + 1);
				Utils.swap(a, i, j);
			}
		}

	}
	
	

}
