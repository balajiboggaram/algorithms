/**
 * 
 */
package me.learn.personal.month4;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Title 266 :
 * 
 * Given a string, determine if a permutation of the string could form a
 * palindrome.
 * 
 * Example 1:
 * 
 * Input: "code" Output: false
 * 
 * Example 2:
 * 
 * Input: "aab" Output: true
 * 
 * @author bramanarayan
 * @date Aug 21, 2020
 */
public class PalindromePermutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PalindromePermutation solution = new PalindromePermutation();
		System.out.println(solution.canPermutePalindrome("code"));
		System.out.println(solution.canPermutePalindrome("aab"));

	}

	public boolean canPermutePalindrome(String s) {
		Map<Character,Integer> map = new HashMap<>();
		
		for(char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		int oddCount = 0;
		for(Entry<Character,Integer> e : map.entrySet()) {
			oddCount += e.getValue() % 2 == 0 ? 0 : 1;
			if(oddCount > 1) return false;
		}
		return true;
	}

}
