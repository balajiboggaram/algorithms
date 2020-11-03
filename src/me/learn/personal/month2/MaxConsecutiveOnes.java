/**
 * 
 */
package me.learn.personal.month2;

/**
 * Title 485 :
 * 
 * Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:

Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.

Note:

    The input array will only contain 0 and 1.
    The length of input array is a positive integer and will not exceed 10,000
 *  
 * 
 * @author bramanarayan
 * @date Jun 11, 2020
 */
public class MaxConsecutiveOnes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MaxConsecutiveOnes solution = new MaxConsecutiveOnes();
		System.out.println(solution.findMaxConsecutiveOnes(new int[] { 1, 1, 0, 1, 1, 1 }));
	}

	// TWO RUNNING POINTERS
	public int findMaxConsecutiveOnes(int[] a) {
		int n = a.length;
		int i = 0, j = 0;
		int maxCount = 0;
		while (j < n) {
			if (a[j] == 1) {
				maxCount = Math.max(maxCount, j - i + 1);
				j++;
			} else {
				j++;
				i = j;
			}
		}
		return maxCount;
	}

}
