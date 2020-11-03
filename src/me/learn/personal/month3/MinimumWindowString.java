/**
 * 
 */
package me.learn.personal.month3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Title 76 :
 * 
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * Example:
 * 
 * Input: S = "ADOBECODEBANC", T = "ABC" Output: "BANC"
 * 
 * Note:
 * 
 * If there is no such window in S that covers all characters in T, return the
 * empty string "". If there is such window, you are guaranteed that there will
 * always be only one unique minimum window in S.
 * 
 * 
 * 
 * @author bramanarayan
 * @date Jul 16, 2020
 */
public class MinimumWindowString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MinimumWindowString solution = new MinimumWindowString();
		System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
	}

	public String minWindow(String s, String t) {

		if (s == null || t == null)
			return "";

		if (t.length() > s.length())
			return "";

		// Frequency map of string t
		Map<Character, Integer> dict = new HashMap<Character, Integer>();
		for (char c : t.toCharArray()) {
			dict.put(c, dict.getOrDefault(c, 0) + 1);
		}

		int required = dict.size(); // i.e we need these many unique characters in s for a match.
		int start = -1;
		int end = -1;
		int minLength = Integer.MAX_VALUE;
		Map<Character, Integer> m = new HashMap<Character, Integer>();
		int formed = 0;
		int l = 0, r = 0;
		Set<Character> met = new HashSet<Character>();
		while (r < s.length()) {

			// blindly increment your running map 'm'
			char ch = s.charAt(r);
			m.put(ch, m.getOrDefault(ch, 0) + 1);

			// if I have more than characters I need in my running map.
			if (dict.containsKey(ch) && m.get(ch) >= dict.get(ch) && !met.contains(ch)) {
				met.add(ch);
				formed++;
			}

			// shrink window from left now if we have a window of all t characters
			while (l <= r && formed == required) {

				if (minLength > r - l) {
					minLength = r - l + 1;
					start = l;
					end = r;
				}
				char lChar = s.charAt(l);
				m.put(lChar, m.get(lChar) - 1);
				// If running dont have enough as what we need in dict. then formed--
				if (dict.containsKey(lChar) && m.get(lChar) < dict.get(lChar) && met.contains(lChar)) {
					formed--;
					met.remove(lChar);
				}
				l++;
			}

			r++;

		}
		return start == -1 ? "" : s.substring(start, end + 1);

	}

}
