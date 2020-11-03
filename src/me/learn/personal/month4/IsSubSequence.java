/**
 * 
 */
package me.learn.personal.month4;

/**
 * Title 392 :
 * 
 * 
 * Given a string s and a string t, check if s is subsequence of t.
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ace" is a
 * subsequence of "abcde" while "aec" is not).
 * 
 * Follow up: If there are lots of incoming S, say S1, S2, ... , Sk where k >=
 * 1B, and you want to check one by one to see if T has its subsequence. In this
 * scenario, how would you change your code?
 * 
 * Credits: Special thanks to @pbrother for adding this problem and creating all
 * test cases.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abc", t = "ahbgdc" Output: true
 * 
 * 
 * @author bramanarayan
 * @date Aug 3, 2020
 */
public class IsSubSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		IsSubSequence solution = new IsSubSequence();
		System.out.println(solution.isSubsequence("bcd", "uuubcd"));

		System.out.println(solution.isSubsequence("abc", "ahbgdc"));
		System.out.println(solution.isSubsequence("axc", "ahbgdc"));

	}

	public boolean isSubsequence(String s, String t) {
		if (s == null && t == null)
			return true;
		if (t == null || s == null)
			return false;
		
		if(s.isEmpty()) return true;
		int i = 0, j = 0;
		int m = s.length();
		int n = t.length();

		while (i < m && j < n) {
			
			if(s.charAt(i) == t.charAt(j)) {
				i++;
			}
			if(i == m) return true;
			j++;
		}
		
		return false;
	}

}
