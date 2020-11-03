/**
 * 
 */
package me.learn.personal.month4;

import java.util.Arrays;

/**
 * Title 475 :
 * 
 *  Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.

Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.

So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.

Note:

    Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
    Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
    As long as a house is in the heaters' warm radius range, it can be warmed.
    All the heaters follow your radius standard and the warm radius will the same.

 

Example 1:

Input: [1,2,3],[2]
Output: 1
Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.

 

Example 2:

Input: [1,2,3,4],[1,4]
Output: 1
Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.

 * 
 * @author bramanarayan
 * @date Aug 6, 2020
 */
public class Heaters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Heaters solution = new Heaters();
		solution.binarySearch(new int[] {1,2,3,4}, 1);
		solution.binarySearch(new int[] {1,2,3,4,8}, 7);
		solution.binarySearch(new int[] {1,2,3,4,8}, 65);
		solution.binarySearch(new int[] {1,2,3,4,8}, -1);
		solution.binarySearch(new int[] {1,4}, 2);
		solution.binarySearch(new int[] {1,4}, 4);


		System.out.println(solution.findRadius(new int[] {1,2,3,4}, new int[] {1,4}));
	}

	// grab a house and try to search in a heater.
	// closest distance to a heater on left and right. 
	// so the answer is maximum of min (left and right distance) would be the answer 
	public int findRadius(int[] houses, int[] heaters) {
		int m = houses.length;
		int n = heaters.length;

		int result = Integer.MIN_VALUE;

		Arrays.sort(heaters);
		Arrays.sort(houses);

		int i = 0, j = 0;
		while (i < m && j < n) {
			// search house[i] in heaters
			int index = Arrays.binarySearch(heaters, houses[i]);

			int ld = 0;
			int rd = 0;

			if (index < 0) {
				index = -(index);
				
				// right distance
				if(index-1 >= 0 && index-1 < n) {
					rd = Math.abs(heaters[index-1] - houses[i]);
				} else {
					rd = Math.abs(heaters[n-1] - houses[i]);
				}
				
				// left distance
				if(index-2 >= 0 && index-2 < n) {
					ld = Math.abs(heaters[index-2] - houses[i]);
				} else {
					ld = Math.abs(heaters[0] - houses[i]);
				}

			}

			result = Math.max(result, Math.min(ld, rd));
			i++;
		}
		return result;
	}
	
	private void binarySearch(int[] a , int key) {
		System.out.println(Arrays.binarySearch(a, key));
	}
}
