/**
 * 
 */
package me.learn.personal.month5;

import java.util.TreeMap;

/**
 * Title 846, 1296:
 * 
 * Date : Jan 4, 2021
 * 
 * @author bramanarayan
 *
 */
public class HandOfStraights {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// check if I can form W subarrays of consucutive increasing sequence.
	// 1,2,3 4,5,6 7,8,9 (W = 3) from a given array
	public boolean isNStraightHand(int[] hand, int W) {

		int n = hand.length;
		TreeMap<Integer, Integer> tmap = new TreeMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			tmap.put(hand[i], tmap.getOrDefault(hand[i], 0) + 1);
		}

		// once you have them in tree map, keep fetching mins and in sequence up to W
		// elements.
		while (tmap.size() > 0) {
			int min = tmap.firstKey();
			for (int i = 0; i < W; i++) {
				if (tmap.get(min) == null)
					return false;
				else {
					tmap.put(min, tmap.get(min) - 1);
					min++;
				}
				if (tmap.get(min - 1) == 0) // decrease the older element here
					tmap.remove(min - 1);
			}
		}
		return true;

	}

}
