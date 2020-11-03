package me.learn.personal.monthlychallenge.may;

/**
 * 
 * Title : Given an arbitrary ransom note string and another string containing
 * letters from all the magazines, write a function that will return true if the
 * ransom note can be constructed from the magazines ; otherwise, it will return
 * false.
 * 
 * Each letter in the magazine string can only be used once in your ransom note.
 * 
 * @author bramanarayan
 * @date May 3, 2020
 */
public class RansomNote {

	public static void main(String args[]) {
		RansomNote solution = new RansomNote();
		solution.canConstruct("a", "b");
		solution.canConstruct("aa", "ab");
		solution.canConstruct("aa", "aab");

	}

	public boolean canConstruct(String ransomNote, String magazine) {
		int[] count = new int[26];
		boolean result = true;
		if (ransomNote == null || magazine == null)
			return false;

		// Calculate the ransom counts
		for (char c : ransomNote.toCharArray()) {
			int value = c - 'a';
			count[value] = count[value] + 1;

		}
		// Decrement the ransom count based on the magazine
		for (char c : magazine.toCharArray()) {
			int value = c - 'a';
			count[value] = count[value] - 1;
		}

		// Validate if all the counts are zero
		for (int i = 0; i < 26; i++) {
			if (count[i] > 0) {
				result = false;
				break;
			}
		}
		System.out.println("Result : " + result);
		return result;
	}
}
