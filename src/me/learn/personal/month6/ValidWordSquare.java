/**
 * 
 */
package me.learn.personal.month6;

import java.util.Arrays;
import java.util.List;

/**
 * Title 422 :
 * 
 * Date : Jan 14, 2021
 * 
 * @author bramanarayan
 *
 */
public class ValidWordSquare {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ValidWordSquare solution = new ValidWordSquare();
		System.out.println(solution.validWordSquare(Arrays.asList("abcd", "bnrt", "crm", "dt")));
	}

	// both the row and column has same word. then its a valid word square

	public boolean validWordSquare(List<String> words) {

		if (words == null || words.size() == 0)
			return true;
		int m = words.size();

		int n = words.get(0).length();

		for (int j = 0; j < n; j++) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < m; i++) {
				if (j < words.get(i).length()) {
					char ch = words.get(i).charAt(j);
					sb.append(ch);
				}

			}
			System.out.println(sb.toString());
			if (!sb.toString().equals(words.get(j)))
				return false;
		}

		return true;
	}

	// OR

	// BEST
	public boolean validWordSquareBEST(List<String> words) {

		for (int i = 0; i < words.size(); i++) {
			char[] sc = words.get(i).toCharArray();
			for (int j = 0; j < sc.length; j++) {
				if (j >= words.size() || i >= words.get(j).length())
					return false;
				if (sc[j] != words.get(j).charAt(i))
					return false;
			}
		}

		return true;
	}

}
