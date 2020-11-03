package me.learn.personal.month2;

import java.util.Arrays;

/**
 * 
 * Title 1170 :
 * 
 * Let's define a function f(s) over a non-empty string s, which calculates the
 * frequency of the smallest character in s. For example, if s = "dcce" then
 * f(s) = 2 because the smallest character is "c" and its frequency is 2.
 * 
 * Now, given string arrays queries and words, return an integer array answer,
 * where each answer[i] is the number of words such that f(queries[i]) < f(W),
 * where W is a word in words.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: queries = ["cbd"], words = ["zaaaz"] Output: [1] Explanation: On the
 * first query we have f("cbd") = 1, f("zaaaz") = 3 so f("cbd") < f("zaaaz").
 * 
 * Example 2:
 * 
 * Input: queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"] Output: [1,2]
 * Explanation: On the first query only f("bbb") < f("aaaa"). On the second
 * query both f("aaa") and f("aaaa") are both > f("cc").
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= queries.length <= 2000 1 <= words.length <= 2000 1 <= queries[i].length,
 * words[i].length <= 10 queries[i][j], words[i][j] are English lowercase
 * letters.
 * 
 * 
 * 
 * @author bramanarayan
 * @date Jun 7, 2020
 */
public class CompareStringsByFrequency {

	public int[] numSmallerByFrequency(String[] queries, String[] words) {

		int m = queries.length;
		int n = words.length;

		int result[] = new int[m];
		int wor[] = new int[n];

		// Compute all the answers of given words.
		for (int i = 0; i < n; i++) {
			wor[i] = computeMin(words[i]);
		}
		Arrays.sort(wor); // sort the frequency of words

		// check the result
		for (int i = 0; i < m; i++) {
			int quer = computeMin(queries[i]);
			int j = 0;
			// Linear search - can do a binary search too
			for (j = 0; j < n; j++) {
				if (quer < wor[j])
					break;
			}
			result[i] = wor.length - j;
		}
		return result;
	}

	// get the frequency
	private int computeMin(String x) {
		int letters[] = new int[26];
		for (int i = 0; i < x.length(); i++) {
			letters[x.charAt(i) - 'a']++;
		}
		int min = 0;
		for (int i = 0; i < 26; i++) {
			if (letters[i] != 0) {
				min = letters[i];
				break;
			}
		}
		return min;
	}

}
