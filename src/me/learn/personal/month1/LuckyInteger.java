package me.learn.personal.month1;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * 
 * Title : Given an array of integers arr, a lucky integer is an integer which
 * has a frequency in the array equal to its value.
 * 
 * Return a lucky integer in the array. If there are multiple lucky integers
 * return the largest of them. If there is no lucky integer return -1.
 * 
 * @author bramanarayan
 * @date May 12, 2020
 */
public class LuckyInteger {

	public static void main(String args[]) {
		LuckyInteger solution = new LuckyInteger();
		System.out.println(solution.findLucky(new int[] { 1, 2, 2, 3, 3, 3 }));
		System.out.println(solution.findLucky(new int[] { 1, 2, 2, 3, 3}));
	}

	public int findLucky(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}

		int result = -1;
		for (Entry<Integer, Integer> e : map.entrySet()) {
			if (e.getKey() == e.getValue() && result < e.getKey()) {
				result = e.getKey();
			}
		}
		return result;
	}

}
