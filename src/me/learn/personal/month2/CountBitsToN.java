package me.learn.personal.month2;

/**
 * 
 * Title 338 : Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example 1:

Input: 2
Output: [0,1,1]

Example 2:

Input: 5
Output: [0,1,1,2,1,2]

Follow up:

    It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
    Space complexity should be O(n).
    Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.

 * 
 * @author bramanarayan
 * @date May 28, 2020
 */
public class CountBitsToN {
	
	public static void main(String args[]) {
		CountBitsToN solution = new CountBitsToN();
		solution.countBits(10);
	}
	
	
	public int[] countBits(int n) {
		int[] res = new int[n + 1];
		res[0] = 0;
		for (int i = 1; i <= n; i++) {
			if (i % 2 == 0) {
				res[i] = res[i / 2];
			} else {
				res[i] = res[i - 1] + 1;
			}
		}
		return res;
	}
}
