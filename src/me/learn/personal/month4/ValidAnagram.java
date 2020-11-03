/**
 * 
 */
package me.learn.personal.month4;

/**
 * Title 242 :
 * 
 * Given two strings s and t , write a function to determine if t is an anagram
 * of s.
 * 
 * Example 1:
 * 
 * Input: s = "anagram", t = "nagaram" Output: true
 * 
 * Example 2:
 * 
 * Input: s = "rat", t = "car" Output: false
 * 
 * 
 * @author bramanarayan
 * @date Aug 21, 2020
 */
public class ValidAnagram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ValidAnagram solution = new ValidAnagram();
		System.out.println(solution.isAnagram("anagram" , "nagaram"));
	}

	public boolean isAnagram(String s, String t) {
		int[] count = new int[26];
		
		for(char c : s.toCharArray()) {
			count[c - 'a']++;
		}
		
		for(char c : t.toCharArray()) {
			count[c - 'a']--;
		}
		
		for(int i : count) {
			if(i != 0) return false; 
		}
		
		return true;
		
	}
}
