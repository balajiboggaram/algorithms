/**
 * 
 */
package me.learn.personal.month4;

import java.util.Arrays;

/**
 * Title 875 :
 * 
 * Koko loves to eat bananas. There are N piles of bananas, the i-th pile has
 * piles[i] bananas. The guards have gone and will come back in H hours.
 * 
 * Koko can decide her bananas-per-hour eating speed of K. Each hour, she
 * chooses some pile of bananas, and eats K bananas from that pile. If the pile
 * has less than K bananas, she eats all of them instead, and won't eat any more
 * bananas during this hour.
 * 
 * Koko likes to eat slowly, but still wants to finish eating all the bananas
 * before the guards come back.
 * 
 * Return the minimum integer K such that she can eat all the bananas within H
 * hours.
 * 
 * 
 * Example 1:
 * 
 * Input: piles = [3,6,7,11], H = 8 Output: 4
 * 
 * Example 2:
 * 
 * Input: piles = [30,11,23,4,20], H = 5 Output: 30
 * 
 * 
 * @author bramanarayan
 * @date Aug 3, 2020
 */
public class KokoEatingBananas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		KokoEatingBananas solution = new KokoEatingBananas();
		System.out.println(solution.minEatingSpeed(new int[] { 3, 6, 7, 11 }, 8));
	}

	// a -> piles
	public int minEatingSpeed(int[] a, int H) {

		int low = 1;
		int high = Integer.MIN_VALUE;
		
		// guess the max range
		for (int i = 0; i < a.length; i++) {
			high = Math.max(high, a[i]);
		}

		while (low <= high) {
			// this is the k we picked as if banana can eat this much in H hours
			int mid = low + (high - low) / 2;

			if (possible(a, H, mid)) {
				high = mid-1;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}
	
	// Can Koko eat all bananas in H hours with eating speed K?
	boolean possible(int[] piles, int H, int k){
        int time = 0;
        for (int p: piles){
            time += p/k; // Get the number of hours not accounting for leftover hours
            time += (p % k == 0) ? 0: 1; // Now account for leftover hours here.
        }
        
        return time <= H;
    }

}
