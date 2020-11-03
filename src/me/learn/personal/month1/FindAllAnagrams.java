package me.learn.personal.month1;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Title : Given a string s and a non-empty string p, find all the start indices
 * of p's anagrams in s.
 * 
 * Strings consists of lowercase English letters only and the length of both
 * strings s and p will not be larger than 20,100.
 * 
 * The order of output does not matter.
 * 
 * @author bramanarayan
 * @date May 13, 2020
 */
public class FindAllAnagrams {

	public static void main(String args[]) {
		FindAllAnagrams solution = new FindAllAnagrams();
		solution.findAnagrams("cbaebabacd", "abc");
		solution.findAnagrams("abab", "ab");
		solution.findAnagrams("baa", "aa");

	}

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<Integer>();
		if (s == null)
			return result;
		int m = p.length();
		int n = s.length();
		if (m > n)
			return result;

		int[] count = new int[26];

		// Keep the count of pattern characters and also m length of text
		for (int i = 0; i < m; i++) {
			count[p.charAt(i) - 'a']++;
			count[s.charAt(i) - 'a']--;
		}
		if (allZero(count)) {
			result.add(0);
		}

		// Find all the indexes where patterns match the text.
		// Add char , do ++. Subtract the char, do --. A rolling window
		for (int i = m; i < n; i++) {
			count[s.charAt(i) - 'a']--;
			count[s.charAt(i - m) - 'a']++;
			if (allZero(count)) {
				System.out.println("Found anagram");
				result.add(i - m + 1);
			}
		}
		System.out.println(result);
		return result;
	}

	private boolean allZero(int[] count) {
		for (int i = 0; i < 26; i++) {
			if (count[i] != 0)
				return false;
		}
		return true;
	}
}
