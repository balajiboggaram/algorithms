/**
 * 
 */
package me.learn.personal.month6;

import java.util.Arrays;

/**
 * Title 1196 :
 * 
 * Date : Jan 12, 2021
 * 
 * @author bramanarayan
 *
 */
public class PickMaximumApples {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxNumberOfApples(int[] arr) {

		if (arr.length == 0)
			return 0;
		Arrays.sort(arr);
		int sum = 0, i = 0;

		while (i < arr.length ) {
			
			sum += arr[i];
			if( sum > 5000) break;
			i++;
		}
		return i;
	}

}
