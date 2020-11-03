/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title 459 :
 * 
 * Given a non-empty string check if it can be constructed by taking a substring
 * of it and appending multiple copies of the substring together. You may assume
 * the given string consists of lowercase English letters only and its length
 * will not exceed 10000.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: "abab" Output: True Explanation: It's the substring "ab" twice.
 * 
 * Example 2:
 * 
 * Input: "aba" Output: False
 * 
 * Example 3:
 * 
 * Input: "abcabcabcabc" Output: True Explanation: It's the substring "abc" four
 * times. (And the substring "abcabc" twice.)
 * 
 * 
 * 
 * @author bramanarayan
 * @date Jun 30, 2020
 */
public class RepeatedSubStringPattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	// Very tricky solution.
	
	// if you repeat the given string, and then remove first and last character in it. 
	// then now, if you are able to find the original string s in that trimmed repeat string, then yes its possible.
	// else nope - sorry
	// Take some examples and try them
	public boolean repeatedSubstringPattern(String s) {
		return (s + s).substring(1, 2 * s.length()-1 ).contains(s);
		
	}

}
