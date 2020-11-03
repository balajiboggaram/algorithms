/**
 * 
 */
package me.learn.personal.month3;

import java.util.ArrayList;
import java.util.List;

/**
 * Title 816 :
 * 
 * We had some 2-dimensional coordinates, like "(1, 3)" or "(2, 0.5)". Then, we
 * removed all commas, decimal points, and spaces, and ended up with the string
 * S. Return a list of strings representing all possibilities for what our
 * original coordinates could have been.
 * 
 * Our original representation never had extraneous zeroes, so we never started
 * with numbers like "00", "0.0", "0.00", "1.0", "001", "00.01", or any other
 * number that can be represented with less digits. Also, a decimal point within
 * a number never occurs without at least one digit occuring before it, so we
 * never started with numbers like ".1".
 * 
 * The final answer list can be returned in any order. Also note that all
 * coordinates in the final answer have exactly one space between them
 * (occurring after the comma.)
 * 
 * Example 1: Input: "(123)" Output: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1,
 * 2.3)"]
 * 
 * Example 2: Input: "(00011)" Output: ["(0.001, 1)", "(0, 0.011)"] Explanation:
 * 0.0, 00, 0001 or 00.01 are not allowed.
 * 
 * 
 * @author bramanarayan
 * @date Jul 6, 2020
 */
public class AmbigiousCoordinates {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AmbigiousCoordinates solution = new AmbigiousCoordinates();
		System.out.println(solution.ambiguousCoordinates("123"));
	}

	public List<String> ambiguousCoordinates(String s) {
		int n = s.length();
		List<String> result = new ArrayList<String>();
		for (int i = 1; i < n; i++) {
			List<String> leftCandidates = getCandidates(s.substring(0, i));
			List<String> rightCandidates = getCandidates(s.substring(i));

			for (String left : leftCandidates) {
				for (String right : rightCandidates) {
					result.add( "(" + left + "," + right + ")");
				}
			}
		}
		return result;
	}

	private List<String> getCandidates(String s) {
		List<String> result = new ArrayList<String>();
		int n = s.length();
		char[] c = s.toCharArray();

		
		// "0xxxx0" is invalid unless its a single '0'
		if (c[0] == '0' && c[n - 1] == '0') {
			if (n == 1) {
				result.add("0");
			}
			return result; // empty list
		}

		// 0.xxxx
		if (c[0] == '0') {
			result.add("0" + "." + s.substring(0, n - 1));
			return result;
		}

		// xxxx0
		if (c[n - 1] == '0') {
			result.add(s);
			return result;
		}

		result.add(s);
		// rest of decimals here. start from 1 - as 0th digit would have taken care of already
		for (int i = 1; i < n; i++) {
			result.add(s.substring(0, i) + "." + s.substring(i));
		}

		return result;

	}

}
