package me.learn.personal.monthlychallenge;

import java.util.Arrays;

import me.learn.utli.Utils;

/**
 * 
 * Title : Given an array nums, write a function to move all 0's to the end of
 * it while maintaining the relative order of the non-zero elements.
 * 
 * @author bramanarayan
 * @date Apr 29, 2020
 */
public class MoveZeroes {

	public static void main(String args[]) {
		MoveZeroes solution = new MoveZeroes();
		solution.moveZeroes(new int[] { 0, 1, 0, 3, 12 });
	}

	/**
	 * With order preserve - inplace
	 */
	public void moveZeroes(int[] nums) {
		int i = 0, j = 0;
		while (i < nums.length) {
			if (nums[i] != 0) {
				Utils.swap(nums, j, i);
				i++;
				j++;
			} else {
				i++;
			}
		}
		System.out.println(Arrays.toString(nums));
	}

	/**
	 * Without order preserve - Iterate from first
	 */
	public void moveZeroesNoOrder(int[] nums) {

		int i = 0, j = nums.length - 1;
		while (i <= j) {
			if (nums[i] == 0) {
				Utils.swap(nums, i, j);
				j--;
			} else {
				i++;
			}
		}
		System.out.println(Arrays.toString(nums));
	}

}
