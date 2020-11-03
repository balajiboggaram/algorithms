/**
 * 
 */
package me.learn.personal.month4;

/**
 * Title 1021 :
 * 
 * A valid parentheses string is either empty (""), "(" + A + ")", or A + B,
 * where A and B are valid parentheses strings, and + represents string
 * concatenation. For example, "", "()", "(())()", and "(()(()))" are all valid
 * parentheses strings.
 * 
 * A valid parentheses string S is primitive if it is nonempty, and there does
 * not exist a way to split it into S = A+B, with A and B nonempty valid
 * parentheses strings.
 * 
 * Given a valid parentheses string S, consider its primitive decomposition: S =
 * P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings.
 * 
 * Return S after removing the outermost parentheses of every primitive string
 * in the primitive decomposition of S.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: "(()())(())" Output: "()()()" Explanation: The input string is
 * "(()())(())", with primitive decomposition "(()())" + "(())". After removing
 * outer parentheses of each part, this is "()()" + "()" = "()()()".
 * 
 * 
 * @author bramanarayan
 * @date Jul 29, 2020
 */
public class RemoveOuterParanthesis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String removeOuterParentheses(String s) {
		
		int i =1, start =0,open =1;
		int n = s.length();
		StringBuilder sb = new StringBuilder();
		while(i < n) {
			char ch = s.charAt(i);
			if(ch == '(') 
				open++;
			else
				open--;
			
			if(open == 0) {
				sb.append(s.substring(start+1, i));
				start = i+1;
			}
			i++;
		}
		return sb.toString();
	}

}
