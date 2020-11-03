/**
 * 
 */
package me.learn.personal.month3;

import java.util.ArrayList;
import java.util.List;

/**
 * Title 43 :
 * 
 * Given two non-negative integers num1 and num2 represented as strings, return
 * the product of num1 and num2, also represented as a string.
 * 
 * Example 1:
 * 
 * Input: num1 = "2", num2 = "3" Output: "6"
 * 
 * Example 2:
 * 
 * Input: num1 = "123", num2 = "456" Output: "56088"
 * 
 * 
 * @author bramanarayan
 * @date Jun 29, 2020
 */
public class MultiplyStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MultiplyStrings solution = new MultiplyStrings();
		// System.out.println(solution.multiply("2", "3"));
		System.out.println(solution.multiply("123", "456"));

	}

	// THIS IS A SHITTY PROBLEM FOR INTERVIEWS
	public String multiply(String n1, String n2) {

		char c1[] = n1.toCharArray();
		char c2[] = n2.toCharArray();

		int m = c1.length;
		int n = c2.length;

		List<List<Integer>> candidates = new ArrayList<List<Integer>>();
		int level = -1;
		int maxDigits = 0;

		// take the right number digit,
		for (int i = n - 1; i >= 0; i--) {

			level++;
			List<Integer> list = new ArrayList<Integer>();

			// Add level times - the zero
			addZeros(list, level);

			int s = 0, c = 0;

			for (int j = m - 1; j >= 0; j--) {
				s = Integer.valueOf(c2[i] - '0') * Integer.valueOf(c1[j] - '0') + c;
				list.add(s % 10);
				c = s / 10;
			}

			if (c > 0) {
				list.add(c);
			}

			candidates.add(list);
			maxDigits = Math.max(maxDigits, list.size());
		}

		// Perform addition and then keep appending to string builder
		StringBuilder sb = new StringBuilder();
		int sum = 0, carry = 0;
		for (int i = 0; i < maxDigits; i++) {
			sum =0;
			for (int j = 0; j < candidates.size(); j++) {
				if(i < candidates.get(j).size()) {
					sum += candidates.get(j).get(i) == null ? 0 : candidates.get(j).get(i);
				} 
			}
			sum += carry;
			sb.append(sum % 10);
			carry = sum / 10;

		}
		sb.append(carry);

		return sb.reverse().toString().replaceFirst("^0+(?!$)", "");

	}

	private void addZeros(List<Integer> list, int level) {

		for (int i = 0; i < level; i++) {
			list.add(0);
		}
	}

}
