package me.learn.personal.month1;

import java.util.Arrays;

/**
 * 
 * Title 88 : Given two sorted integer arrays nums1 and nums2, merge nums2 into
 * nums1 as one sorted array.
 * 
 * Note:
 * 
 * The number of elements initialized in nums1 and nums2 are m and n
 * respectively. You may assume that nums1 has enough space (size that is
 * greater or equal to m + n) to hold additional elements from nums2.
 * 
 * 
 * @author bramanarayan
 * @date May 18, 2020
 */
public class MergeSortedArray {

	public static void main(String args[]) {
		MergeSortedArray solution = new MergeSortedArray();
		//solution.merge(new int[] { 1, 2, 3, 0, 0, 0 }, 3, new int[] { 2, 5, 6 }, 3);
		solution.merge(new int[] { 0 }, 0, new int[] { 1 }, 1);

	}

	public void merge(int[] nums1, int m, int[] nums2, int n) {

		if (n == 0)
			return;

		int k = nums1.length - 1;
		int i = m - 1, j = n - 1;
		while (i >= 0 && j >= 0) {
			if (nums1[i] < nums2[j]) {
				nums1[k] = nums2[j];
				j--;
			} else {
				nums1[k] = nums1[i];
				i--;
			}
			k--;
		}

		while (i >= 0) {
			nums1[k--] = nums1[i];
			i--;
		}

		while (j >= 0) {
			nums1[k--] = nums2[j];
			j--;
		}
		System.out.println(Arrays.toString(nums1));

	}

}
