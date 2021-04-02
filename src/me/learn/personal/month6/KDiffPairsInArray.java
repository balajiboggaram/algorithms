/**
 * 
 */
package me.learn.personal.month6;

import java.util.HashMap;
import java.util.Map;

/**
 * Title 532 :
 * 
 * Date : Feb 15, 2021
 * 
 * @author bramanarayan
 *
 */
public class KDiffPairsInArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		KDiffPairsInArray solution = new KDiffPairsInArray();
		System.out.println(solution.findPairs(new int[] {3, 1,4,1,5}, 2));
	}

	
	// First get the freq map ready 
	// now, check if x + diff exists or not in the map, if exists, then you found a pair.
	// similary x - diff too. (not shown)
	// idea : |x-y| = diff implies y = x + diff, or y = x - diff.
	 public int findPairs(int[] nums, int k) {

	        int result = 0;

	        HashMap <Integer,Integer> counter = new HashMap<>();
	        for (int n: nums) {
	            counter.put(n, counter.getOrDefault(n, 0)+1);
	        }


	        for (Map.Entry <Integer, Integer> entry: counter.entrySet()) {
	            int x = entry.getKey();
	            int val = entry.getValue();
	            if (k > 0 && counter.containsKey(x + k)) {
	                result++;
	            } else if (k == 0 && val > 1) { // this is just edge case
	                result++;
	            }
	        }
	        return result;
	    }

}
