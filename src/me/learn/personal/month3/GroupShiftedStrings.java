/**
 * 
 */
package me.learn.personal.month3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title 249 :
 * 
 * Given a string, we can "shift" each of its letter to its successive letter,
 * for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
 * 
 * "abc" -> "bcd" -> ... -> "xyz"
 * 
 * Given a list of non-empty strings which contains only lowercase alphabets,
 * group all strings that belong to the same shifting sequence.
 * 
 * Example:
 * 
 * Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], Output: [
 * ["abc","bcd","xyz"], ["az","ba"], ["acef"], ["a","z"] ]
 * 
 * @author bramanarayan
 * @date Jul 14, 2020
 */
public class GroupShiftedStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GroupShiftedStrings solution = new GroupShiftedStrings();
		System.out.println(solution.groupStrings(new String[] {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"}));
		
	}

	public List<List<String>> groupStrings(String[] strings) {

		List<List<String>> result = new ArrayList<List<String>>();
		Map<String, List<String>> m = new HashMap<String, List<String>>();

		for (String s : strings) {
			String key = computeKey(s);
			if (m.containsKey(key)) {
				m.get(key).add(s);
			} else {
				List<String> temp = new ArrayList<String>();
				temp.add(s);
				m.put(key, temp);
			}
		}

		result.addAll(m.values());
		return result;
	}

	private String computeKey(String s) {
		int n = s.length();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < n; i++) {
			int diff = (s.charAt(i) - '0') - (s.charAt(i - 1) - '0');
			if(diff < 0) {
				diff = diff + 26;
			}
			sb.append(String.valueOf(diff));
		}
		return sb.toString();
	}

}
