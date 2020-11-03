/**
 * 
 */
package me.learn.personal.month4;

/**
 * Title 521 :
 * 
 * Given two strings, you need to find the longest uncommon subsequence of this
 * two strings. The longest uncommon subsequence is defined as the longest
 * subsequence of one of these strings and this subsequence should not be any
 * subsequence of the other string.
 * 
 * A subsequence is a sequence that can be derived from one sequence by deleting
 * some characters without changing the order of the remaining elements.
 * Trivially, any string is a subsequence of itself and an empty string is a
 * subsequence of any string.
 * 
 * The input will be two strings, and the output needs to be the length of the
 * longest uncommon subsequence. If the longest uncommon subsequence doesn't
 * exist, return -1.
 * 
 * Example 1:
 * 
 * Input: a = "aba", b = "cdc" Output: 3 Explanation: The longest uncommon
 * subsequence is "aba", because "aba" is a subsequence of "aba", but not a
 * subsequence of the other string "cdc". Note that "cdc" can be also a longest
 * uncommon subsequence.
 * 
 * Example 2:
 * 
 * Input: a = "aaa", b = "bbb" Output: 3
 * 
 * Example 3:
 * 
 * Input: a = "aaa", b = "aaa" Output: -1
 * 
 * 
 * @author bramanarayan
 * @date Jul 22, 2020
 */
public class LongestUncommonSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LongestUncommonSubsequence solution = new LongestUncommonSubsequence();
		System.out.println(solution.findLUSlength("aaa", "bbb"));
	}

	public int findLUSlength(String a, String b) {
		if(a.equals(b)) {
			return -1;
		} else {
			return Math.min(a.length(), b.length());
		}
	}

}
