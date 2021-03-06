/**
 * 
 */
package me.learn.personal.month4;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Title 409 :
 * 
 * Given a string s which consists of lowercase or uppercase letters, return the
 * length of the longest palindrome that can be built with those letters.
 * 
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome
 * here.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abccccdd" Output: 7 Explanation: One longest palindrome that can
 * be built is "dccaccd", whose length is 7.
 * 
 * Example 2:
 * 
 * Input: s = "a" Output: 1
 * 
 * 
 * @author bramanarayan
 * @date Aug 21, 2020
 */
public class LongestPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LongestPalindrome solution = new LongestPalindrome();
		System.out.println(solution.longestPalindrome("abccccdd"));
	}

	// for matrix type implementatino look here : https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
	
	public int longestPalindrome(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}

		int count = 0;
		boolean isOdd = false;
		for (Entry<Character, Integer> e : map.entrySet()) {
			if (e.getValue() % 2 == 0) {
				count += e.getValue();
			} else {
				count += e.getValue() -1 ;
				isOdd = true;
			}
		}

		return isOdd ? count + 1 : count;
	}
	
	
	// a different problem
	
	// RESULT -> Longest palindrome as String
	public String longestPalindromeSubStringInString(String str)
    {
        // get length of input string
        int n = str.length();
 
        // table[i][j] will be false if
        // substring str[i..j] is not palindrome.
        // Else table[i][j] will be true
        boolean table[][] = new boolean[n][n];
 
        // All substrings of length 1 are palindromes
        int maxLength = 1;
        for (int i = 0; i < n; ++i)
            table[i][i] = true;
 
        // check for sub-string of length 2.
        int start = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                table[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }
 
        // Check for lengths greater than 2.
        // k is length of substring
        for (int k = 3; k <= n; ++k) {
 
            // Fix the starting index
            for (int i = 0; i < n - k + 1; ++i) {
                // Get the ending index of substring from
                // starting index i and length k
                int j = i + k - 1;
 
                // checking for sub-string from ith index to
                // jth index iff str.charAt(i+1) to
                // str.charAt(j-1) is a palindrome
                if (table[i + 1][j - 1]
                    && str.charAt(i) == str.charAt(j)) {
                    table[i][j] = true;
 
                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        System.out.print("Longest palindrome substring is; ");

 
        // return length of LPS
        return str.substring(start, start+maxLength );
    }
 
	
	

}
