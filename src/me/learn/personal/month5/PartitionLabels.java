/**
 * 
 */
package me.learn.personal.month5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Title 763 :
 * 
 * Date : Dec 31, 2020
 * 
 * @author bramanarayan
 *
 */
public class PartitionLabels {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Grab all the end indicies of characters in string s
	// once you have that, run the loop and maintain a set and count to track # of
	// ends seen so far.
	// if # of ends seen i.e count == set size then viola, your found a part of
	// string
	public List<Integer> partitionLabels(String s) {

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), i); // update the end index of each character seen in string so far.
		}

		// once we have that map. all we need is the set and count
		Set<Character> set = new HashSet<Character>();
		List<Integer> result = new ArrayList<Integer>();
		int count = 0;
		int start = 0;
		int i = 0;
		while (i < s.length()) {
			char ch = s.charAt(i);
			set.add(ch);
			if (map.get(ch) == i) {
				count++;
			}
			if (set.size() == count) {
				// we have a part ready for our result
				result.add(i - start + 1);
				set = new HashSet<Character>(); // reset seen so far
				count = 0; // reset end seen count 
				start = i+1; // start of next part
			}
			i++;
		}
		return result;
		
		// You can totally avoid using a set in the above step. 
		// how ? All that you need is to track the last (int variable) index of element in running 'i' pointer. keep updating the last.
		// as soon as you hit the last, then viola, that is your result part.
	}
}
