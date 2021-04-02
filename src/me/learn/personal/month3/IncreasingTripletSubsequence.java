/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title 324 :
 * 
 * Date : Jan 6, 2021
 * 
 * @author bramanarayan
 *
 */
public class IncreasingTripletSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean increasingTriplet(int[] nums) {
		// start with two largest values, as soon as we find a number bigger than both,
		// while both have been updated, return true.
		int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
		for (int n : nums) {
			if (n <= small) {
				small = n;
			} // update small if n is smaller than both
			else if (n <= big) {
				big = n;
			} // update big only if greater than small but smaller than big
			else
				return true; // return if you find a number bigger than both
		}
		return false;
	}

}
