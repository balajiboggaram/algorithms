/**
 * 
 */
package me.learn.personal.month3;

import java.util.HashMap;
import java.util.Map;

/**
 * Title 833 :
 * 
 * To some string S, we will perform some replacement operations that replace
 * groups of letters with new ones (not necessarily the same size).
 * 
 * Each replacement operation has 3 parameters: a starting index i, a source
 * word x and a target word y. The rule is that if x starts at position i in the
 * original string S, then we will replace that occurrence of x with y. If not,
 * we do nothing.
 * 
 * For example, if we have S = "abcd" and we have some replacement operation i =
 * 2, x = "cd", y = "ffff", then because "cd" starts at position 2 in the
 * original string S, we will replace it with "ffff".
 * 
 * Using another example on S = "abcd", if we have both the replacement
 * operation i = 0, x = "ab", y = "eee", as well as another replacement
 * operation i = 2, x = "ec", y = "ffff", this second operation does nothing
 * because in the original string S[2] = 'c', which doesn't match x[0] = 'e'.
 * 
 * All these operations occur simultaneously. It's guaranteed that there won't
 * be any overlap in replacement: for example, S = "abc", indexes = [0, 1],
 * sources = ["ab","bc"] is not a valid test case.
 * 
 * Example 1:
 * 
 * Input: S = "abcd", indexes = [0,2], sources = ["a","cd"], targets =
 * ["eee","ffff"] Output: "eeebffff" Explanation: "a" starts at index 0 in S, so
 * it's replaced by "eee". "cd" starts at index 2 in S, so it's replaced by
 * "ffff".
 * 
 * 
 * @author bramanarayan
 * @date Jul 15, 2020
 */
public class FindAndReplaceInString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

	
	// INTELLIGENT APPROACH - 
	public String findReplaceString(String s, int[] indexes, String[] sources, String[] targets) {

		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		
		// prepare a map for all the starts of words to replace
		for(int i =0; i < indexes.length; i++) {
			int fromIndex = indexes[i];
			
			// to check if the string starts at a given fromIndex
			if(s.startsWith(sources[i], fromIndex)) {
				m.put(fromIndex, i); // index of a char in the string and i for future length
			}			
		}
		
		int n = s.length(), i =0;
		StringBuilder sb = new StringBuilder();
		while(i < n) {
			if(m.containsKey(i)) {
				int targetIndex = m.get(i);
				sb.append(targets[targetIndex]);
				i += sources[targetIndex].length();
			} else {
				sb.append(s.charAt(i));
				i++;
			}
		}
		
		return sb.toString();
		
	}

}
