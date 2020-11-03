/**
 * 
 */
package me.learn.personal.month2;

/**
 * Title 1064 :
 * 
 * Given an array A of distinct integers sorted in ascending order, return the
 * smallest index i that satisfies A[i] == i. Return -1 if no such i exists.
 * 
 * Example 1:
 * 
 * Input: [-10,-5,0,3,7] Output: 3 Explanation: For the given array, A[0] = -10,
 * A[1] = -5, A[2] = 0, A[3] = 3, thus the output is 3.
 * 
 * 
 * @author bramanarayan
 * @date Jun 7, 2020
 */
public class FixedPoint {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FixedPoint solution = new FixedPoint();
		//System.out.println(solution.fixedPoint(new int[] { -10, -5, 0, 3, 7 }));
		//System.out.println(solution.fixedPoint(new int[] { 0, 2, 5, 8, 17 }));
		//System.out.println(solution.fixedPoint(new int[] { -10, -5, 3, 4, 7, 9 }));
		System.out.println(solution.fixedPoint(new int[] { -10, -5, -2, 0, 4, 5, 6, 7, 8, 9, 10 }));

	}

	public int fixedPoint(int[] a) {
		int l = 0;
		int h = a.length - 1;
		int answer = -1;
		int m;
		while (l <= h) {
			m = l + ((h - l) / 2);
			if (m >= 0 && m == a[m]) {
				answer = m;
			}

			if (m > a[m]) {
				l = m + 1;
			} else {
				h = m - 1;
			}
		}
		return answer;
	}

}
