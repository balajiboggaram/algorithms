/**
 * 
 */
package me.learn.personal.month4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Title 496 :
 * 
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s
 * elements are subset of nums2. Find all the next greater numbers for nums1's
 * elements in the corresponding places of nums2.
 * 
 * The Next Greater Number of a number x in nums1 is the first greater number to
 * its right in nums2. If it does not exist, output -1 for this number.
 * 
 * Example 1:
 * 
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2]. Output: [-1,3,-1] Explanation: For
 * number 4 in the first array, you cannot find the next greater number for it
 * in the second array, so output -1. For number 1 in the first array, the next
 * greater number for it in the second array is 3. For number 2 in the first
 * array, there is no next greater number for it in the second array, so output
 * -1.
 * 
 * Example 2:
 * 
 * Input: nums1 = [2,4], nums2 = [1,2,3,4]. Output: [3,-1] Explanation: For
 * number 2 in the first array, the next greater number for it in the second
 * array is 3. For number 4 in the first array, there is no next greater number
 * for it in the second array, so output -1.
 * 
 * Note:
 * 
 * All elements in nums1 and nums2 are unique. The length of both nums1 and
 * nums2 would not exceed 1000.
 * 
 * 
 * @author bramanarayan
 * @date Jul 22, 2020
 */
public class NextGreaterElementOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NextGreaterElementOne solution = new NextGreaterElementOne();
		System.out.println(Arrays.toString(solution.nextGreaterElement(new int[] {2,1,3}, new int[] {2,3,1})));
		System.out.println(Arrays.toString(solution.nextGreaterElement(new int[] {4,1,2}, new int[] {1,3,4,2})));
	}

	// Front 0 to n-1, stack is the key
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		
		if(nums1.length == 0 && nums2.length == 0) return new int[] {};

		Stack<Integer> st = new Stack<Integer>();
		Map<Integer, Integer> nextRight = new HashMap<Integer, Integer>();

		st.push(0); // push the first item to stack

		for (int i = 1; i < nums2.length; i++) {

			if (nums2[st.peek()] > nums2[i]) {
				st.push(i);
			} else {
				while (!st.isEmpty() && nums2[st.peek()] < nums2[i]) {
					int index = st.pop();
					nextRight.put(nums2[index], nums2[i]);
				}
				st.push(i);
			}
		}

		while (!st.isEmpty()) {
			nextRight.put(nums2[st.pop()], -1);
		}

		// now iterate the map and frame the result
		int[] res = new int[nums1.length];
		for (int i = 0; i < nums1.length; i++) {
			if(nextRight.containsKey(nums1[i])) {
				res[i] = nextRight.get(nums1[i]);
			} else {
				res[i] = -1;
			}
		}
		return res;

	}

}
