package me.learn.personal.month2;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Title 217 : Given an array of integers, find if the array contains any
 * duplicates.
 * 
 * Your function should return true if any value appears at least twice in the
 * array, and it should return false if every element is distinct.
 * 
 * @author bramanarayan
 * @date May 24, 2020
 */
public class ContainsDuplicate {

	public static void main(String args[]) {

	}

	public boolean containsDuplicate(int[] nums) {
		int n = nums.length;
		Set<Integer> visited = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			if (visited.contains(nums[i]))
				return true;
			visited.add(nums[i]);
		}
		return false;
	}
}
