/**
 * 
 */
package me.learn.personal.month3;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Title 20 :
 * 
 *  Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.

Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true

Example 2:

Input: "()[]{}"
Output: true

 * 
 * @author bramanarayan
 * @date Jun 26, 2020
 */
public class ValidParanthesis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ValidParanthesis solution = new ValidParanthesis();
		System.out.println(solution.isValid("()[]{}"));
		System.out.println(solution.isValid("()[]{"));
		System.out.println(solution.isValid("(]"));
		System.out.println(solution.isValid("[])"));

	}

	public boolean isValid(String s) {
		
		if(s == null) return true;
		int n = s.length();
		
		if(n ==0) return true;
		Stack<Character> st = new Stack<Character>();

		st.push(s.charAt(0));

		List<Character> open = Arrays.asList('(', '{', '[');

		for (int i = 1; i < n; i++) {

			char t = s.charAt(i);

			if (open.contains(t)) {
				st.push(t);
			} else {
				if (st.isEmpty() || (t == ')' && st.peek() != '(') || (t == '}' && st.peek() != '{')
						|| (t == ']' && st.peek() != '[')) {
					return false;
				}
				
				if(!st.isEmpty() )
					st.pop();
			}

		}
		return st.isEmpty();
	}

}
