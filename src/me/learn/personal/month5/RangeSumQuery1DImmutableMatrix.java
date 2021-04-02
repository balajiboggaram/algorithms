/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 303 :
 * 
 * Date : Jan 8, 2021
 * 
 * @author bramanarayan
 *
 */
public class RangeSumQuery1DImmutableMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class NumArray {

	int[] preSum;

	public NumArray(int[] nums) {
		preSum = new int[nums.length + 1];
		for (int i = 1; i <= nums.length; i++) {
			preSum[i] = preSum[i - 1] + nums[i-1 ];
		}
	}

	public int sumRange(int i, int j) {
		return preSum[j+1] - preSum[i];
		
	}

}
