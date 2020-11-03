/**
 * 
 */
package me.learn.personal.month3;

import java.util.HashMap;
import java.util.Map;

/**
 * Title 3 : 
 * 
 * Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 

Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


 * 
 * @author bramanarayan
 * @date Jun 29, 2020
 */
public class LongestSubStringWithoutRepeatingChar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LongestSubStringWithoutRepeatingChar solution = new LongestSubStringWithoutRepeatingChar();
		System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
		System.out.println(solution.lengthOfLongestSubstring("bbbbbb"));
		System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
		System.out.println(solution.lengthOfLongestSubstring("tmmzuxt"));
		System.out.println(solution.lengthOfLongestSubstring("aab"));
	}

	// SLIDING WINDOW
	// HASHING
	// 2 POINTERS
	public int lengthOfLongestSubstring(String s) {

		if (s == null)
			return 0;
		if (s.isEmpty())
			return 0;

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int n = s.length();
		int i = 0, res = 1;
		int start = 0;
		while (i < n) {

			char c = s.charAt(i);

			if (map.containsKey(c)) {
				res = Math.max(res, i - start);

				int temp = start;
				start = map.get(c) + 1;

				// just remove the old characters from map
				while (temp < start) {
					map.remove(s.charAt(temp));
					temp++;
				}
			}
			map.put(c, i);
			i++;

		}

		res = Math.max(i - start, res);
		return res;
	}

}
