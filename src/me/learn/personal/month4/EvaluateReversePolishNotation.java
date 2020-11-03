/**
 * 
 */
package me.learn.personal.month4;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Title 150 :
 * 
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression.
 * 
 * Note:
 * 
 * Division between two integers should truncate toward zero. The given RPN
 * expression is always valid. That means the expression would always evaluate
 * to a result and there won't be any divide by zero operation.
 * 
 * Example 1:
 * 
 * Input: ["2", "1", "+", "3", "*"] Output: 9 Explanation: ((2 + 1) * 3) = 9
 * 
 * Example 2:
 * 
 * Input: ["4", "13", "5", "/", "+"] Output: 6 Explanation: (4 + (13 / 5)) = 6
 * 
 * Example 3:
 * 
 * Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * Output: 22 Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5 = ((10 * (6 /
 * (12 * -11))) + 17) + 5 = ((10 * (6 / -132)) + 17) + 5 = ((10 * 0) + 17) + 5 =
 * (0 + 17) + 5 = 17 + 5 = 22
 * 
 * 
 * 
 * @author bramanarayan
 * @date Jul 27, 2020
 */
public class EvaluateReversePolishNotation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EvaluateReversePolishNotation solution = new EvaluateReversePolishNotation();
		System.out.println(solution.evalRPN(new String[] {"4","13","5","/","+"}));
		System.out.println(solution.evalRPN(new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));

	}

	
	// The actual question in leet code expects an integer. 
	// so please have stack<Integer>
	public int evalRPN(String[] tokens) {
		int n = tokens.length;
		Set<String> symbols = new HashSet<String>();
		symbols.add("+");
		symbols.add("-");
		symbols.add("*");
		symbols.add("/");
		Stack<Double> st = new Stack<Double>();

		for (int i = 0; i < n; i++) {
			String temp = tokens[i];

			// its an operator
			if (symbols.contains(temp)) {
				Double x = st.pop();
				Double y = st.pop();
				Double result = 0.0;
				switch (temp) {
				case "+":
					result = x + y;
					break;
				case "-":
					result = y - x;
					break;
				case "*":
					result = x * y;
					break;
				case "/":
					result = y / x;
					break;
				default:
					break;
				}
				st.push(result);
			} else {
				st.push(Double.parseDouble(temp));
			}
			
		}
				
		int finalResult = (int) Math.round( (double) st.pop());
		if(!st.isEmpty()) {
			return -1;
		} else {
			return finalResult;
		}
	}
}
