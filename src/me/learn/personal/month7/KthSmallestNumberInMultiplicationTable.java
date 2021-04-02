/**
 * 
 */
package me.learn.personal.month7;

/**
 * Title 668 :
 * 
 * Date : Mar 6, 2021
 * 
 * @author bramanarayan
 *
 */
public class KthSmallestNumberInMultiplicationTable {

	public int findKthNumber(int m, int n, int k) {

		int left = 1;
		int right = m * n;

		while (left < right) {

			int mid = left + (right - left) / 2;

			int count = count(mid, m, n);

			if (count < k) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return right;
	}

	// how many elements are less than value
	private int count(int value, int m, int n) {

		int i = m, j = 1;
		int count = 0;

		while (i >= 1 && j <= n) {
			// include all the elements in the column. go to next column here
			if (i * j <= value) {
				count += i;
				j++;
			} else {
				// reduce the row, you cannot include any element in the current row, Try previous row
				i--;
			}
		}

		return count;
	}

}
