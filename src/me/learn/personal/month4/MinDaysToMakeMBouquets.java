/**
 * 
 */
package me.learn.personal.month4;

import java.util.Map;
import java.util.TreeMap;

/**
 * Title 1482 :
 * 
 * Given an integer array bloomDay, an integer m and an integer k.
 * 
 * We need to make m bouquets. To make a bouquet, you need to use k adjacent
 * flowers from the garden.
 * 
 * The garden consists of n flowers, the ith flower will bloom in the
 * bloomDay[i] and then can be used in exactly one bouquet.
 * 
 * Return the minimum number of days you need to wait to be able to make m
 * bouquets from the garden. If it is impossible to make m bouquets return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: bloomDay = [1,10,3,10,2], m = 3, k = 1 Output: 3 Explanation: Let's
 * see what happened in the first three days. x means flower bloomed and _ means
 * flower didn't bloom in the garden. We need 3 bouquets each should contain 1
 * flower. After day 1: [x, _, _, _, _] // we can only make one bouquet. After
 * day 2: [x, _, _, _, x] // we can only make two bouquets. After day 3: [x, _,
 * x, _, x] // we can make 3 bouquets. The answer is 3.
 * 
 * 
 * @author bramanarayan
 * @date Aug 22, 2020
 */
public class MinDaysToMakeMBouquets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MinDaysToMakeMBouquets solution = new MinDaysToMakeMBouquets();
		System.out.println(solution.minDays(new int[] {1, 10, 3,10,2 }, 3, 2));
		
	}

	// a-> bloomDay
	// binary search basically
	public int minDays(int[] a, int m, int k) {

		int n = a.length;
		if (n < m * k)
			return -1; // # of bloom days are less than # of flowers

		// Step 1 : find the max and min
		int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
		for (int i : a) {
			high = Math.max(high, i);
			low = Math.min(low, i);
		}

		// Step 2 : take the boundary now, and try to see if we can make bouquets in
		// those days
		while (low < high) {
			int mid = low + (high - low) / 2;

			int possibleBoqCount = getCount(a, mid, k);
			if (possibleBoqCount < m) {
				low = mid + 1;
			} else {
				high = mid ;
			}
		}
		return low;

	}

	// HOw many boquets can I make until target day. where each bouqet is of size k
	private int getCount(int[] a, int targetDay, int k) {
		
		int count = 0; // bouqu count
		int flowersCollected = 0;
		for(int day : a) {
			if(day <= targetDay) {
				flowersCollected++;
			} else {
				flowersCollected = 0; // since you need adjacent factor here.
			}
			
			if(flowersCollected == k) {
				count++;
				flowersCollected = 0; // cut all the flowers
			}
			
		}
		return count;
	}
}
