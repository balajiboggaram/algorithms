/**
 * 
 */
package me.learn.personal.month7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Title 1200 :
 * 
 * Date : Feb 25, 2021
 * 
 * @author bramanarayan
 *
 */
public class MinimumAbsoluteDifference {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * sort the elements
	 * compute the diff, if its minim -> then clear the previous result and then keep adding the new 
	 */
	public List<List<Integer>> minimumAbsDifference(int[] arr) {
		List<List<Integer>> res = new ArrayList();
		// sort elements
		Arrays.sort(arr);
		// init our min difference value
		int min = Integer.MAX_VALUE;
		// start looping over array to find real min element. Each time we found smaller
		// difference
		// we reset resulting list and start building it from scratch. If we found pair
		// with the same
		// difference as min - add it to the resulting list
		for (int i = 0; i < arr.length - 1; i++) {
			int diff = arr[i + 1] - arr[i];
			
			if (diff < min) {
				// clear the result
				min = diff;
				res.clear();
				res.add(Arrays.asList(arr[i], arr[i + 1]));
			} else if (diff == min) {
				res.add(Arrays.asList(arr[i], arr[i + 1]));
			}
		}
		return res;
	}
}
