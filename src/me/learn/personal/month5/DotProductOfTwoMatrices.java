/**
 * 
 */
package me.learn.personal.month5;

import java.util.HashSet;
import java.util.Set;

/**
 * Title 1570 :
 * 
 * Date : Dec 31, 2020
 * 
 * @author bramanarayan
 *
 */
public class DotProductOfTwoMatrices {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class SparseVector {

	// store only non-zero indicies
	Set<Integer> set = new HashSet<Integer>();
	int[] nums;

	SparseVector(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0)
				set.add(i);
		}
		this.nums = nums;
	}

	// Return the dotProduct of two sparse vectors
	public int dotProduct(SparseVector vec) {
		int result = 0;
		for (int index : set) {
			if (vec.set.contains(index)) {
				result += nums[index] * vec.nums[index];
			}
		}
		return result;
	}
}