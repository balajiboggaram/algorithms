package me.learn.personal.monthlychallenge.may;

/**
 * 
 * Title : Given a positive integer num, write a function which returns True if
 * num is a perfect square else False.
 * 
 * @author bramanarayan
 * @date May 11, 2020
 */
public class ValidPerfectSquare {

	public static void main(String args[]) {
		ValidPerfectSquare solution = new ValidPerfectSquare();
		System.out.println(solution.isPerfectSquare(25));
		System.out.println(solution.isPerfectSquare(14));
		System.out.println(solution.isPerfectSquare(36));

	}

	/**
	 * Without Math.sqrt library function
	 * 
	 * Use Binary Search method.
	 */
	public boolean isPerfectSquare(int num) {
		int low = 1, high = num;
		while (low <= high) {
			long mid = low + (high - low) / 2;
			if (mid * mid == num) {
				return true;
			} else if (mid * mid < num) {
				low = (int) mid + 1;
			} else {
				high = (int) mid - 1;
			}
		}
		return false;
	}

	/**
	 * With Math.sqrt library function
	 */
	public boolean isPerfectSquareMy(int num) {
		int x = (int) Math.sqrt(num);
		System.out.println(x);
		return x * x == num;
	}
}
