/**
 * 
 */
package me.learn.personal.month3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Title 1456 :
 * 
 * Given a string s and an integer k.
 * 
 * Return the maximum number of vowel letters in any substring of s with length
 * k.
 * 
 * Vowel letters in English are (a, e, i, o, u).
 *
 * Example 1:
 * 
 * Input: s = "abciiidef", k = 3 Output: 3 Explanation: The substring "iii"
 * contains 3 vowel letters.
 * 
 * Example 2:
 * 
 * Input: s = "aeiou", k = 2 Output: 2 Explanation: Any substring of length 2
 * contains 2 vowels.
 * 
 * Example 3:
 * 
 * Input: s = "leetcode", k = 3 Output: 2 Explanation: "lee", "eet" and "ode"
 * contain 2 vowels.
 * 
 * Example 4:
 * 
 * Input: s = "rhythms", k = 4 Output: 0 Explanation: We can see that s doesn't
 * have any vowel letters.
 * 
 * Example 5:
 * 
 * Input: s = "tryhard", k = 4 Output: 1
 * 
 * 
 * @author bramanarayan
 * @date Jul 15, 2020
 */
public class MaxVowelsInSubstring {

	Set<Character> vowels = new HashSet<Character>(Arrays.asList('a','e','i','o','u'));
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MaxVowelsInSubstring solution = new MaxVowelsInSubstring();
		System.out.println(solution.maxVowels("abciiidef", 3));
		System.out.println(solution.maxVowels("aeiou", 2));

	}

	// SLIDING WINDOW
	public int maxVowels(String s, int k) {

		int n = s.length();
		int result = 0;

		// check for 0 to k-2 characters first.
		int count = 0, start = 0;
		for (int i = 0; i <= k - 2; i++) {
			if (isVowel(s.charAt(i)))
				count++;
		}

		// Now, check sliding window
		for (int i = k - 1; i < n; i++) {
			if (isVowel(s.charAt(i))) {
				count++;
			}

			result = Math.max(count, result);

			// keep shrinking from left side
			if (isVowel(s.charAt(start))) {
				count--;
			}
			start++;
		}

		return result;

	}

	private boolean isVowel(char charAt) {
		return vowels.contains(charAt);
	}

}
