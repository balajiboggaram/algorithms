package me.learn.personal.month1;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Title : Convert the Roman Numeral to Integer.
 * 
 * The Roman numeral is always in the range from 0 to 3999
 * 
 * @author bramanarayan
 * @date Apr 27, 2020
 */
public class RomanToInt {

	public static void main(String[] args) {
		RomanToInt solution = new RomanToInt();
		solution.romanToInt("LX");
		solution.romanToInt("LXI");
		solution.romanToInt("XXVII");
		solution.romanToInt("MMCCCXXXXII");
		solution.romanToInt("");
		solution.romanToInt(null);
	}

	public int romanToInt(String s) {
		Map<Character, Integer> valueMap = new HashMap<Character, Integer>();
		valueMap.put('I', 1);
		valueMap.put('V', 5);
		valueMap.put('X', 10);
		valueMap.put('L', 50);
		valueMap.put('C', 100);
		valueMap.put('D', 500);
		valueMap.put('M', 1000);

		if (s == null)
			return 0;
		if (s.length() == 0)
			return 0;

		int result = 0, i = 0;

		if (s.length() == 1)
			return valueMap.get(s.charAt(0));

		while (i + 1 < s.length()) {

			int currentVal = valueMap.get(s.charAt(i));
			int nextVal = valueMap.get(s.charAt(i + 1));

			if (currentVal < nextVal) {
				result += (nextVal - currentVal);
				i = i + 2;
			} else {
				result += currentVal;
				i = i + 1;
			}
		}
		if (i == s.length() - 1) {
			result += valueMap.get(s.charAt(i));
		}
		System.out.println(String.format("The value for %s is %d", s, result));
		return result;

	}

}
