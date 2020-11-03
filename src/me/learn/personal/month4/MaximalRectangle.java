/**
 * 
 */
package me.learn.personal.month4;

import java.util.Stack;

/**
 * Title 85 :
 * 
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
 * containing only 1's and return its area.
 * 
 * Example:
 * 
 * Input: [ ["1","0","1","0","0"], ["1","0","1","1","1"], ["1","1","1","1","1"],
 * ["1","0","0","1","0"] ] Output: 6
 * 
 * 
 * 
 * @author bramanarayan
 * @date Jul 26, 2020
 */
public class MaximalRectangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MaximalRectangle solution = new MaximalRectangle();
		System.out.println(solution.maximalRectangle(new char[][] { { '1', '0', '1', '0', '0' },
				{ '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } }));
		System.out.println(solution.maximalRectangle(new char[][] { { '0', '1'}, {'0', '1' } }));

	}

	// a purely based on largest rectangle histogram problem.
	// see tushar video - beautiful
	public int maximalRectangle(char[][] a) {
		int m = a.length;
		if(m == 0) return 0;
		int n = a[0].length;
		
		int[] dp = new int[n];
		int maxArea = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j]  == '0') {
					dp[j] = 0; // if its zero, then you cannot build a rectangle with this.
				} else {
					dp[j] = 1 + dp[j]; // a[i][j] will be 1 always
				}
			}
			maxArea = Math.max(maxArea, largestRectangleArea(dp));

		}

		return maxArea;

	}

	// answer from problem # 84
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
				maxArea = Math.max(maxArea, candidate * (i - st.peek() - 1));
			}
			st.push(i);

		}

		// what if the array is just an ascending array
		while (st.peek() != -1) {
			maxArea = Math.max(maxArea, a[st.pop()] * (n - st.peek() - 1));

		}
		return maxArea;
	}

}
