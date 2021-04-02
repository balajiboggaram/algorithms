/**
 * 
 */
package me.learn.personal.month5;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Title 45 :
 * 
 * Date : Dec 23, 2020
 * 
 * @author bramanarayan
 *
 */
public class JumpGameMinJumps {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		JumpGameMinJumps solution = new JumpGameMinJumps();
		System.out.println(solution.jump(new int[] { 2, 3, 1, 1, 4 }));
		System.out.println(solution.jump(new int[] { 2, 3, 0, 1, 4 }));

	}

	// minimum number of jumps to reach end of array
	public int jump(int[] a) {
		int steps = a[0];
		int count = 1;
		int n = a.length;
		int maxReach = a[0];

		if (n == 1)
			return 0;
		for (int i = 1; i < n; i++) {
			if (i > maxReach)
				return -1;
			if (i == n - 1)
				return count;

			steps--;
			if (maxReach < i + a[i]) {
				maxReach = i + a[i];
			}

			if (steps == 0) {
				count++;
				steps = maxReach - i;
			}

		}

		return count;
	}

}
