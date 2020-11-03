/**
 * 
 */
package me.learn.personal.month2;

import java.util.HashSet;

/**
 * Title 1346 : 
 * 
 * Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).

More formally check if there exists two indices i and j such that :

    i != j
    0 <= i, j < arr.length
    arr[i] == 2 * arr[j]
Example 1:

Input: arr = [10,2,5,3]
Output: true
Explanation: N = 10 is the double of M = 5,that is, 10 = 2 * 5.

 *  
 * 
 * @author bramanarayan
 * @date Jun 10, 2020
 */
public class CheckIfNDoubleExists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CheckIfNDoubleExists solution = new CheckIfNDoubleExists();
		System.out.println(solution.checkIfExist(new int[] { 10, 2, 5, 3 }));
		System.out.println(solution.checkIfExist(new int[] { 7, 1, 14, 11 }));

		System.out.println(solution.checkIfExist(new int[] { -2, 0, 10, -19, 4, 6, -8 }));
		System.out.println(solution.checkIfExist(new int[] { 0, 0 }));

	}

	public boolean checkIfExist(int[] arr) {

		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {

			// (arr[i] % 2 == 0 && set.contains(arr[i] / 2) 
			// ^ handles zero in the array
			if (set.contains(2 * arr[i]) || (arr[i] % 2 == 0 && set.contains(arr[i] / 2)))
				return true;
			set.add(arr[i]);

		}
		return false;
	}

}
