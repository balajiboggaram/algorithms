package me.learn.personal.month1;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Title : Given a string S, we can transform every letter individually to be
 * lowercase or uppercase to create another string. Return a list of all
 * possible strings we could create.
 * 
 * @author bramanarayan
 * @date May 13, 2020
 */
public class LetterCasePermutation {

	List<String> result = new ArrayList<>();

	public static void main(String args[]) {
		LetterCasePermutation solution = new LetterCasePermutation();
		solution.permute("a1b2".toCharArray(), 0, 4);
		solution.permute("C".toCharArray(), 0, 1);

	}

	public List<String> letterCasePermutation(String s) {
		if (s == null)
			return null;
		permute(s.toCharArray(), 0, s.length());
		return result;
	}

	// try to replace always with a uppercase letter
	// Try to replace again with a lowercase letter
	// if its number, just skip two versions of replace.
	public void permute(char[] input, int i, int n) {
		if (i == n) {
			System.out.println(input);
			result.add(new String(input));
		} else {
			// To split the input
			if (Character.isLetter(input[i])) {
				input[i] = Character.toUpperCase(input[i]);
				permute(input, i + 1, n); // to take care of upper case
				input[i] = Character.toLowerCase(input[i]);
			}
			permute(input, i + 1, n); // common for lower case and number
		}
	}

}
