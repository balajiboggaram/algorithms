/**
 * 
 */
package me.learn.personal.month3;

import java.util.HashMap;
import java.util.Map;

/**
 * Title 159 :
 * 
 *  Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.

Example 1:

Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.

Example 2:

Input: "ccaabbb"
Output: 5
Explanation: t is "aabbb" which its length is 5.

 * 
 * @author bramanarayan
 * @date Jun 29, 2020
 */
public class LongestSubStringWithAtmost2Distinct {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LongestSubStringWithAtmost2Distinct solution = new LongestSubStringWithAtmost2Distinct();
		System.out.println(solution.lengthOfLongestSubstringTwoDistinct("eceba"));
		System.out.println(solution.lengthOfLongestSubstringTwoDistinct("ccaabbb"));

	}

	public int lengthOfLongestSubstringTwoDistinct(String s) {
		return lengthOfLongestSubstringKDistinct(s, 2);
	}

	// LONGEST SUBSTRING WITH 'k' DISTINCt CHARS
	// TWO POINTERS
	// HASH MAP
	// SLIDING WINDOW
	// Keep chopping from the left side.
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		int n = s.length();

		int start = 0,res = 0, i = 0;
		Map<Character, Integer> map = new HashMap<Character,Integer>();
		
		while (i < n) {
			
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) +1);
			
			// please remove if there are excess than k in the map.
			// Keep chopping from the left side. 
			while(map.size() > k) {
				char startChar = s.charAt(start);
				if(map.get(startChar) > 1) {
					map.put(startChar, map.get(startChar)-1);
				} else {
					map.remove(startChar);
				}
				start++;
			}
			res = Math.max(res, i - start +1);
			i++;
		}
		
		return res;
	}

}
