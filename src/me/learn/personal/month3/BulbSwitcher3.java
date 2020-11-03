/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title 1375 :
 * 
 * here is a room with n bulbs, numbered from 1 to n, arranged in a row from
 * left to right. Initially, all the bulbs are turned off.
 * 
 * At moment k (for k from 0 to n - 1), we turn on the light[k] bulb. A bulb
 * change color to blue only if it is on and all the previous bulbs (to the
 * left) are turned on too.
 * 
 * Return the number of moments in which all turned on bulbs are blue.
 * 
 * 
 * Input: light = [2,1,3,5,4]
Output: 3
Explanation: All bulbs turned on, are blue at the moment 1, 2 and 4.


 * @author bramanarayan
 * @date Jun 23, 2020
 */
public class BulbSwitcher3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BulbSwitcher3 solution = new BulbSwitcher3();
		System.out.println(solution.numTimesAllBlue(new int[] {2,1,3,5,4}));
		System.out.println(solution.numTimesAllBlue(new int[] {3,2,4,1,5}));

	}

	// Basically keep track of the right most. 
	// if the index is equal to righmost then all the left ones are switched on...
	public int numTimesAllBlue(int[] a) {
		int rightMost = 0;
		int result = 0;

		for (int i = 1; i <= a.length; i++) {
			rightMost = Math.max(rightMost, a[i-1]);
			if(i == rightMost) result++;
		}
		
		return result;
	}

}
