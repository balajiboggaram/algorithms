package me.learn.personal.month2;

import java.util.Arrays;

/**
 * 
 * Title 1051 : Students are asked to stand in non-decreasing order of heights
 * for an annual photo.
 * 
 * Return the minimum number of students that must move in order for all
 * students to be standing in non-decreasing order of height.
 * 
 * Notice that when a group of students is selected they can reorder in any
 * possible way between themselves and the non selected students remain on their
 * seats.
 * 
 * Example 1:
 * 
 * Input: heights = [1,1,4,2,1,3] Output: 3 Explanation: Current array :
 * [1,1,4,2,1,3] Target array : [1,1,1,2,3,4] On index 2 (0-based) we have 4 vs
 * 1 so we have to move this student. On index 4 (0-based) we have 1 vs 3 so we
 * have to move this student. On index 5 (0-based) we have 3 vs 4 so we have to
 * move this student.
 * 
 * 
 * @author bramanarayan
 * @date May 29, 2020
 */
public class HeightChecker {

	public static void main(String args[]) {
		HeightChecker solution = new HeightChecker();
		System.out.println(solution.heightChecker(new int[] { 1, 1, 4, 2, 1, 3 }));
	}

	// sort the copy and check if the value differs or not.
	public int heightChecker(int[] heights) {
		int n = heights.length;
		int[] copyHeight = new int[n];
		for (int i = 0; i < n; i++) {
			copyHeight[i] = heights[i];
		}
		Arrays.sort(copyHeight);
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (copyHeight[i] != heights[i])
				count++;
		}

		return count;
	}
}
