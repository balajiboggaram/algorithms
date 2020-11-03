package me.learn.personal.month1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Title : Print all the valid compbinations of a number entered on a phone
 * keypad
 * 
 * @author bramanarayan
 * @date Apr 28, 2020
 */
public class PrintPhoneLetterCombination {

	public static void main(String args[]) {
		
		PrintPhoneLetterCombination solution = new PrintPhoneLetterCombination();
		solution.letterCombinations("23");
		solution.letterCombinations("234");

	}

	public List<String> letterCombinations(String digits) {
		List<String> resultSet = new ArrayList<String>();

		if (digits == null)
			return resultSet;
		if (digits.length() == 0)
			return resultSet;

		Map<Integer, String> valueMap = new HashMap<Integer, String>();
		valueMap.put(2, "abc");
		valueMap.put(3, "def");
		valueMap.put(4, "ghi");
		valueMap.put(5, "jkl");
		valueMap.put(6, "mno");
		valueMap.put(7, "pqrs");
		valueMap.put(8, "tuv");
		valueMap.put(9, "wxyz");

		int n = digits.length();
		char[] result = new char[n];
		printLetters(digits, n, valueMap, 0, result, resultSet);
		System.out.println(Arrays.asList(resultSet));
		return resultSet;

	}

	private void printLetters(String digits, int n, Map<Integer, String> valueMap, int pos, char[] result, List<String> resultSet) {

		if (pos == n) {			
			resultSet.add(new String(result));
			result[pos - 1] = '\u0000'; // remove the last character for future combinations
			return;
		}
		
		int target = digits.charAt(pos) - '0';
		String value = valueMap.get(target);
		int combLength = value.length();

		for (int i = 0; i < combLength; i++) {
			result[pos] = value.charAt(i);
			printLetters(digits, n , valueMap, pos+1, result, resultSet);
		}
	}

}
