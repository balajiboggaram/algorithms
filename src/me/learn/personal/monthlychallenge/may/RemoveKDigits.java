
package me.learn.personal.monthlychallenge.may;

import java.util.Stack;

/**
 * Title : Given a non-negative integer num represented as a string, remove k
 * digits from the number so that the new number is the smallest possible.
 * 
 * Note:
 * 
 * The length of num is less than 10002 and will be ≥ k. The given num does not
 * contain any leading zero.
 * 
 * 
 * @author bramanarayan
 * @date May 13, 2020
 */
public class RemoveKDigits {

	public static void main(String[] args) {
		RemoveKDigits solution = new RemoveKDigits();
		System.out.println(solution.removeKdigits("1432219", 3));
		System.out.println(solution.removeKdigits("4325043", 3));
		System.out.println(solution.removeKdigits("5337", 2));
		System.out.println(solution.removeKdigits("10200", 1));
		System.out.println(solution.removeKdigits("10", 1));
		System.out.println(solution.removeKdigits("100", 1));

	}

	public String removeKdigits(String num, int k) {

		if (num == null || num.length() <= k)
			return "0";
		StringBuilder result = new StringBuilder();
		Stack<Integer> s = new Stack<Integer>();
		s.push(num.charAt(0) - '0');
		int count = k;
		for (int i = 1; i < num.length(); i++) {
			int value = num.charAt(i) - '0';
			if (count > 0 && !s.isEmpty() && s.peek() > value) {
				s.pop();
				count--;
			}
			s.push(value);
		}

		// remove the stack top if we have not remove enough 'k' number of elements
		for (int i = count; i > 0; i--) {
			s.pop();
		}

		// Return the reverse of stack contents here
		while (!s.isEmpty()) {
			result.append(s.pop());
		}

		String finalResult = result.reverse().toString();

		int i = 0;
		int n = finalResult.length();
		while (i < n && finalResult.charAt(i) == '0') {
			i++;
		}

		return i == n ? "0" : finalResult.substring(i, n - i );
	}
}
