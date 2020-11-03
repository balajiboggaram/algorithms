/**
 * 
 */
package me.learn.personal.month4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Title 349 :
 *  
 *  Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]


 * 
 * @author bramanarayan
 * @date Aug 2, 2020
 */
public class IntersectionOfTwoArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] intersection(int[] nums1, int[] nums2) {
		
		int m = nums1.length;
		int[] result = new int[m];
		
		Set<Integer> s = new HashSet<>();
		// Put all the elements of num1 to set
		for(int x : nums1) {
			s.add(x);
		}
		
		// iterate second and form result;
		int k = 0;
		Set<Integer> processed = new HashSet<>();
		for(int x : nums2) {
			if(s.contains(x) && !processed.contains(x)) {
				result[k++] = x;
				processed.add(x);
			}
		}
		
		return Arrays.copyOf(result, k);
	}
}
