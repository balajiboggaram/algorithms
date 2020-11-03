/**
 * 
 */
package me.learn.personal.month2;

import java.util.HashMap;
import java.util.Map;

/**
 * Title 205 :
 * 
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character but a character may map to itself.
 * 
 * Example 1:
 * 
 * Input: s = "egg", t = "add" Output: true
 * 
 * Example 2:
 * 
 * Input: s = "foo", t = "bar" Output: false
 * 
 * Example 3:
 * 
 * Input: s = "paper", t = "title" Output: true
 * 
 * @author bramanarayan
 * @date Aug 17, 2020
 */
public class IsomorphicStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		IsomorphicStrings solution = new IsomorphicStrings();
		System.out.println(solution.isIsomorphic("egg", "add"));
		System.out.println(solution.isIsomorphic("foo", "bar"));
		System.out.println(solution.isIsomorphic("paper", "title"));
		System.out.println(solution.isIsomorphic("aa", "ab"));

	}

	// one map -> for s to t
	// second map -> for t to s 
	public boolean isIsomorphic(String s, String t) {

		Map<Character, Character> map = new HashMap<>();
		Map<Character, Character> tmap = new HashMap<>();

		int i = 0, j = 0, m = s.length(), n = t.length();
		if (m != n)
			return false;
		while (i < m && j < n) {
			char sChar = s.charAt(i);
			char tChar = t.charAt(j);

			if (map.containsKey(sChar) && map.get(sChar) != tChar)
				return false;

			if (tmap.containsKey(tChar) && tmap.get(tChar) != sChar)
				return false;

			if (!tmap.containsKey(tChar)) {
				tmap.put(tChar, sChar);
			}

			map.put(sChar, tChar);
			i++;
			j++;

		}
		return true;
	}

}
