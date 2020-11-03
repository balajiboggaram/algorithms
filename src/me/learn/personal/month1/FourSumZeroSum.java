package me.learn.personal.month1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourSumZeroSum {

	public static void main(String args[]) {
		FourSumZeroSum solution = new FourSumZeroSum();
		System.out.println(solution.fourSumCount(new int[] { 1, 2 }, new int[] { -2, -1 }, new int[] { -1, 2 },
				new int[] { 0, 2 }));
		
		System.out.println(solution.fourSumCountMy1(new int[] { 1, 2 }, new int[] { -2, -1 }, new int[] { -1, 2 },
				new int[] { 0, 2 }));

	}

	public int fourSumCountMy1(int[] A, int[] B, int[] C, int[] D) {

		List<Integer> arr1 = new ArrayList<Integer>();
		List<Integer> arr2 = new ArrayList<Integer>();

		// sum of A and B + sum of C and D
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				arr1.add(A[i] + B[j]);
				arr2.add(C[i] + D[j]);
			}
		}

		int count = 0;
		for (int i = 0; i < arr1.size(); i++) {
			for (int j = 0; j < arr2.size(); j++) {
				if ((arr1.get(i) == 0 && arr2.get(j) == 0) || (arr2.get(j) == (-1 * arr1.get(i)))) {
					count++;
				}
			}
		}
		return count;

	}

	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

		Map<Integer, Integer> ABmap = new HashMap<>(); // key: sum, value: frequency of sum.

		int n = A.length;

		// Get all possible two-sums between AB
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int ABSum = A[i] + B[j];
				ABmap.put(ABSum, ABmap.getOrDefault(ABSum, 0) + 1);
			}
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int CDSum = C[i] + D[j];
				if (ABmap.containsKey(-CDSum)) {
					count += ABmap.get(-CDSum);
				}
			}
		}
		return count;
	}

}
