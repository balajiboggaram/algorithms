package me.learn.personal.month2;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Title 1002 : Given an array A of strings made only from lowercase letters,
 * return a list of all characters that show up in all strings within the list
 * (including duplicates). For example, if a character occurs 3 times in all
 * strings but not 4 times, you need to include that character three times in
 * the final answer.
 * 
 * You may return the answer in any order.
 * 
 * Example 1:
 * 
 * Input: ["bella","label","roller"] Output: ["e","l","l"]
 * 
 * Example 2:
 * 
 * Input: ["cool","lock","cook"] Output: ["c","o"]
 * 
 * 
 * @author bramanarayan
 * @date May 29, 2020
 */
public class FindCommonCharacters {

	public static void main(String args[]) {

	}

	public List<String> commonChars(String[] A) {
		List<String> ans = new ArrayList<>();
		
		// Common characters dictionary
		int[] dict = new int[26];
		for (int j = 0; j < A[0].length(); j++) {
			dict[A[0].charAt(j) - 'a']++;
		}
		
		for (int i = 1; i < A.length; i++) {
		
			// Dictionary of the current word
			int[] curr = new int[26];
			for (int j = 0; j < A[i].length(); j++) {
				curr[A[i].charAt(j) - 'a']++;
			}
			
			// Update the common dictionary
			// You need to choose the less # of characters here.
			for (int j = 0; j < 26; j++) {
				dict[j] = Math.min(dict[j], curr[j]);
			}
		}
		for (int i = 0; i < 26; i++) {
			// Add the same character dict[i] times
			for (int j = 0; j < dict[i]; j++) {
				ans.add(Character.toString((char) ('a' + i)));
			}
		}
		return ans;
	}

}
