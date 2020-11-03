package me.learn.personal.month1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Title : Given a set of distinct integers, nums, return all possible subsets
 * (the power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * 
 * 
 * @author bramanarayan
 * @date May 13, 2020
 */
public class Subsets {
	public static void main(String args[]) {
		Subsets solution = new Subsets();
		// solution.subsets(new int[] { 1, 2, 3 });
		solution.subsetsWithDup(new int[] { 4, 4, 4, 1, 4 });

	}

	/**
	 * Works for distinct
	 */
	public List<List<Integer>> subsets(int[] nums) {
		int n = nums.length;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 0; i < (1 << n); i++) {
			List<Integer> set = new ArrayList<Integer>();
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) > 0) {
					set.add(nums[j]);
				}
			}
			result.add(set);

		}
		return result;
	}

	/**
	 * Works for any duplicates
	 */
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		int n = nums.length;
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 0; i < (1 << n); i++) {
			List<Integer> set = new ArrayList<Integer>();
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) > 0) {
					set.add(nums[j]);
				}
			}
			if (!result.contains(set)) {
				result.add(set);
			}
		}
		return result;
	}

	// from LC
	public List<List<Integer>> subsetsWithDupLC(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> ret = new ArrayList<>();
		ret.add(new ArrayList<Integer>());

		int size = 0, startIndex;
		for (int i = 0; i < num.length; i++) {
			startIndex = (i >= 1 && num[i] == num[i - 1]) ? size : 0;
			size = ret.size();
			for (int j = startIndex; j < size; j++) {
				List<Integer> temp = new ArrayList<>(ret.get(j));
				temp.add(num[i]);
				ret.add(temp);
			}
		}
		return ret;
	}
}
