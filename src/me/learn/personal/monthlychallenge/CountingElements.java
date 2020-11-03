/**
 * 
 */
package me.learn.personal.monthlychallenge;

import java.util.HashSet;
import java.util.Set;

/**
 * Title : Given an integer array arr, count element x such that x + 1 is also
 * in arr.
 * 
 * If there're duplicates in arr, count them seperately.
 * 
 * @author bramanarayan
 * @date Apr 29, 2020
 */
public class CountingElements {

	public static void main(String[] args) {
		CountingElements solution = new CountingElements();
		solution.countElements(new int[] {1,2,3});
		solution.countElements(new int[] {1,1,3,3,5,5,7,7});
		solution.countElements(new int[] {1,1,2,2});

	}

	public int countElements(int[] arr) {

		Set<Integer> input = new HashSet<Integer>();
		int result = 0;
		
		for(int i = 0; i< arr.length; i++) {
			input.add(arr[i]);
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (input.contains(arr[i]+1)) {
				result++;
			}
		}
		System.out.println(result);
		return result;

	}
}
