/**
 * 
 */
package me.learn.personal.month5;

import java.util.Arrays;

/**
 * Title 462 :
 * 
 * Date : Dec 30, 2020
 * 
 * @author bramanarayan
 *
 */
public class MinimumMovesToMakeArrayEqualBoth {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// In this problem, you need to make the array equal.Here you can do both - either increment or decrement a value.
	public int minMoves2(int[] a) {
		// sort the array
		Arrays.sort(a);
		
		// tow pointers - meet in middle now
		int i = 0, j = a.length-1;
		int moves = 0;
		while(i < j) {
			moves += a[j]- a[i];
			i++;
			j--;
		}
		return moves;
		
	}

}
