/**
 * 
 */
package me.learn.personal.month4;

import java.util.Stack;

/**
 * Title 394 :
 * 
 * Given an encoded string, return its decoded string.
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the
 * square brackets is being repeated exactly k times. Note that k is guaranteed
 * to be a positive integer.
 * 
 * You may assume that the input string is always valid; No extra white spaces,
 * square brackets are well-formed, etc.
 * 
 * Furthermore, you may assume that the original data does not contain any
 * digits and that digits are only for those repeat numbers, k. For example,
 * there won't be input like 3a or 2[4].
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "3[a]2[bc]" Output: "aaabcbc"
 * 
 * Example 2:
 * 
 * Input: s = "3[a2[c]]" Output: "accaccacc"
 * 
 * Example 3:
 * 
 * Input: s = "2[abc]3[cd]ef" Output: "abcabccdcdcdef"
 * 
 * Example 4:
 * 
 * Input: s = "abc3[cd]xyz" Output: "abccdcdcdxyz"
 * 
 * 
 * @author bramanarayan
 * @date Jul 29, 2020
 */
public class DecodeString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

			DecodeString solution = new DecodeString();
			System.out.println(solution.decodeString("3[a]2[bc]"));
	}

	// Below uses one stack only. 
	// You can solve clutter free using 2 stacks , though 
	public String decodeString(String s) {

		Stack<String> st = new Stack<String>();

		int n = s.length();
		for (int i = 0; i < n; i++) {

			char ch = s.charAt(i);

			// DIGIT DECODING
			if (Character.isDigit(ch)) {
				// read all the number of times of repeat
				int j = i;
				StringBuilder sb = new StringBuilder();
				while (j < n && Character.isDigit(s.charAt(j))) {
					sb.append(s.charAt(j));
					j++;
				}
				i = j-1;
				st.push(sb.toString());
			} else if (ch == '[') {
				st.push(String.valueOf(ch));
			} else if (ch == ']') {
				StringBuilder sb = new StringBuilder();
				while (!st.isEmpty() && !st.peek().equals("[")) {
					sb.append(st.pop());
				}
				st.pop(); // this pops ]
				if (st.peek().matches("\\d+")) {
					String temp = sb.toString();
					int count = Integer.parseInt(st.pop());
					// repeat string n times
					for (int k = 1; k < count; k++) {
						sb.append(temp);
					}
					st.push(sb.toString());
				} else {
					st.push(sb.toString());
				}

			} else {
				// single character
				st.push(String.valueOf(ch));
			}
		}
		
		// prepare output
		StringBuilder resultBuilder = new StringBuilder();
		while(!st.isEmpty()) {
			resultBuilder.append(st.pop());
		}
		return resultBuilder.reverse().toString();
		

	}

}
