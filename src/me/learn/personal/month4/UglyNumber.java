/**
 * 
 */
package me.learn.personal.month4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Title 263 :
 * 
 * Write a program to check whether a given number is an ugly number.
 * 
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * 
 * Example 1:
 * 
 * Input: 6 Output: true Explanation: 6 = 2 × 3
 * 
 * Example 2:
 * 
 * Input: 8 Output: true Explanation: 8 = 2 × 2 × 2
 * 
 * Example 3:
 * 
 * Input: 14 Output: false Explanation: 14 is not ugly since it includes another
 * prime factor 7.
 * 
 * 
 * @author bramanarayan
 * @date Aug 22, 2020
 */
public class UglyNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UglyNumber solution = new UglyNumber();
		System.out.println(solution.isUgly(6));
		System.out.println(solution.isUgly(8));
		System.out.println(solution.isUgly(14));

	}

	// good math problem
	public boolean isUgly(int num) {
		if(num <= 0) return false;
		if( num ==1) return true; // if its purely divisible by 2,3 or 5, then num will reduce to 1 at last.
		
		if( num %2 ==0) {
			return isUgly(num/2);
		}
		if( num %3 ==0) {
			return isUgly(num/3);
		}
		
		if(num % 5 ==0) {
			return isUgly(num/5);
		}
		
		// if its not divisible by 2,3,5 then its not ugly.
		
		return false;
	}
	
}
