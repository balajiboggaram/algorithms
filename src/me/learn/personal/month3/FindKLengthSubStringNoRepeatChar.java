/**
 * 
 */
package me.learn.personal.month3;

import java.util.HashMap;
import java.util.Map;

/**
 * Title 1100 : 
 * 
 * Given a string S, return the number of substrings of length K with no repeated characters.

Example 1:

Input: S = "havefunonleetcode", K = 5
Output: 6
Explanation: 
There are 6 substrings they are : 'havef','avefu','vefun','efuno','etcod','tcode'.

Example 2:

Input: S = "home", K = 5
Output: 0
Explanation: 
Notice K can be larger than the length of S. In this case is not possible to find any substring.

 * 
 * @author bramanarayan
 * @date Jun 25, 2020
 */
public class FindKLengthSubStringNoRepeatChar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindKLengthSubStringNoRepeatChar solution = new FindKLengthSubStringNoRepeatChar();
		System.out.println(solution.numKLenSubstrNoRepeats("havefunonleetcode", 5));
		System.out.println(solution.numKLenSubstrNoRepeats("home", 5));

	}

	// SLIDING WINDOW with HASHMAP having count in them
	// then at any point if the map size is 5, bingo - you got the answer.
	// keep counting the occurrences of such kind !!!
	public int numKLenSubstrNoRepeats(String s, int k) {

		int count = 0, m = s.length();
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		if(k > m) return 0; // if the string length is less than k
		
		// Initial window of size k
		for (int i = 0; i < k; i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}
		count = map.size() == k ? 1 : 0;

		// subsequent windows now...
		for (int i = k; i < m; i++) {

			System.out.println(s.charAt(i));
			// add the new character at i
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

			// remove the old character at i-k
			if (map.get(s.charAt(i-k)) > 1) {
				map.put(s.charAt(i-k), map.get(s.charAt(i-k)) - 1);
			} else {
				map.remove(s.charAt(i-k));
			}

			// check if all are unique
			if (map.size() == k)
				count++;

		}

		return count;

	}

}
