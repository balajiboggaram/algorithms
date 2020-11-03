/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title 1151 : 
 * 
 * Given a binary array data, return the minimum number of 
 * swaps required to group all 1’s present in the array together in any place in the array.
 * 
Example 1:

Input: [1,0,1,0,1]
Output: 1
Explanation: 
There are 3 ways to group all 1's together:
[1,1,1,0,0] using 1 swap.
[0,1,1,1,0] using 2 swaps.
[0,0,1,1,1] using 1 swap.
The minimum is 1.

 * 
 * @author bramanarayan
 * @date Jun 24, 2020
 */
public class MinimumSwapsToGroupOnes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	/** SLIDING WINDOW **/
	public int minSwaps(int[] data) {

		// Calculate number of 1s
		int  n = data.length;
		int subOnes[] = new int[n];
		subOnes[0] = data[0];
		int count = data[0];
		for (int i = 1; i < n; i++) {
			subOnes[i] = data[i] == 1 ? subOnes[i-1] + 1 : subOnes[i-1]; 
			if (data[i] == 1)
				count++;
		}
		
		// fix window size now.
		int x = count;
		
		if(x ==0) return 0; // if all zeros
		
		int maxOnes = 0;
		for (int i = x - 1; i < n; i++) {
			if(i == x -1) {
				// first window. so special
				maxOnes = subOnes[i];
			} else {
				// rest of the windows
				maxOnes = Math.max(maxOnes, subOnes[i] - subOnes[i-x]);
			}
		}
		
		// minimum of swap is number of zeros in the 'max ones' window
		return x - maxOnes;

	}

}
