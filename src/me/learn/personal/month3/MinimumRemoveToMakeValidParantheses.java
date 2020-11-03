/**
 * 
 */
package me.learn.personal.month3;

import java.util.Stack;

/**
 * Title : 
 * 
 * @author bramanarayan
 * @date Jun 26, 2020
 */
public class MinimumRemoveToMakeValidParantheses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MinimumRemoveToMakeValidParantheses solution = new MinimumRemoveToMakeValidParantheses();
		System.out.println(solution.minRemoveToMakeValid("lee(t(c)o)de)"));
		System.out.println(solution.minRemoveToMakeValid("a)b(c)d"));
		System.out.println(solution.minRemoveToMakeValid("(a(b(c)d)"));

	}

	public String minRemoveToMakeValid(String s) {

		Stack<Integer> open = new Stack<Integer>();
		Stack<Integer> close = new Stack<Integer>();

		for (int i = 0; i < s.length(); i++) {
			
			char t = s.charAt(i);
			if (t == '(') {
				open.push(i);
			} else if (t == ')') {

				// if open exists then pop the open as it will be matching.
				if (!open.isEmpty()) {
					open.pop();
				} else {
					close.push(i);
				}

			}
		}
		
		// remove any open or close. 
		while(!open.isEmpty()) {
			s = new StringBuilder(s).deleteCharAt(open.pop()).toString();
		}
		
		while(!close.isEmpty()) {
			s = new StringBuilder(s).deleteCharAt(close.pop()).toString();
		}
		
		return s;
		
	}

}
