package me.learn.personal.month4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * Title 336 :
 * 
 * Given a list of unique words, find all pairs of distinct indices (i, j) in
 * the given list, so that the concatenation of the two words, i.e. words[i] +
 * words[j] is a palindrome.
 * 
 * Example 1:
 * 
 * Input: ["abcd","dcba","lls","s","sssll"] Output: [[0,1],[1,0],[3,2],[2,4]]
 * Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
 * 
 * Example 2:
 * 
 * Input: ["bat","tab","cat"] Output: [[0,1],[1,0]] Explanation: The palindromes
 * are ["battab","tabbat"]
 * 
 * 
 * 
 * @author bramanarayan
 * @date Aug 21, 2020
 */
public class PalindromePairs {

	public static void 	main(String args[]) {
		PalindromePairs solution = new PalindromePairs();
		System.out.println(solution.palindromePairs(new String[] {"race","car"}));
		System.out.println(solution.palindromePairs(new String[] {"abcd","dcba","lls","s","sssll"}));

	}
	
	// REPEAT
	public List<List<String>> palindromePairs(String[] words) {
		// REVERSE WORDS
		Set<String> reversedWords = new HashSet<>();
		for(String w : words) {
			reversedWords.add(new StringBuilder(w).reverse().toString());
		}
		
		// NOW FIND PALIN BASED ON REVERSE WORDS
		List<List<String>> result = new ArrayList<List<String>>();
		for(String w : words) {
			Set<String> palindromePairs = findPalindromeHelper(w, reversedWords);
			result.add(new ArrayList<>(palindromePairs));
		}
		return result;
	}

	private Set<String> findPalindromeHelper(String w, Set<String> reversedWords) {
		
		Set<String> palindromes = new HashSet<>();
		
		// if same length word already exists
		if(reversedWords.contains(w)) {
			String reversedWord = new StringBuilder(w).reverse().toString();
			if(!reversedWord.equals(w)) {
				// it cannot be the same word. malayalam - we need a pairing to each other, hence this condition
				palindromes.add(w + reversedWord);
			}
		}
		
		// check if we can form a palindrome by concating two words with different length by appending the other
		// word to the back of the given word.
		for (int i = 1; i < w.length() - 1; i++) {
			String takenOutString = w.substring(w.length() - 1); // right side
			String remainingString = w.substring(0, w.length() - i); // left side

			if (isPalindrome(takenOutString) && reversedWords.contains(remainingString)) {
				String palindrome = remainingString + takenOutString
						+  new StringBuilder(remainingString).reverse().toString();
				palindromes.add(palindrome);
			}

		}		
		
		// check if we can form a palindrome by concatenating two words 
		// with different length by appending the other word to the front of given word
		for(int i =1;i< w.length()-1;i++) {
			String takenOutStr = w.substring(0,i);
			String remainingStr  = w.substring(i);
			if (isPalindrome(takenOutStr) && reversedWords.contains(remainingStr)) {
		        String palindrome =
		                new StringBuilder(remainingStr).reverse().toString() + takenOutStr + remainingStr;
		        palindromes.add(palindrome);
		      }
		}

		return palindromes;
	}

	private boolean isPalindrome(String string) {
		int left = 0;
	    int right = string.length() - 1;
	    while (left < right) {
	      if (string.charAt(left) != string.charAt(right)) {
	        return false;
	      }

	      left++;
	      right--;
	    }

	    return true;
	}

}
