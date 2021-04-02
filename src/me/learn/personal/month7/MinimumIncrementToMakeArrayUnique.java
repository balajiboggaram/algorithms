/**
 * 
 */
package me.learn.personal.month7;

import java.util.Arrays;

/**
 * Title 945 :
 * 
 * Date : Feb 26, 2021
 * 
 * @author bramanarayan
 *
 */
public class MinimumIncrementToMakeArrayUnique {

	/*
	 * Logic:

    First sort the array.
    Get the (diff - between the adjacent elements) and add (diff+1) to the current element.
    Add the same diff to the count variable.

	 */
	public int minIncrementForUnique(int[] A) {

		Arrays.sort(A);
		int count = 0;
		for (int i = 1; i < A.length; i++) {

			if (A[i] <= A[i - 1]) {
				int diff = A[i - 1] - A[i] + 1;
				A[i] = A[i] + diff;
				count += diff;
			}

		}

		return count;
	}

}
