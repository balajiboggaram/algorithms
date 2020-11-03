/**
 * 
 */
package me.learn.personal.month3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Title 358 :
 * 
 * Given a non-empty string s and an integer k, rearrange the string such that
 * the same characters are at least distance k from each other.
 * 
 * All input strings are given in lowercase letters. If it is not possible to
 * rearrange the string, return an empty string "".
 * 
 * Example 1:
 * 
 * Input: s = "aabbcc", k = 3 Output: "abcabc" Explanation: The same letters are
 * at least distance 3 from each other.
 * 
 * 
 * @author bramanarayan
 * @date Jul 3, 2020
 */
public class RearrangeStringWithKDistantApart {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RearrangeStringWithKDistantApart solution = new RearrangeStringWithKDistantApart();
		System.out.println(solution.rearrangeString("aa", 1));
		
		System.out.println(solution.rearrangeString("aabbcc", 3));
		System.out.println(solution.rearrangeString("aaabc", 3));
		System.out.println(solution.rearrangeString("aaaadbbcc", 2));

	}

	// PRIORITY QUEUE + QUEUE - Note that you need least recently used and the fetch on frrequency.
	// hence this compbination is required
	public String rearrangeString(String s, int k) {

		if(k == 0) return s;
		
		// Compute all the frequencies of the characters
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);

		}

		// Put them in the priority queue
		PriorityQueue<RTuple> pq = new PriorityQueue<RTuple>();
		map.entrySet().forEach(x -> pq.add(new RTuple(x.getValue(), x.getKey())));

		// compute the string now. basically roundrobin for k items via waiting queue
		// wait queue
		StringBuilder sb = new StringBuilder();
		Queue<RTuple> waitingQueue = new LinkedList<RTuple>();
		while(!pq.isEmpty()) {
			
			RTuple temp = pq.poll();
			sb.append(temp.c);
			temp.count--;
			
			waitingQueue.offer(temp);
			
			if(waitingQueue.size() < k) {
				continue; // round robin is not ready yet - wait....
			}
			
			// if k items are polled from pq, then we can start processing from wait queue
			// Release from waitQueue if char is already k apart
			RTuple r = waitingQueue.poll();
			if(r.count > 0) {
				pq.offer(r);
			}	
		}
		
		return sb.length() == s.length() ? sb.toString() : "";
		
	/*	// compute the String now - doesnt work for aabbcc k =2
		char[] c = new char[n];
		while (!pq.isEmpty()) {
			RTuple t = pq.remove();

			int index = findFirstEmptyIndex(c);
			
			int count = t.count;

			for (int i = index; i < n && count > 0; i += k) {
				if (c[i] != '\u0000')
					return "";

				c[i] = t.c;
				count--; // to decrement already placed characters
			}
			
			if(count > 0 ) {
				return "";
			}
		}

		return new String(c);*/

	}

}

class RTuple implements Comparable<RTuple> {
	int count;
	char c;

	public RTuple(int count, char c) {
		this.count = count;
		this.c = c;
	}

	// ascending - other - mine
	@Override
	public int compareTo(RTuple o) {
		return o.count - this.count;
	}

}
