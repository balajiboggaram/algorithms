/**
 * 
 */
package me.learn.personal.month3;

import java.util.HashMap;
import java.util.Map;

/**
 * Title 1358 :
 * 
 * Given a string s consisting only of characters a, b and c.
 * 
 * Return the number of substrings containing at least one occurrence of all
 * these characters a, b and c.
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abcabc" Output: 10 Explanation: The substrings containing at
 * least one occurrence of the characters a, b and c are "abc", "abca", "abcab",
 * "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).
 * 
 * Example 2:
 * 
 * Input: s = "aaacb" Output: 3 Explanation: The substrings containing at least
 * one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb".
 * 
 * 
 * @author bramanarayan
 * @date Jul 14, 2020
 */
public class SubStringWithAllThreeCharacters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SubStringWithAllThreeCharacters solution = new SubStringWithAllThreeCharacters();
		System.out.println(solution.numberOfSubstrings("abcabc"));
	}

	
	// TWO POINTERS - Beautiful
	public int numberOfSubstrings(String s) {
		Map<Character, Integer> m = new HashMap<Character, Integer>();
		int start = 0;
		int result = 0, n = s.length();

		for (int j = 0; j < n; j++) {
			char ch = s.charAt(j);
			m.put(ch, m.getOrDefault(ch, 0) + 1);

			// we have all the characters in the substring from start to j
			if (m.size() == 3) {

				while (start < j && m.size() == 3) {
					result += (n - j) ; // care only about right side. left side will be already covered in prev
										// iterations
					
					char startChar = s.charAt(start);
					m.put(startChar, m.get(startChar) - 1);
					if (m.get(startChar) == 0)
						m.remove(startChar);
					start++;
				}

			}
		}
		return result;
	}

}
