/**
 * 
 */
package me.learn.personal.month7;

/**
 * Title :
 * 
 * Date : Feb 25, 2021
 * 
 * @author bramanarayan
 *
 */
public class ValidMountainArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean validMountainArray(int[] A) {
		if (A.length < 3)
			return false;
		int start = 0;
		int end = A.length - 1;
		while (start < end) {
			if (A[start + 1] > A[start]) {
				start++;
			} else if (A[end - 1] > A[end]) {
				end--;
			} else {
				break;
			}
		}
		return start != 0 && end != A.length - 1 && start == end;
	}

}
