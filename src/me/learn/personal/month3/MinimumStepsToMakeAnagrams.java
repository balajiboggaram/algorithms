/**
 * 
 */
package me.learn.personal.month3;

import java.util.HashMap;
import java.util.Map;

/**
 * Title 1347 :
 * 
 * Given two equal-size strings s and t. In one step you can choose any
 * character of t and replace it with another character.
 * 
 * Return the minimum number of steps to make t an anagram of s.
 * 
 * An Anagram of a string is a string that contains the same characters with a
 * different (or the same) ordering.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "bab", t = "aba" Output: 1 Explanation: Replace the first 'a' in t
 * with b, t = "bba" which is anagram of s.
 * 
 * Example 2:
 * 
 * Input: s = "leetcode", t = "practice" Output: 5 Explanation: Replace 'p',
 * 'r', 'a', 'i' and 'c' from t with proper characters to make t anagram of s.
 * 
 * 
 * 
 * @author bramanarayan
 * @date Jun 25, 2020
 */
public class MinimumStepsToMakeAnagrams {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MinimumStepsToMakeAnagrams solution = new MinimumStepsToMakeAnagrams();
		System.out.println(solution.minSteps("bab","aba"));
		System.out.println(solution.minSteps("leetcode","practice"));
		System.out.println(solution.minSteps("anagram","mangaar"));
		System.out.println(solution.minSteps("xxyyzz","xxyyzz"));
		System.out.println(solution.minSteps("friend","family"));

	}

	// 1. prepare a hashmap with counts of character In String s
	// 2. Iterate the string t now.
	   // 2a. if the t's char is present in map - reduce or remove if count is zero.
	   // 2b. if not then count++
	public int minSteps(String s, String t) {
		
		int m = s.length();
		int n = t.length();
		
		if(m != n) return -1;
		
		Map<Character,Integer> map = new HashMap<Character,Integer>();		
		for (int i = 0; i < m; i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}
		
		int count = 0;
		for(int i = 0;i < n;i++) {
			char temp = t.charAt(i);
			if(map.containsKey(temp)) {
				map.put(temp, map.get(temp) -1);
				if(map.get(temp) == 0) 
					map.remove(temp);
			} else {
				count++;
			}
			
		}
		return count;
	}
}

