/**
 * 
 */
package me.learn.personal.month3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Title 692 :
 * 
 * Given a non-empty list of words, return the k most frequent elements.
 * 
 * Your answer should be sorted by frequency from highest to lowest. If two
 * words have the same frequency, then the word with the lower alphabetical
 * order comes first.
 * 
 * Example 1:
 * 
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2 Output: ["i",
 * "love"] Explanation: "i" and "love" are the two most frequent words. Note
 * that "i" comes before "love" due to a lower alphabetical order.
 * 
 * Example 2:
 * 
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is",
 * "is"], k = 4 Output: ["the", "is", "sunny", "day"] Explanation: "the", "is",
 * "sunny" and "day" are the four most frequent words, with the number of
 * occurrence being 4, 3, 2 and 1 respectively.
 * 
 * 
 * @author bramanarayan
 * @date Jul 19, 2020
 */
public class TopKFrequentWords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TopKFrequentWords solution = new TopKFrequentWords();
		System.out.println(solution.topKFrequent(new String[] { "i", "love", "leetcode", "i", "love", "coding" }, 2));
	}

	// Min heap + kk
	// o [n log k]
	public List<String> topKFrequent(String[] words, int k) {

		// frequency map
		Map<String, Integer> m = new HashMap<String, Integer>();
		for (String word : words) {
			m.put(word, m.getOrDefault(word, 0) + 1);
		}

		// Add to queue
		PriorityQueue<CEntryString> pq = new PriorityQueue<>();
		m.entrySet().forEach(x -> {
			pq.add(new CEntryString(x.getKey(), x.getValue()));
			if (pq.size() > k) {
				pq.remove();
			}
		});

		// add k elements to result;
		List<String> result = new ArrayList<String>();
		pq.forEach(x -> {
			result.add(x.key);
		});
		Collections.reverse(result);
		return result;

	}
}

class CEntryString implements Comparable<CEntryString> {

	public String key;
	public int count;

	public CEntryString(String key, int value) {
		this.key = key;
		this.count = value;
	}

	// Example for sorting on multiple conditions. 
	// == -> to do on tie
	@Override
	public int compareTo(CEntryString o) {
		if( this.count == o.count) {
			return this.key.compareTo(o.key);
		} else {
			return this.count - o.count;
		}
	}
}
