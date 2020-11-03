/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title 190 :
 * 
 * Reverse bits of a given 32 bits unsigned integer.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: 00000010100101000001111010011100 Output:
 * 00111001011110000010100101000000 Explanation: The input binary string
 * 00000010100101000001111010011100 represents the unsigned integer 43261596, so
 * return 964176192 which its binary representation is
 * 00111001011110000010100101000000.
 * 
 * Example 2:
 * 
 * Input: 11111111111111111111111111111101 Output:
 * 10111111111111111111111111111111 Explanation: The input binary string
 * 11111111111111111111111111111101 represents the unsigned integer 4294967293,
 * so return 3221225471 which its binary representation is
 * 10111111111111111111111111111111.
 * 
 * @author bramanarayan
 * @date Jul 13, 2020
 */
public class ReverseBits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	// you need treat n as an unsigned value
	public int reverseBits(int n) {

		if (n == 0)
			return 0;
		int res = 0;
		int i = 0;
		while (i < 32) {
			res = res << 1;
			if ((n & 1) == 1)
				res++;
			n = n >> 1; // cant do divide by two
			i++;
		}

		return res;
	}

	public int reverseBitsOther(int n) {
		if (n == 0)
			return 0;

		int result = 0;
		for (int i = 0; i < 32; i++) {
			result <<= 1;
			if ((n & 1) == 1)
				result++;
			n >>= 1;
		}
		return result;
	}
}
