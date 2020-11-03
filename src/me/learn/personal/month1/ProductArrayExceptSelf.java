package me.learn.personal.month1;

import java.util.Arrays;

/**
 * 
 * Title 238 : Given an array nums of n integers where n > 1, return an array
 * output such that output[i] is equal to the product of all the elements of
 * nums except nums[i].
 * 
 * @author bramanarayan
 * @date May 16, 2020
 */
public class ProductArrayExceptSelf {

	public static void main(String args[]) {
		ProductArrayExceptSelf solution = new ProductArrayExceptSelf();
		System.out.println(Arrays.toString(solution.productExceptSelf(new int[] { 1, 2, 3, 4 })));
		System.out.println(Arrays.toString(solution.productExceptSelf(new int[] { 1, 2, 3, 4, 5 })));
		System.out.println(Arrays.toString(solution.productExceptSelf(new int[] { 1, 2, 0, 4 })));

	}

	public int[] productExceptSelf(int[] nums) {

		if (nums.length < 2)
			return nums;
		int n = nums.length;
		int[] res = new int[n];

		// Compute left to right product
		res[0] = nums[0];
		for (int i = 1; i < n; i++) {
			res[i] = res[i - 1] * nums[i];
		}

		// Compute right to left with help of int product;
		int product = nums[n - 1];
		res[n - 1] = res[n - 2];
		for (int i = n - 2; i > 0; i--) {
			res[i] = res[i - 1] * product;
			product *= nums[i]; // product is basically the right product until that point.
		}
		res[0] = product;

		return res;
	}

}
