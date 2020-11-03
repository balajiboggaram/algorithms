package me.learn.personal.month1;

import java.util.Arrays;

public class ThreeSumSmaller {

	public static void main(String args[]) {
		ThreeSumSmaller solution = new ThreeSumSmaller();
		System.out.println(solution.threeSumSmaller(new int[] { -2, 0, 1, 3 }, 2));
		System.out.println(solution.threeSumSmaller(new int[] { 1, 3, 4, 5, 7 }, 12));

	}

	/**
	 * Time complexity is O(n2). Similar to : 3sum - Find three numbers with target
	 * 3sum zero - Find three numbers with target zero
	 */
	public int threeSumSmaller(int[] nums, int target) {
		Arrays.sort(nums);
		if (nums.length < 3)
			return 0;
		int n = nums.length;
		int result = 0;
		for (int i = 0; i < n - 2; i++) {
			int l = i + 1;
			int h = n - 1;
			while (l < h) {
				int value = nums[i] + nums[l] + nums[h];
				if (value < target) {
					// Its h-l because we need to count all the combinations between l-->h as valid
					// combinations.
					// in example 1,3,4,5,7, if i =1,l = 3,h =7 1+3=7 < 12, so 1,3,7# 1,3,5# 1,3,4 so (h-l) makes sense
					// are all valid combinations
					result = result + (h - l);
					l++;
				} else {
					h--;
				}
			}
		}
		return result;
	}
}
