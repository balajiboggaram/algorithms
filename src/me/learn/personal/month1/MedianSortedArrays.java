package me.learn.personal.month1;

/**
 * 
 * Title 4 : There are two sorted arrays nums1 and nums2 of size m and n
 * respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * @author bramanarayan
 * @date May 17, 2020
 */
public class MedianSortedArrays {

	public static void main(String args[]) {
		MedianSortedArrays solution = new MedianSortedArrays();
		System.out.println(
				solution.findMedianSortedArrays(new int[] { 3, 10, 11, 17 }, new int[] { 9, 13, 20, 21, 23, 27 }));
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;

		int minIndex = 0;
		int maxIndex = m; // shortest length of given arrays

		if (m > n) {
			return findMedianSortedArrays(nums2, nums1);
		}

		int i = 0, j = 0;
		int median = 0;
		double maxOfLeft = 0, minOfRight = 0;
		// a1< b2 and b1 < a2
		while (minIndex <= maxIndex) {

			i = (minIndex + maxIndex) / 2;
			j = ((n + m + 1) / 2) - i;

			// if a1 > b2
			if (i > 0 && i < m && nums1[i - 1] > nums2[j]) {
				maxIndex = i - 1;
			} else if (j > 0 && i < m && nums2[j - 1] > nums1[i]) {
				minIndex = i + 1;
			} else {
				// the desired partition is met here :)
				break; // lets break to compute odd and even solution
			}

		}

		// if there are no more elements in firsthalf from a. so return last element in
		// from B's first half.
		if (i == 0) {
			maxOfLeft = nums2[j - 1]; // a's first half is empty
		} else if (j == 0) {
			maxOfLeft = nums1[i - 1]; // b's first half is empty
		} else {
			maxOfLeft = Math.max(nums1[i - 1], nums2[j - 1]);
		}
		
		// odd case solution - I care only about a1 and b1. so lets return right here.
		if ((n + m) % 2 == 1)
			return (double) maxOfLeft;

		// For even case solution, I need a2 and b2, so lets compute
		if (i == m) {
			minOfRight = nums2[j];
		} else if (j == n) {
			minOfRight = nums1[i];
		} else {
			minOfRight = Math.min(nums1[i], nums2[j]);
		}

		// even case solution -
		return (maxOfLeft + minOfRight) / 2.0;

	}
}
