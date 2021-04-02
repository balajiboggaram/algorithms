/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 961 :
 * 
 * Date : Dec 30, 2020
 * 
 * @author bramanarayan
 *
 */
public class NRepeatedElement2N {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// THere is one element which is repeated for N+1 times in a given 2 * N array.

	// you can easily solve this using map by keeping count.
	// the trick here is to solve in O(1). the element majority will be same as n-1
	// and n-2 on match
	public int repeatedNTimes(int[] a) {
		for (int i = 2; i < a.length; i++) {
			if (a[i] == a[i - 1] || a[i] == a[i - 2])
				return a[i];

		}

		return a[0]; // since the majority always exist from given problem.

	}
}
