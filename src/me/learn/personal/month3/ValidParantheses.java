/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title 678 :
 * 
 * Given a string containing only three types of characters: '(', ')' and '*',
 * write a function to check whether this string is valid. We define the
 * validity of a string by these rules:
 * 
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'. Any
 * right parenthesis ')' must have a corresponding left parenthesis '('. Left
 * parenthesis '(' must go before the corresponding right parenthesis ')'. '*'
 * could be treated as a single right parenthesis ')' or a single left
 * parenthesis '(' or an empty string. An empty string is also valid.
 * 
 * Example 1:
 * 
 * Input: "()" Output: True
 * 
 * Example 2:
 * 
 * Input: "(*)" Output: True
 * 
 * Example 3:
 * 
 * Input: "(*))"
 * 
 * @author bramanarayan
 * @date Jul 2, 2020
 */
public class ValidParantheses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ValidParantheses solution = new ValidParantheses();
		System.out.println(solution.checkValidString("(*)"));
		System.out.println(solution.checkValidString("()"));
		System.out.println(solution.checkValidString("()*"));

	}

	// step 1: You need to count the number of open braces ( left to right )
	// step 2 : You need to count the number of closed branches (right to left)
	// When you do the above cases - at any point of time
	// open - leftBalance
	// close - rightBalance
	public boolean checkValidString(String s) {

		int n = s.length();

		// left to right - count the open braces
		int open = 0;
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '*') {
				open++;
			} else {
				open--;
			}

			if (open < 0)
				return false;
		}

		if (open == 0)
			return true; // no need to check right here.
		// ^ there are equal number of open and closed braces.

		// right to left - count the close braces
		int close = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (s.charAt(i) == ')' || s.charAt(i) == '*') {
				close++;
			} else {
				close--;
			}

			if (close < 0)
				return false;
		}

		// Here we know we have never been unbalanced parsing from left to right e.g.
		// ')('
		// We've also already substituted '*' either by '(' or by ')'
		// So we only have 3 possible scenarios here:
		// 1. We had the same amount of '(' and ')'
		// 2. We had more '(' then ')' but enough '*' to substitute
		// 3. We had more ')' then '(' but enough '*' to substitute

		return true;
	}

}
