/**
 * 
 */
package me.learn.personal.month4;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Title 409 :
 * 
 * Given a string s which consists of lowercase or uppercase letters, return the
 * length of the longest palindrome that can be built with those letters.
 * 
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome
 * here.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abccccdd" Output: 7 Explanation: One longest palindrome that can
 * be built is "dccaccd", whose length is 7.
 * 
 * Example 2:
 * 
 * Input: s = "a" Output: 1
 * 
 * 
 * @author bramanarayan
 * @date Aug 21, 2020
 */
public class LongestPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LongestPalindrome solution = new LongestPalindrome();
		System.out.println(solution.longestPalindrome("abccccdd"));
	}

	public int longestPalindrome(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}

		int count = 0;
		boolean isOdd = false;
		for (Entry<Character, Integer> e : map.entrySet()) {
			if (e.getValue() % 2 == 0) {
				count += e.getValue();
			} else {
				count += e.getValue() -1 ;
				isOdd = true;
			}
		}

		return isOdd ? count + 1 : count;
	}

}
