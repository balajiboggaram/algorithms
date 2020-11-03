package me.learn.personal.month2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Title 47 : Given a collection of numbers that might contain duplicates,
 * return all possible unique permutations.
 * 
 * @author bramanarayan
 * @date May 21, 2020
 */
public class PermutationUniqueArray {

	public static void main(String args[]) {
		PermutationUniqueArray solution = new PermutationUniqueArray();
		System.out.println(solution.permuteUnique(new int[] { 1, 1, 2 }));
	}

	/**
	 * Use an extra boolean array " boolean[] used" to indicate whether the value is
	 * added to list.
	 * 
	 * Sort the array "int[] nums" to make sure we can skip the same value.
	 * 
	 * when a number has the same value with its previous, we can use this number
	 * only if his previous is used
	 */
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0)
			return res;
		boolean[] used = new boolean[nums.length];
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(nums);
		dfs(nums, used, list, res);
		return res;
	}

	public void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res) {
		if (list.size() == nums.length) {
			res.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			// If this element is used, then continue
			if (used[i])
				continue;
			// If the previous element is same and not used, then I cannot use ith element, So continue...
			if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1])
				continue;
			
			
			used[i] = true;
			list.add(nums[i]);
			dfs(nums, used, list, res);
			used[i] = false;
			list.remove(list.size() - 1);
		}
	}
}
