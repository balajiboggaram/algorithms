/**
 * 
 */
package me.learn.personal.month3;

import java.util.ArrayList;
import java.util.List;

import me.learn.utli.Utils;

/**
 * Title 1417 :
 * 
 * 
 * Given alphanumeric string s. (Alphanumeric string is a string consisting of
 * lowercase English letters and digits).
 * 
 * You have to find a permutation of the string where no letter is followed by
 * another letter and no digit is followed by another digit. That is, no two
 * adjacent characters have the same type.
 * 
 * Return the reformatted string or return an empty string if it is impossible
 * to reformat the string.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "a0b1c2" Output: "0a1b2c" Explanation: No two adjacent characters
 * have the same type in "0a1b2c". "a0b1c2", "0a1b2c", "0c2a1b" are also valid
 * permutations.
 * 
 * Example 2:
 * 
 * Input: s = "leetcode" Output: "" Explanation: "leetcode" has only characters
 * so we cannot separate them by digits.
 * 
 * Example 3:
 * 
 * Input: s = "1229857369" Output: "" Explanation: "1229857369" has only digits
 * so we cannot separate them by characters.
 * 
 * @author bramanarayan
 * @date Jul 10, 2020
 */
public class ReformatTheString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReformatTheString solution = new ReformatTheString();
		System.out.println(solution.reformat("covid2019"));
		System.out.println(solution.reformat("covid201989"));
		System.out.println(solution.reformat("covid201979889"));

	}

	public String reformat(String s) {
		
		int n = s.length();
		
		List<Character> letters = new ArrayList<Character>();
		List<Character> digits = new ArrayList<Character>();

		for (char c : s.toCharArray()) {
			if (Character.isDigit(c)) {
				digits.add(c);
			} else {
				letters.add(c);
			}
		}

		// if not possible
		if (Math.abs(letters.size() - digits.size()) > 1) {
			return "";
		}

		char[] c = new char[n];
		if (letters.size() >= digits.size()) {
			fill(c, 0, letters);
			fill(c, 1, digits);
		} else {
			fill(c,0, digits);
			fill(c,1, letters);
		}
		return new String(c);
	}

	private void fill(char[] c, int index, List<Character> digits) {
		int cur = 0;
		while (cur < digits.size()) {
			c[index] = digits.get(cur);
			index += 2;
			cur++;
		}
	}
}
