package me.learn.personal.month1;

import java.util.Arrays;

/**
 * 
 * Title 31 : Next Permutation
 * 
 * @author bramanarayan
 * @date May 19, 2020
 */
public class NextPermutation {

	public static void main(String args[]) {
		NextPermutation solution = new NextPermutation();
		// solution.nextPermutation(new int[] {1,2,3});
		// solution.nextPermutation(new int[] {1,6,6,3,1});
		solution.nextPermutation(new int[] { 2, 3, 1 });

	}

	/**
	 * 1) An sequence sorted in descending order does not have next permutation. For
	 * example edcba” does not have next permutation.
	 * 
	 * 2) For a sequence which is not sorted in descending order for example
	 * “abedc”, we can follow below steps.
	 * 
	 * ……….a) Traverse from right and find the first item that is not following the
	 * descending order. For example in “abedc”, the character ‘b’ does not follow
	 * the descending order.
	 * 
	 * ……….b) Swap the found character with closest greater (or smallest greater)
	 * element on right side of it. In case of “abedc”, we have ‘c’ as the closest
	 * greater element. After swapping ‘b’ and ‘c’, string becomes “acedb”.
	 * 
	 * ……….c) After swapping, sort the string after the position of character found
	 * in step a. After sorting the substring “edb” of “acedb”, we get “acbde” which
	 * is the required next permutation.
	 * 
	 */
	public void nextPermutation(int[] nums) {

		int n = nums.length;
		int i = n - 2;
		boolean nextFound = false;

		// Step a : Find b
		while (i >= 0) {
			if (nums[i] >= nums[i + 1]) {
				i--;
			} else {
				nextFound = true;
				break;
			}
		}
		if (!nextFound) {
			// all elements are in decreasing order, then there will be no permutation
			Arrays.sort(nums);
			return;
		}

		// Step b : find the smallest
		int j = i + 1, smallest = j;
		while (j <= n - 1) {
			if (nums[j] > nums[i] && nums[smallest] > nums[j]) {
				smallest = j;
			}
			j++;
		}
		j--;

		int t = nums[i];
		nums[i] = nums[smallest];
		nums[smallest] = t;

		// Step c : sort the array after ith position
		Arrays.sort(nums, i + 1, n);
		System.out.println(Arrays.toString(nums));
	}

}
