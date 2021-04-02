/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 1470 :
 * 
 * Date : Dec 30, 2020
 * 
 * @author bramanarayan
 *
 */
public class ShuffleTheArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Input: nums = [2,5,1,3,4,7], n = 3 
	 * 
	 * Output: [2,3,5,4,1,7] Explanation: Since
	 * 
	 * x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
	 */
	public int[] shuffle(int[] a, int n) {
		
		int i = 0;
		int j = n;
		int k = 0;
		int[] res = new int[2 * n];
		while(i < n && j < 2 * n) {
			res[k++] = a[i++];
			res[k++] = a[j++];
		}
		return res;
	}

}
