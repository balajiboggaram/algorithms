/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title 344 : 
 * 
 * Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.

Example 1:

Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]

 * 
 * @author bramanarayan
 * @date Jun 26, 2020
 */
public class ReverseAString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	public void reverseString(char[] s) {
		int l = 0; int r = s.length-1;
		while(l < r) {
			char t = s[l];
			s[l] = s[r];
			s[r] = t;
			
			l++;
			r--;
		}
	}

}
