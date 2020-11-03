package me.learn.personal.month2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Title 1331 : Given an array of integers arr, replace each element with its
 * rank.
 * 
 * The rank represents how large the element is. The rank has the following
 * rules:
 * 
 * Rank is an integer starting from 1. The larger the element, the larger the
 * rank. If two elements are equal, their rank must be the same. Rank should be
 * as small as possible.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: arr = [40,10,20,30] Output: [4,1,2,3] Explanation: 40 is the largest
 * element. 10 is the smallest. 20 is the second smallest. 30 is the third
 * smallest.
 * 
 * @author bramanarayan
 * @date Jun 7, 2020
 */
public class RankTransformArray {

	public static void main(String args[]) {
		RankTransformArray solution = new RankTransformArray();
		// solution.arrayRankTransform(new int[] { 40, 10, 20, 30 });
		solution.arrayRankTransform(new int[] { 100, 100, 100 });
		solution.arrayRankTransform(new int[] { 37, 12, 28, 9, 100, 56, 80, 5, 12 });

	}

	public int[] arrayRankTransform(int[] arr) {
		int n = arr.length;
		int[] result = new int[n];
		int[] copy = arr.clone();
		Arrays.sort(copy);

		Map<Integer, Integer> ranking = new HashMap<>();
		int rank = 1;
		
		// Try to put ranks of all the elements. Trick is dont put the element  with same rank
		for (int i = 0; i < n; i++) {
			if (ranking.containsKey(copy[i]))
				continue;
			ranking.put(copy[i], rank);
			rank++;
		}

		
		// Now, iterate the oriignal array and fetch the rank from our previous map.
		for (int i = 0; i < n; i++) {
			result[i] = ranking.get(arr[i]);
		}

		return result;
	}

}
