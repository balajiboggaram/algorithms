/**
 * 
 */
package me.learn.personal.month2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Title 127 : 
 * 
 *  Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

    Only one letter can be changed at a time.
    Each transformed word must exist in the word list.

Note:

    Return 0 if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.
    You may assume no duplicates in the word list.
    You may assume beginWord and endWord are non-empty and are not the same.

Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
 * 
 * @author bramanarayan
 * @date Jun 15, 2020
 */
public class WordLadder {

	public static void main(String[] args) {
		WordLadder solution = new WordLadder();

		List<String> dic = new ArrayList<String>();
		dic.add("hit");
		dic.add("hot");
		dic.add("dot");
		dic.add("dog");
		dic.add("lot");
		dic.add("log");
		dic.add("cog");

		System.out.println(solution.ladderLength("hit", "cog", dic));
	}

	public int ladderLength(String start, String end, List<String> wordList) {
		
		if (!wordList.contains(end))
			return -1;
		
		int level = 0;

		Queue<String> q = new LinkedList<String>();
		q.add(start);

		while (!q.isEmpty()) {

			level++;
			System.out.println(level);
			int qSize = q.size();

			// For a given level.
			for (int i = 0; i < qSize; i++) {

				// Pop the word from the queue
				String wordString = q.poll();
				char[] word = wordString.toCharArray();
				int wordLength = wordString.length();

				// Now try to fetch all the combinations, replace with 26 
				for (int pos = 0; pos < wordLength; pos++) {

					char backUp = word[pos]; // track here so that we can backtrack later

					// try all from a to z
					for (char c = 'a'; c <= 'z'; c++) {

						word[pos] = c; // replace with all 26 combinations
						//System.out.println(word);
						String candidate = new String(word);

						if (candidate.equals(end))
							return level + 1;


						// If the word do not exist, then just continue
						if (!wordList.contains(candidate))
							continue;

						System.out.println("adding word " + candidate);
						// Suppose if the word exists in dictionary
						q.add(candidate); // add to queue
						wordList.remove(candidate); // remove the word from dictionary so that it will not be processed
													// again

					}
					word[pos] = backUp; // backtrack.
				}
			}
		}

		return -1;
	}

}
