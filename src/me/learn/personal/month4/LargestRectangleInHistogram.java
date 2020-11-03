package me.learn.personal.month4;

import java.util.Stack;

/**
 * 
 * Title 84 :
 * 
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 * 
 * @author bramanarayan
 * @date Jul 26, 2020
 */
public class LargestRectangleInHistogram {

	public static void main(String[] args) {
		LargestRectangleInHistogram solution = new LargestRectangleInHistogram();
		System.out.println(solution.largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 }));
		System.out.println(solution.largestRectangleArea(new int[] { 0,2}));

	}

	// Divide and Conquer
	// O[n log n] - my favorite
	public int largestRectangleAreaMy(int[] a) {
		return calculate(a, 0, a.length - 1);
	}

	private int calculate(int[] a, int l, int h) {

		if (l > h)
			return 0;
		// find min between l and r
		int min = Integer.MAX_VALUE;
		int minIndex = l;
		for (int i = l; i <= h; i++) {
			if (a[i] < min) {
				min = a[i];
				minIndex = i;
			}
		}

		return Math.max(calculate(a, l, minIndex - 1), Math.max( // if left side answer found ?
				calculate(a, minIndex + 1, h), // if right side answer found ?
				a[minIndex] * (h - l + 1))); // if width wise solution found
	}

	// The other BEST answer with Stacky
	// TC : O(n)
	public int largestRectangleArea(int[] a) {

		Stack<Integer> st = new Stack<Integer>();
		st.push(-1);

		int maxArea = 0;
		int n = a.length;
		for (int i = 0; i < n; i++) {

			if (a[i] > st.peek()) {
				st.push(i);
			}

			// when a decline in array is noticed. you need to retire the max elements of
			// current element.
			while (st.peek() != -1 && a[i] <= a[st.peek()]) {
				int candidate = a[st.pop()]; // compute as if this is longest tower and compute breadth from cur index i
				maxArea = Math.max(maxArea, candidate * (i - st.peek()-1));
			}
			st.push(i);

		}
		
		// what if the array is just an ascending array
		while(st.peek() != -1) {
			maxArea = Math.max(maxArea, a[st.pop()] * (n - st.peek()-1));

		}
		return maxArea;
	}

}
