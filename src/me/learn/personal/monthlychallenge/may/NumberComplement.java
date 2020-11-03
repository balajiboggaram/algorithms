package me.learn.personal.monthlychallenge.may;

/**
 * 
 * Title : Given a positive integer, output its complement number. The
 * complement strategy is to flip the bits of its binary representation.
 * 
 * @author bramanarayan
 * @date May 4, 2020
 */
public class NumberComplement {

	public static void main(String args[]) {

		NumberComplement solution = new NumberComplement();
		solution.findComplement(3);
		solution.findComplement(2);
		solution.findComplement(2);
		solution.findComplement(1);
		solution.findComplement(0);
	}

	public int findComplement(int num) {
		int copyNum = num;
		if (num == 0)
			return 1;
		int i = 0;
		while (copyNum != 0) {
			num = num ^ (1 << i);
			copyNum = copyNum >> 1;
			i++;
		}
		System.out.println(num);
		return num;
	}
}
