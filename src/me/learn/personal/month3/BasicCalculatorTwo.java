/**
 * 
 */
package me.learn.personal.month3;

import java.util.Stack;

/**
 * Title 227 :
 * 
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string contains only non-negative integers, +, -, *, /
 * operators and empty spaces . The integer division should truncate toward
 * zero.
 * 
 * Example 1:
 * 
 * Input: "3+2*2" Output: 7
 * 
 * Example 2:
 * 
 * Input: " 3/2 " Output: 1
 * 
 * Example 3:
 * 
 * Input: " 3+5 / 2 " Output: 5
 * 
 * 
 * @author bramanarayan
 * @date Jul 19, 2020
 */
public class BasicCalculatorTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BasicCalculatorTwo solution = new BasicCalculatorTwo();
		System.out.println(solution.calculate("2+3*5"));
		System.out.println(solution.calculate("2+3-5"));
		System.out.println(solution.calculate("2-3*5*4"));

	}

	public int calculate(String s) {
		if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        s += '+';
        char op = '+';
        for (int i = 0, n = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') { n = n * 10 + c - '0'; continue; }
            if (c == ' ') continue;
            if (op == '+') stack.push(n);
            else if (op == '-') stack.push(-n);
            else if (op == '*') stack.push(stack.pop()*n);
            else if (op == '/') stack.push(stack.pop()/n);
            op = c;
            n = 0;
        }

        int total = 0;
        while (!stack.isEmpty()) total += stack.pop();
        return total;
	}

}
