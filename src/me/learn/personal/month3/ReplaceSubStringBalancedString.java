/**
 * 
 */
package me.learn.personal.month3;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Title 1234 :
 * 
 *  You are given a string containing only 4 kinds of characters 'Q', 'W', 'E' and 'R'.

A string is said to be balanced if each of its characters appears n/4 times where n is the length of the string.

Return the minimum length of the substring that can be replaced with any other string
 of the same length to make the original string s balanced.

Return 0 if the string is already balanced.

 

Example 1:

Input: s = "QWER"
Output: 0
Explanation: s is already balanced.

Example 2:

Input: s = "QQWE"
Output: 1
Explanation: We need to replace a 'Q' to 'R', so that "RQWE" (or "QRWE") is balanced.

Example 3:

Input: s = "QQQW"
Output: 2
Explanation: We can replace the first "QQ" to "ER". 

Example 4:

Input: s = "QQQQ"
Output: 3
Explanation: We can replace the last 3 'Q' to make s = "QWER".


Example 5 : WWEQERQWQWWR - GOod example
output : 4 (from index 7 to 10) WQWW
 * 
 * @author bramanarayan
 * @date Jun 30, 2020
 */
public class ReplaceSubStringBalancedString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReplaceSubStringBalancedString solution = new ReplaceSubStringBalancedString();
		System.out.println(solution.balancedString("WWEQERQWQWWRWWERQWEQ"));

		System.out.println(solution.balancedString("QWER"));
		System.out.println(solution.balancedString("QQWE"));
		
		System.out.println(solution.balancedString("WQWRQQQW"));


	}

	public int balancedString(String s) {
		 int n = s.length();
		 Map<Character, Integer> map = new HashMap<Character,Integer>();
		 
		 // Calculate all the frequencies
		 for(char c : s.toCharArray()) {
			 map.put(c, map.getOrDefault(c, 0) + 1);
		 }
		 
		 // change the map such that - compute how much we need more characters
		 // n/4 is what we require for every character.
		 boolean  allEqual = true;
		 for(Entry<Character,Integer> e : map.entrySet()) {
			 int needed = e.getValue() - (n/4);
			 if(needed > 0) {
				 allEqual = false;
				 map.put(e.getKey(), needed);
			 } else {
				 map.put(e.getKey(), 0);
			 }
		 }
		 
		 if(allEqual) 
			 return 0;
		 
		// now, start the runner
		int start = 0, end =0;
		int res = Integer.MAX_VALUE;
		while (end < n) {

			// have all characters of size = n/4
			char c = s.charAt(end);
			map.put(c, map.get(c) - 1);

			// keep decrementing the map. we need all values to be negative in map.
			// then we found the minimum window/substring where we can successfully modify
			// to

			if (valid(map)) {

				// try to shrink the window from left side
				while (valid(map) && start <= end) {
					res = Math.min(res, end - start + 1);

					map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
					start++;
				}
			}

			end++;
		}
		return res;
	}

	private boolean valid(Map<Character, Integer> map) {
		for(Entry<Character,Integer> e : map.entrySet()) {
			if(e.getValue() > 0) return false;
		}
		return true;
	}

}
