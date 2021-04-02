/**
 * 
 */
package me.learn.personal.month7;

import java.util.ArrayList;
import java.util.List;

/**
 * Title 282 :
 * 
 * Date : Feb 26, 2021
 * 
 * @author bramanarayan
 *
 */
// Service now question
public class ExpressionEvaluationInsertOperators {

	// Input: num = "123", target = 6
	// Output: ["1+2+3", "1*2*3"]

	public List<String> addOperators(String num, int target) {

		List<String> res = new ArrayList<>();

		StringBuilder sb = new StringBuilder();

		dfs(res, sb, num, 0, target, 0, 0);

		return res;

	}

	// prev -> evaluated result until the previous number
	//
	public void dfs(List<String> res, StringBuilder sb, String num, int pos, int target, long prev, long multi) {

		if (pos == num.length()) {
			if (target == prev)
				res.add(sb.toString());
			return;
		}

		// 1234 -> 1 + 2 + 3 + 4 ,1 + 2 + 34, 1 + 234, 1 + 23 + 4,
		for (int i = pos; i < num.length(); i++) {

			if (num.charAt(pos) == '0' && i != pos)
				break;

			long CurrNumber = Long.parseLong(num.substring(pos, i + 1));

			int len = sb.length();

			if (pos == 0) {
				// for the first number, just add it to StringBuilder
				dfs(res, sb.append(CurrNumber), num, i + 1, target, CurrNumber, CurrNumber);
				sb.setLength(len);
			} else {

				dfs(res, sb.append("+").append(CurrNumber), num, i + 1, target, prev + CurrNumber, CurrNumber);
				sb.setLength(len);

				dfs(res, sb.append("-").append(CurrNumber), num, i + 1, target, prev - CurrNumber, -CurrNumber);
				sb.setLength(len);

				dfs(res, sb.append("*").append(CurrNumber), num, i + 1, target, prev - multi + multi * CurrNumber,
						multi * CurrNumber);
				sb.setLength(len);
			}

		}
	}

	// or BEST

	public List<String> addOperatorsBEST(String num, int target) {

		char[] digits = num.toCharArray();
		char[] equation = new char[num.length() * 2]; // the equation

		List<String> result = new ArrayList<>();

		long number = 0;

		for (int i = 0; i < digits.length; i++) {

			number = number * 10 + (digits[i] - '0');

			equation[i] = digits[i];
			
			     // digitIndex, eqIn, left, current, equation[], digits, target, result
			helperAddOp(i + 1, i + 1, 0, number,   equation, digits, target, result);

			if (number == 0)
				break;

		}
		return result;
	}

	 
	private void helperAddOp(int digitsIndex, int equationIndex, long left, long current, char[] equation, char[] digits, int target, List<String> result) {

		// System.out.println(Arrays.toString(equation));

		// end of the digits, and target = left + current; we got it.
		if (digitsIndex == digits.length && left + current == target) {
			result.add(String.valueOf(equation, 0, equationIndex));
			return;
		}
		
		
		long number = 0;
		int signIndex = equationIndex;
		equationIndex++;
		
		for (int i = digitsIndex; i < digits.length; i++) {
		
			// basically assigning the digit to equation now
			equation[equationIndex] = digits[i];
			
			// increment equation index
			equationIndex++;
			
			// 
			number = number * 10 + (digits[i] - '0');
			
			equation[signIndex] = '+';
			helperAddOp(i + 1, equationIndex, left + current, number, equation, digits, target, result);
			
			equation[signIndex] = '-';
			helperAddOp(i + 1, equationIndex, left + current, -number, equation, digits, target, result);
			
			equation[signIndex] = '*';
			helperAddOp(i + 1, equationIndex, left, number * current, equation, digits, target, result);
			
			if (number == 0)
				break;
		}
	}

}
