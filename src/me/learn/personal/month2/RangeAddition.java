package me.learn.personal.month2;

/**
 * 
 * Title 370 : Assume you have an array of length n initialized with all 0's and
 * are given k update operations.
 * 
 * Each operation is represented as a triplet: [startIndex, endIndex, inc] which
 * increments each element of subarray A[startIndex ... endIndex] (startIndex
 * and endIndex inclusive) with inc.
 * 
 * Return the modified array after all k operations were executed.
 * 
 * Example:
 * 
 * Input: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]] Output: [-2,0,3,5,3]
 * 
 * 
 * @author bramanarayan
 * @date May 28, 2020
 */
public class RangeAddition {

	public static void main(String args[]) {
		RangeAddition solution = new RangeAddition();
		solution.getModifiedArray(5, new int[][] { { 1, 3, 2 }, { 2, 4, 3 }, { 0, 2, -2 } });
	}

	/**
	 * Great solution. Though the code looks simple enough, it took me some time to
	 * figure out why exactly we do what we do here. We update the value at start
	 * index, because it will be used in the future when we are adding up the values
	 * for the sum at each index between start index and end index (both inclusive).
	 * We update the negative value at the end index + 1, because the positive value
	 * of it should be only added at its previous indices (from start index to end
	 * index). Thus, when we accumulate the sum at the end for each index, we will
	 * get the correct values for each index. If the end index is the last index in
	 * the resulting array, we don't have to do the end index + 1 part, because
	 * there is no more index after the last index and there will be no error when
	 * we accumulate the sum. Hope I explain it well enough to help others
	 * understand!
	 * 
	 * for example it will look like:
	 * 
	 * [1 , 3 , 2] , [2, 3, 3] (length = 5)
	 * 
	 * res[ 0, 2, ,0, 0 -2 ]
	 * 
	 * res[ 0 ,2, 3, 0, -5]
	 * 
	 * sum 0, 2, 5, 5, 0
	 * 
	 * res[0, 2, 5, 5, 0]
	 * 
	 */
	public int[] getModifiedArray(int length, int[][] updates) {

		int[] res = new int[length];
		for (int[] update : updates) {
			int value = update[2];
			int start = update[0];
			int end = update[1];

			res[start] += value;

			if (end < length - 1)
				res[end + 1] -= value;

		}

		int sum = 0;
		for (int i = 0; i < length; i++) {
			sum += res[i];
			res[i] = sum;
		}

		return res;
	}

}
