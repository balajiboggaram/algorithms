/**
 * 
 */
package me.learn.personal.month3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * Title 347 :
 * 
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
 * Example 1:
 * 
 * Input: nums = [1,1,1,2,2,3], k = 2 Output: [1,2]
 * 
 * Example 2:
 * 
 * Input: nums = [1], k = 1 Output: [1]
 * 
 * @author bramanarayan
 * @date Jul 17, 2020
 */
public class TopKFrequentElements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TopKFrequentElements solution = new TopKFrequentElements();
		System.out.println(Arrays.toString(solution.topKFrequent(new int[] {1,1,1,2,2,3}, 2)));
		System.out.println(Arrays.toString(solution.topKFrequent(new int[] {1}, 1)));

	}

	// HEAP + kk 
	public int[] topKFrequent(int[] a, int k) {
		
		// Prepare a frequency ap
		Map<Integer, Integer> m = new HashMap<Integer,Integer>();
		for(int num : a) {
			m.put(num, m.getOrDefault(num, 0 ) + 1);
		}
		
		// get the top k frequent elements
		PriorityQueue<CKEntry> pq = new PriorityQueue<CKEntry>();
		for(Entry<Integer,Integer> e : m.entrySet()) {
			pq.add(new CKEntry(e.getKey(), e.getValue()));
			if(pq.size() > k) {
				pq.remove();
			}
		}
		
		// return the top k frequent elements
		int[] result = new int[k];
		for(int i =k-1; i >= 0;i--) {
			result[i] = pq.remove().element;
		}
		
		return result;
		
	}
		
}

class CKEntry implements Comparable<CKEntry> {
	
	int element;
	int count;
	
	public CKEntry(int element, int count) {
		this.element = element;
		this.count = count;;
	}

	@Override
	public int compareTo(CKEntry o) {
		return this.count - o.count;
	}
	
}
