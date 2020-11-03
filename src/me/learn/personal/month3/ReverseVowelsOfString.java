/**
 * 
 */
package me.learn.personal.month3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Title 345 : 
 * 
 * Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:

Input: "hello"
Output: "holle"

Example 2:

Input: "leetcode"
Output: "leotcede"

Note:
The vowels does not include the letter "y".
 * 
 * @author bramanarayan
 * @date Jun 26, 2020
 */
public class ReverseVowelsOfString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ReverseVowelsOfString solution = new ReverseVowelsOfString();
		System.out.println(solution.reverseVowels("hello"));
		System.out.println(solution.reverseVowels("leetcode"));
		System.out.println(solution.reverseVowels("aA"));

	}

	// TWO POINTERS solution
	public String reverseVowels(String s) {

		char[] c = s.toCharArray();
		int n = c.length;
		
		int l =0,r = n-1;
		List<Character> vowels = Arrays.asList('a','e','i','o','u','A','E','O','U','I');
				
		while(l < r) {
			
			// keep incrementing until you get a vowel
			while (l < r && l < n) {

				if (vowels.contains(c[l])) {
					break;
				}
				l++;
			}
			
			// Keep decrementing until you get  a vowel
			while(l<r && r >= 0) {
				if(vowels.contains(c[r])) {
					break;
				}
				r--;
			}
						
			char t = c[l];
			c[l] = c[r];
			c[r] = t;
			
			l++;
			r--;
			
		}
		
		return new String(c);
	}

}
