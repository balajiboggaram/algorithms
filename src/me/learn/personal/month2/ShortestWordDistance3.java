package me.learn.personal.month2;

/**
 * 
 * Title 245 : Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

word1 and word2 may be the same and they represent two individual words in the list.

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “makes”, word2 = “coding”
Output: 1

Input: word1 = "makes", word2 = "makes"
Output: 3

Note:
You may assume word1 and word2 are both in the list.

 * 
 * @author bramanarayan
 * @date May 27, 2020
 */
public class ShortestWordDistance3 {

	public static void main(String args[]) {
		ShortestWordDistance3 solution = new ShortestWordDistance3();
		System.out.println(solution.shortestWordDistance(new String[] { "practice", "makes", "perfect", "coding", "makes" }, "makes",
				"coding"));
		System.out.println(solution.shortestWordDistance(new String[] { "practice", "makes", "perfect", "coding", "makes" }, "makes",
				"makes"));
	}

	public int shortestWordDistance(String[] words, String word1, String word2) {
		int index1 = -1;
		int index2 = -1;
		int min = Integer.MAX_VALUE;

		if (word1.equals(word2)) {
			//same word 
			for (int i = 0; i < words.length; i++) {
				if (word1.equals(words[i])) {
					// if on matching word here
					if (index1 == -1) {
						index1 = i;
					} else {
						min = Math.min(min, i - index1);
						index1 = i;
					}
					// Ignore the non-matching words,Keep incrementing
				}
			}
		} else {
			//different word
			for (int i = 0; i < words.length; i++) {
				if (word1.equals(words[i])) {
					index1 = i;
				}
				if (word2.equals(words[i])) {
					index2 = i;
				}
				if (index1 != -1 && index2 != -1) {
					min = Math.min(min, Math.abs(index1 - index2));
				}
			}
		}
		return min;
	}
}
