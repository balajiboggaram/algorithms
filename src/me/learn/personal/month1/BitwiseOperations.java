package me.learn.personal.month1;

/**
 * 
 * Title : Demonstrate multiple bitwise operations
 * 
 * @author bramanarayan
 * @date Apr 22, 2020
 */
public class BitwiseOperations {

	public static void main(String args[]) {

		setABit(0, 4); // set the 4th bit, 0000 -> 1000 [8]
		clearABit(16, 5); // clear the 5th bit, 10000 -> 00000 [0]
		toggleABit(8, 4); // toggle the 4th bit, 1000 -> 0000 [0]
		checkABit(8, 4); // check the 4th bit 1000 -> true
		checkABit(4, 2); // check the 4th bit 1000 -> true
		checkABitSpl(8, 4); // check the 4th bit 1000 -> true
		checkABitSpl(4, 2); // check the 4th bit 1000 -> true
		countBits(4);
	}

	public static void setABit(int input, int n) {
		input = input | (1 << n - 1);
		System.out.println(input);
	}

	public static void clearABit(int input, int n) {
		input = input & ~(1 << n - 1);
		System.out.println(input);
	}

	public static void toggleABit(int input, int n) {
		input = input ^ (1 << n - 1);
		System.out.println(input);
	}

	public static void checkABit(int input, int n) {
		boolean isSet = ((input >> n - 1) & 1) == 1;
		System.out.println(isSet);
	}
	
	public static void checkABitSpl(int input, int n) {
		boolean isSet = (input & ( n << 1)) == 1;
		System.out.println("My : " + isSet);
	}

	public static void countBits(int input) {
		int count = 0;
		while (input != 0) {
			input = input >> 1;
			count++;
		}
		System.out.println("count: " +count);
	}
}
