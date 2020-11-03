/**
 * 
 */
package me.learn.personal.month3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Title 791 :
 * 
 * S and T are strings composed of lowercase letters. In S, no letter occurs
 * more than once.
 * 
 * S was sorted in some custom order previously. We want to permute the
 * characters of T so that they match the order that S was sorted. More
 * specifically, if x occurs before y in S, then x should occur before y in the
 * returned string.
 * 
 * Return any permutation of T (as a string) that satisfies this property.
 * 
 * Example : Input: S = "cba" T = "abcd" Output: "cbad" Explanation: "a", "b",
 * "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a".
 * Since "d" does not appear in S, it can be at any position in T. "dcba",
 * "cdba", "cbda" are also valid outputs.
 * 
 * @author bramanarayan
 * @date Jun 25, 2020
 */
public class CustomSortString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CustomSortString solution = new CustomSortString();
		System.out.println(solution.customSortString("cba", "abcd"));
	}

	
	// count map for string t
	// as you iterate the string s, then formulate the t
	public String customSortString(String s, String t) {

		int m = s.length();
		int n = t.length();

		// Prepare the count map for string t
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < n; i++) {
			map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
		}

		StringBuilder sb = new StringBuilder();
		// iterate pattern now... i.e string s
		for (int i = 0; i < m; i++) {

			if (map.containsKey(s.charAt(i))) {
				// repeat the pattern char so many times from t
				sb.append(getString(s.charAt(i), map.get(s.charAt(i))));
				map.remove(s.charAt(i));
			}
		}
		
		// add remaining keys
		Iterator<Entry<Character,Integer>> it = map.entrySet().iterator();

		while(it.hasNext()) {
			Entry<Character,Integer> e = it.next();
			sb.append(getString(e.getKey(), e.getValue()));
			it.remove();
		}
		return sb.toString();

	}


	// In java 11 - you can directly use String.repeat("pat", n) method
	private String getString(char charAt, int n) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i <n; i++) {
			sb.append(charAt);
		}
		return sb.toString();
	}

}
