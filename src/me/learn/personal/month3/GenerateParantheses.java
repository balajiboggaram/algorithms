/**
 * 
 */
package me.learn.personal.month3;

import java.util.ArrayList;
import java.util.List;

/**
 * Title 22 :
 * 
 *   Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

 * 
 * @author bramanarayan
 * @date Jun 26, 2020
 */
public class GenerateParantheses {

	List<String> result = new ArrayList<String>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GenerateParantheses solution = new GenerateParantheses();
		System.out.println(solution.generateParenthesis(3));
	}

	
	// RECURSION
	public List<String> generateParenthesis(int n) {
		char[] s = new char[2 * n];

		generateUtil(0, 0, 0, n, s);
		return result;
	}

	public void generateUtil(int open, int close, int pos, int n, char[] s) {
		if (close == n) {
			result.add(new String(s));
		}

		if (open < n) {
			s[pos] = '(';
			generateUtil(open + 1, close, pos + 1, n, s);
		}

		if (open > close) {
			s[pos] = ')';
			generateUtil(open, close + 1, pos + 1, n, s);
		}

	}

}
