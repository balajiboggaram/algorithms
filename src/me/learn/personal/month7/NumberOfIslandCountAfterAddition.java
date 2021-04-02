/**
 * 
 */
package me.learn.personal.month7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Title 305 :
 * 
 * Date : Feb 26, 2021
 * 
 * @author bramanarayan
 *
 */

public class NumberOfIslandCountAfterAddition {

	int[] row = { -1, 1, 0, 0 };
	int[] col = { 0, 0, -1, 1 };

	// IDEA : based on UNION FIND
	/**
	 * The basic idea is the Union-Find approach. We assign a root number for each
	 * island, and use an array to record this number. For each input, we check its
	 * four neighbor cells. If the neighbor cell is an island, then we retrieve the
	 * root number of this island. If two neighbor cells belong to two different
	 * islands, then we union them and therefore the total number of islands will
	 * become one less.
	 */
	public List<Integer> numIslands2(int m, int n, int[][] positions) {

		List<Integer> res = new ArrayList<>();

		int count = 0;
		int[] parent = new int[m * n]; // using array instead on typical parentMap in union (yours)

		Arrays.fill(parent, -1); // initially none islands

		for (int[] p : positions) {

			int i = p[0];
			int j = p[1];

			// for each position, mark it as new island
			int effectiveX = i * n + j; // computed index
			
			parent[effectiveX] = effectiveX; 
			count++; // assume its a island

			for (int k = 0; k < 4; k++) {
				// check neighbours
				int nx = i + row[k], ny = j + col[k];
				int effectiveY = nx * n + ny; // computed index here again 

				// ignore invalid position
				if (nx < 0 || nx >= m || ny < 0 || ny >= n || parent[effectiveY] == -1)
					continue;

				// find and union islands
				effectiveY = find(parent, effectiveY);
				effectiveX = find(parent, effectiveX);
				
				
				parent[effectiveY] = effectiveX;

				// merge two isolated islands
				if (effectiveY != effectiveX)
					count--;
			}

			res.add(count);
		}

		return res;
	}

	int find(int nums[], int i) {
		if (nums[i] == i)
			return i;
		nums[i] = find(nums, nums[i]);
		return nums[i];
	}

}
