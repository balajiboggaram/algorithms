/**
 * 
 */
package me.learn.personal.month3;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Title 414 : 
 * 
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:

Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.

 * 
 * @author bramanarayan
 * @date Jun 24, 2020
 */
public class ThirdMaximumNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThirdMaximumNumber solution = new ThirdMaximumNumber();
		System.out.println(solution.thirdMax(new int[] {3,2,1}));
		System.out.println(solution.thirdMax(new int[] {2,2,3,1}));

	}
	
	
	// Keep a set to track the top 3 elements.
	public int thirdMax(int[] a) {
		Set<Integer> s = new HashSet<Integer>();
		for (int i = 0; i < a.length; i++) {

			s.add(a[i]);
			if (s.size() > 3) {
				s.remove(Collections.min(s));// remove the minimum
			}
		}

		return s.size() == 3 ? Collections.min(s) : Collections.max(s);

	}
	
	
	// Without duplicates - just three integers
	public int thirdMaxMy(int[] a) {

		// Init all to negative infinity
		int first = Integer.MIN_VALUE;
		int second = first;
		int third = second;

		for (int i = 0; i < a.length; i++) {
			if(a[i] > third) {
				third = a[i];
			}
			
			if(third > second) {
				int t = third;
				third = second ;
				second = t;
				
			}
			
			if( second > first) {
				int t = second;
				second= first;
				first = t;
			}
		}
		
		return third;

	}
}
