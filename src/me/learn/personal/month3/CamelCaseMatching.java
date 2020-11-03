/**
 * 
 */
package me.learn.personal.month3;

import java.util.ArrayList;
import java.util.List;

/**
 * Title 1023 :
 * 
 * A query word matches a given pattern if we can insert lowercase letters to
 * the pattern word so that it equals the query. (We may insert each character
 * at any position, and may insert 0 characters.)
 * 
 * Given a list of queries, and a pattern, return an answer list of booleans,
 * where answer[i] is true if and only if queries[i] matches the pattern.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: queries =
 * ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern =
 * "FB" Output: [true,false,true,true,false] Explanation: "FooBar" can be
 * generated like this "F" + "oo" + "B" + "ar". "FootBall" can be generated like
 * this "F" + "oot" + "B" + "all". "FrameBuffer" can be generated like this "F"
 * + "rame" + "B" + "uffer".
 * 
 * Example 2:
 * 
 * Input: queries =
 * ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern =
 * "FoBa" Output: [true,false,true,false,false] Explanation: "FooBar" can be
 * generated like this "Fo" + "o" + "Ba" + "r". "FootBall" can be generated like
 * this "Fo" + "ot" + "Ba" + "ll".
 * 
 * 
 * 
 * @author bramanarayan
 * @date Jul 13, 2020
 */
public class CamelCaseMatching {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CamelCaseMatching solution = new CamelCaseMatching();
		System.out.println(solution.camelMatch(new String[] {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedback"}, "FB"));
	}

	// TWO POINTER - separate
	public List<Boolean> camelMatch(String[] queries, String pattern) {
		List<Boolean> result = new ArrayList<Boolean>();

		for (String query : queries) {
			result.add(isPattern(query, pattern));
		}
		return result;
	}

	// w - word
	// p - pattern
	private Boolean isPattern(String w, String p) {
		System.out.println(w + p);
		int n = w.length();
		int m = p.length();
		int j = 0;
		for (int i = 0; i < n; i++) {
			if(j < m && p.charAt(j) == w.charAt(i)) {
				j++;
			} else if(Character.isUpperCase(w.charAt(i))) {
				return false;
			}
			
			//if(j == m) return true;
		}
		
		return j == p.length();
	}

}
