/**
 * 
 */
package me.learn.personal.month5;

import java.util.Stack;

/**
 * Title 32 :
 * 
 * Date : Dec 23, 2020
 * 
 * @author bramanarayan
 *
 */
public class LongestValidParanthesis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		LongestValidParanthesis solution = new LongestValidParanthesis();
		System.out.println(solution.longestValidParentheses("()()"));
		System.out.println(solution.longestValidParentheses("(()())"));

	}

	// Basically, Maintain a stack. 
	// the left most indicies where you need to always keep track.
	public int longestValidParentheses(String s) {
		int n = s.length();
		Stack<Integer> st = new Stack<Integer>();
		st.push(-1);
		int result = 0;
		for(int i = 0;i<n;i++) {
			char ch = s.charAt(i);
			if(ch == '(') {
				st.push(i);
			} else if (ch == ')') {
				st.pop();
				if(!st.isEmpty()) {
					result = Math.max(result, i-st.peek());					
				} else {
					st.push(i);
				}
			}
		}
		return result;
	}

}
