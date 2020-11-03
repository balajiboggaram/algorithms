/**
 * 
 */
package me.learn.personal.month2;

import java.util.Arrays;
import java.util.Stack;

/**
 * Title 1299 :
 * 
 * Given an array arr, replace every element in that array with the greatest
 * element among the elements to its right, and replace the last element with
 * -1.
 * 
 * After doing so, return the array.
 * 
 * Example 1:
 * 
 * Input: arr = [17,18,5,4,6,1]
 * 
 * Output: [18,6,6,6,1,-1]
 * 
 * 
 * @author bramanarayan
 * @date Jun 13, 2020
 */
public class ReplaceElementsWithRightGreater {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReplaceElementsWithRightGreater solution = new ReplaceElementsWithRightGreater();
		System.out.println(Arrays.toString(solution.replaceElements(new int[] {17,18,5,4,6,1})));
	}

	public int[] replaceElements(int[] a) {
		int n = a.length;

		if(n == 0) return a;
		Stack<Integer> s = new Stack<Integer>();

		s.push(a[n - 1]);
		for (int i = n - 2; i >= 0; i--) {
			if (s.peek() < a[i])
				s.push(a[i]);
		}

		for (int i = 0; i < n - 1; i++) {
			if (!s.isEmpty() && s.peek() > a[i]) {
				a[i] = s.peek();
			} else {
				s.pop();
				a[i] = s.peek();
			}
		}
		a[n - 1] = -1;
		return a;
	}

}
