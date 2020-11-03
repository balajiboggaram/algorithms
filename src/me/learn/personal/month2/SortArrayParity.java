/**
 * 
 */
package me.learn.personal.month2;

import java.util.Arrays;

/**
 * Title 905 : 
 * 
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.

Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

 * 
 * @author bramanarayan
 * @date Jun 10, 2020
 */
public class SortArrayParity {

	public static void main(String[] args) {
		SortArrayParity solution = new SortArrayParity();
		System.out.println(Arrays.toString(solution.sortArrayByParity(new int [] {3,1,2,4})));
	}

	// In place swap
	public int[] sortArrayByParity(int[] a) {
		int i = 0;
		int j = a.length - 1;
		while (i < j) {
			if (a[i] % 2 != 0) {
				// its odd, so swap
				a[i] += (a[j] - (a[j] = a[i]));
				j--;
			} else {
				i++;
			}
		}
		return a;
	}

}
