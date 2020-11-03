/**
 * 
 */
package me.learn.personal.month2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title : 
 * 
 * @author bramanarayan
 * @date May 26, 2020
 */
public class WordDistance {

	Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
	
	public static void main(String[] args) {
		WordDistance solution = new WordDistance(new String[] {"practice","makes","perfect","coding","makes"});
		System.out.println(solution.shortest("coding", "practice"));
		System.out.println(solution.shortest("makes", "coding"));
	}
	

	public WordDistance(String[] words) {
		
		// Maintain frequency map
		for(int i =0;i< words.length;i++) {
			if(map.containsKey(words[i])) {
				map.get(words[i]).add(i);
			} else {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(i);
				map.put(words[i], temp);

			}
		}
	}

	public int shortest(String word1, String word2) {
		List<Integer> word1Indexes = map.get(word1);
		List<Integer> word2Indexes = map.get(word2);

		if (word1Indexes == null || word2Indexes == null)
			return -1;

		int i = 0, j = 0; // merge step
		int minDistance = Integer.MAX_VALUE;
		while (i < word1Indexes.size() && j < word2Indexes.size()) {
			minDistance = Math.min(minDistance, Math.abs(word1Indexes.get(i) - word2Indexes.get(j)));
			if(word1Indexes.get(i) < word2Indexes.get(j)) {
				i++;
			} else {
				j++;
			}
		}
		return minDistance;

	}

}
