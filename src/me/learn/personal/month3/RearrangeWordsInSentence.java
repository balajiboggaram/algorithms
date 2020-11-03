/**
 * 
 */
package me.learn.personal.month3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Title 1451 : Given a sentence text (A sentence is a string of space-separated
 * words) in the following format:
 * 
 * First letter is in upper case. Each word in text are separated by a single
 * space.
 * 
 * Your task is to rearrange the words in text such that all words are
 * rearranged in an increasing order of their lengths. If two words have the
 * same length, arrange them in their original order.
 * 
 * Return the new text following the format shown above.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: text = "Leetcode is cool" Output: "Is cool leetcode" Explanation:
 * There are 3 words, "Leetcode" of length 8, "is" of length 2 and "cool" of
 * length 4. Output is ordered by length and the new first word starts with
 * capital letter.
 * 
 * Example 2:
 * 
 * Input: text = "Keep calm and code on" Output: "On and keep calm code"
 * Explanation: Output is ordered as follows: "On" 2 letters. "and" 3 letters.
 * "keep" 4 letters in case of tie order by position in original text. "calm" 4
 * letters. "code" 4 letters.
 * 
 * 
 * 
 * @author bramanarayan
 * @date Jul 14, 2020
 */
public class RearrangeWordsInSentence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RearrangeWordsInSentence solution = new RearrangeWordsInSentence();
		System.out.println(solution.arrangeWords("Leetcode is Cool"));
		System.out.println(solution.arrangeWords("Keep calm and code on"));
	}

	// split based on length.
	public String arrangeWords(String text) {
		Map<Integer, List<String>> m = new TreeMap<Integer, List<String>>();
		String[] tokens = text.split("\\s+");

		// Prepare a map of count -> strings
		for (String s : tokens) {
			int length = s.length();
			if (m.containsKey(length)) {
				m.get(length).add(s);
			} else {
				List<String> list = new ArrayList<String>();
				list.add(s);
				m.put(length, list);
			}
		}

		// Now iterate the map based on length. its already sorted cos of TreeMap
		StringBuilder sb = new StringBuilder();
		m.entrySet().forEach(x -> {
			for (String s : x.getValue()) {
				sb.append(s.toLowerCase() + " ");
			}
		});

		
		// The first letterneed to be upper case..so...
		char first = sb.charAt(0);
		sb.setCharAt(0, Character.toUpperCase(first));

		return sb.toString().trim();

	}

}
