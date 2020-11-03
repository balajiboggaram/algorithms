/**
 * 
 */
package me.learn.personal.month2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Title 1313 : We are given a list nums of integers representing a list
 * compressed with run-length encoding.
 * 
 * Consider each adjacent pair of elements [freq, val] = [nums[2*i],
 * nums[2*i+1]] (with i >= 0). For each such pair, there are freq elements with
 * value val concatenated in a sublist. Concatenate all the sublists from left
 * to right to generate the decompressed list.
 * 
 * Return the decompressed list.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,4] Output: [2,4,4,4] Explanation: The first pair [1,2]
 * means we have freq = 1 and val = 2 so we generate the array [2]. The second
 * pair [3,4] means we have freq = 3 and val = 4 so we generate [4,4,4]. At the
 * end the concatenation [2] + [4,4,4] is [2,4,4,4].
 * 
 * 
 * @author bramanarayan
 * @date May 29, 2020
 */
public class DecompressRunLengthEncoding {

	public static void main(String[] args) {
		DecompressRunLengthEncoding solution = new DecompressRunLengthEncoding();
		System.out.println(Arrays.toString(solution.decompressRLElist(new int[] { 1, 2, 3, 4 })));
	}

	public int[] decompressRLElist(int[] nums) {
		int n = nums.length;
		int i = 0, j = 0;
		List<Integer> res = new ArrayList<Integer>();
		while ((i + 1) < n) {
			j = i + 1;
			for (int k = 0; k < nums[i]; k++) {
				System.out.println(nums[j]);
				res.add(nums[j]);
			}
			i += 2;
		}

		// you can avoid this by adding the length of even digits in array and init
		// length.
		return res.stream().mapToInt(p -> p).toArray();
	}

}
