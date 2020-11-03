/**
 * 
 */
package me.learn.personal.month4;

import java.util.Arrays;
import java.util.Stack;

/**
 * Title 503 :
 * 
 * Given a circular array (the next element of the last element is the first
 * element of the array), print the Next Greater Number for every element. The
 * Next Greater Number of a number x is the first greater number to its
 * traversing-order next in the array, which means you could search circularly
 * to find its next greater number. If it doesn't exist, output -1 for this
 * number.
 * 
 * Example 1:
 * 
 * Input: [1,2,1] Output: [2,-1,2] Explanation: The first 1's next greater
 * number is 2; The number 2 can't find next greater number; The second 1's next
 * greater number needs to search circularly, which is also 2.
 * 
 * 
 * @author bramanarayan
 * @date Jul 22, 2020
 */
public class NextGreaterElementTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NextGreaterElementTwo solution = new NextGreaterElementTwo();
		System.out.println(Arrays.toString(solution.nextGreaterElements(new int[] { 3, 8, 4, 1, 2 })));
	}

	// Circular - 2*n
	public int[] nextGreaterElements(int[] nums) {
		int n = nums.length;
		Stack<Integer> st = new Stack<Integer>();

		int[] res = new int[n];
		Arrays.fill(res, -1);
		st.push(0); // always push the index

		for (int i = 1; i < 2 * nums.length; i++) {

			int circIndex = i % n; // because of circular - aka two pass, so traverse twice

			while (!st.isEmpty() && nums[st.peek()] < nums[circIndex]) {
				int index = st.pop();
				res[index] = nums[circIndex];
			}
			if (circIndex < n)
				st.push(circIndex);
		}

		return res;
	}

}
