package me.learn.personal.month2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTrackingGuide {

	/**
	 * Find all the subsets without duplicates
	 */
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtracksubsets(list, new ArrayList<>(), nums, 0);
		return list;
	}

	private void backtracksubsets(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
		list.add(new ArrayList<>(tempList));
		// This for loop is need as you need to start the recursion at every element.
		// why ? lets say we have (2,3,6,7) as input. then .
		// we need
		// start at nothing : ()
		// start at 2 : (2) (2,3) (2,3,6) (2,3,6,7)
		// start at 3 : (3) (3,6) (3,6,7)
		// start at 6: (6) (6,7)
		// start at 7 : (7)
		for (int i = start; i < nums.length; i++) {
			tempList.add(nums[i]);
			backtracksubsets(list, tempList, nums, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}

	/**
	 * Find all the subsets with DUPLICATES
	 */
	public List<List<Integer>> subsetsDups(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtracksubsetsDups(list, new ArrayList<>(), nums, 0);
		return list;
	}

	private void backtracksubsetsDups(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
		list.add(new ArrayList<>(tempList));
		for (int i = start; i < nums.length; i++) {
			// handle the duplicates, I dont care if I see the same element next time
			if (i > start && nums[i] == nums[i - 1])
				continue;
			tempList.add(nums[i]);
			backtracksubsetsDups(list, tempList, nums, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}

	
	/**
	 * Permutation
	 */
	public List<List<Integer>> permute(int[] nums) {
		   List<List<Integer>> list = new ArrayList<>();
		   // Arrays.sort(nums); // not necessary
		   backtrackPermute(list, new ArrayList<>(), nums);
		   return list;
		}

		private void backtrackPermute(List<List<Integer>> list, List<Integer> tempList, int [] nums){
		   if(tempList.size() == nums.length){
		      list.add(new ArrayList<>(tempList));
		   } else{
		      for(int i = 0; i < nums.length; i++){ 
		         if(tempList.contains(nums[i])) continue; // element already exists, skip
		         tempList.add(nums[i]);
		         backtrackPermute(list, tempList, nums);
		         tempList.remove(tempList.size() - 1);
		      }
		   }
		} 
	
}
