package me.learn.personal.monthlychallenge;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Title : Write an algorithm to determine if a number n is "happy".
 * 
 * A happy number is a number defined by the following process: Starting with
 * any positive integer, replace the number by the sum of the squares of its
 * digits, and repeat the process until the number equals 1 (where it will
 * stay), or it loops endlessly in a cycle which does not include 1. Those
 * numbers for which this process ends in 1 are happy numbers.
 * 
 * @author bramanarayan
 * @date Apr 29, 2020
 */
public class HappyNumber {

	public static void main(String args[]) {
		HappyNumber solution = new HappyNumber();
		solution.isHappy(1);
		solution.isHappy(19);
		solution.isHappy(-19);
		solution.isHappy(1287648436);

	}

	public boolean isHappy(int n) {
		int rem = 0, input = n;
		Set<Integer> s = new HashSet<Integer>();

		boolean happy;
		if (n < 0) {
			n = -1 * n; // Make the integer positive
		}

		while (n > 1) {

			if (s.contains(n))
				break;
			s.add(n);
			int result = 0;
			while (n > 0) {
				rem = n % 10;
				result = result + (rem * rem);
				n = n / 10;
			}
			n = result;
			if (n < 0)
				break;
		}
		happy = n == 1;
		System.out.println(String.format("Is %d happy ? : %s", input, happy));
		return happy;
	}

}
