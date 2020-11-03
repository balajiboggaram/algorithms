/**
 * 
 */
package me.learn.personal.month3;

import java.util.Stack;

/**
 * Title 856 : 
 *  
 *  Given a balanced parentheses string S, compute the score of the string based on the following rule:

    () has score 1
    AB has score A + B, where A and B are balanced parentheses strings.
    (A) has score 2 * A, where A is a balanced parentheses string.

Example 1:

Input: "()"
Output: 1

Example 2:

Input: "(())"
Output: 2

Example 3:

Input: "()()"
Output: 2

Example 4:

Input: "(()(()))"
Output: 6

 * 
 * @author bramanarayan
 * @date Jun 29, 2020
 */
public class ScoreOfParantheses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ScoreOfParantheses solution = new ScoreOfParantheses();
		System.out.println(solution.scoreOfParentheses("()"));
		System.out.println(solution.scoreOfParentheses("(())"));

	}

	// USE STACKS 
	public int scoreOfParentheses(String s) {
		
		int cur = 0;
		int n = s.length();
		Stack<Integer> st = new Stack<Integer>();
		for(int i = 0;i<n;i++) {
			if(s.charAt(i) == '(') {
				// a new depth has started so - make cur to zero
				st.push(cur);
				cur = 0;
			} else {
				// if its a closing brace, then just pop
				cur = st.pop() + Math.max(cur * 2, 1); // CATCH
			}
		}
		return cur;
	}

}
