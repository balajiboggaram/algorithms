/**
 * 
 */
package me.learn.personal.month2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Title 119 :
 * 
 * Given a non-negative index k where k ≤ 33, return the kth index row of the
 * Pascal's triangle. Note that the row index starts from 0.
 * 
 * Input: 3 Output: [1,3,3,1]
 * 
 * @author bramanarayan
 * @date Jun 10, 2020
 */
public class PascalTriangleTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PascalTriangleTwo solution = new PascalTriangleTwo();
		System.out.println(solution.getRow(3));

	}

	/**
	 * O(k) Extra space - Here I am using 2*k, But this can be done in 1 * k
	 */
	public List<Integer> getRow(int n) {

		int[] temp = new int[n + 1];
		int[] res = new int[n + 1];
		temp[0] = 1;
		if (n == 0)
			return new ArrayList<Integer>(Arrays.stream(temp).boxed().collect(Collectors.toList()));

		// for up to k rows
		for (int k = 1; k <= n; k++) {
			
			// for a given row, fill it
			for (int i = 0; i <= k; i++) {
				if (i == 0 || i == k) {
					res[i] = 1;
				} else {
					res[i] = temp[i - 1] + temp[i];
				}
			}
			temp = Arrays.copyOf(res, n + 1);
		}
		return new ArrayList<Integer>(Arrays.stream(res).boxed().collect(Collectors.toList()));
	}

	/**
	 * 1 * k solution
	 */
	public List<Integer> getRowEfficient(int k) {
		Integer[] arr = new Integer[k + 1];
		Arrays.fill(arr, 0);
		arr[0] = 1;

		for (int i = 1; i <= k; i++)
			// This is really cool - come from back side
			for (int j = i; j > 0; j--)
				arr[j] = arr[j] + arr[j - 1];

		return Arrays.asList(arr);
	}
}
