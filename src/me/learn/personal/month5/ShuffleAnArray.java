/**
 * 
 */
package me.learn.personal.month5;

import java.util.Random;

/**
 * Title 384 :
 * 
 * Date : Jan 4, 2021
 * 
 * @author bramanarayan
 *
 */
public class ShuffleAnArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	class Solution {

		int[] copy;
		int[] a;
		Random r = new Random();

		public Solution(int[] nums) {
			a = nums.clone();
			copy = nums.clone();
		}

		/** Resets the array to its original configuration and return it. */
		public int[] reset() {
			copy = a.clone();
			return copy;

		}

		/** Returns a random shuffling of the array. */
		public int[] shuffle() {
			int n = copy.length;
			for (int i = n - 1; i >= 0; i--) {
				int temp = r.nextInt(i);
				swap(copy, temp, i);
			}
			return copy;
		}

		private void swap(int[] a, int i, int j) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}

		// FYI..  generate a random number in a range
		private int randRange(int min, int max) {
			return r.nextInt(max - min) + min;
		}

	}

}
