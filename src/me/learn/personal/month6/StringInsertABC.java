/**
 * 
 */
package me.learn.personal.month6;

import java.util.Stack;

/**
 * Title :
 * 
 * Date : Feb 6, 2021
 * 
 * @author bramanarayan
 *
 */
public class StringInsertABC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringInsertABC solution = new StringInsertABC();
		System.out.println(solution.isValid("abccba"));

	}

	// Problem facer - home maker
	public boolean isValid(String s) {

		if (s == null)
			return true;

		int n = s.length();
		if (n == 0)
			return true;

		Stack<Character> st = new Stack<Character>();

		for (int i = 0; i < n; i++) {
			char ch = s.charAt(i);
			st.push(ch);
			while(!st.isEmpty() && st.peek() == 'c' && st.size() > 2) {
				
				char ch1 = st.pop();
				char ch2 = st.pop();
				char ch3 = st.pop();
				
				if(ch1 != 'c' || ch2 != 'b' || ch3 != 'a') {
					st.push(ch3);
					st.push(ch2);
					st.push(ch1);
					break;
				}
				
			}
			
		}

		return st.isEmpty();

	}

}
