/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 1095 :
 * 
 * Date : Jan 3, 2021
 * 
 * @author bramanarayan
 *
 */
public class FindInMountainArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Its a pure triple binary search

	// find the pinnacle peak index
	// find the up hill - if target exists ?
	// find the down hill - if target exists ?

	int findInMountainArray(int target, MountainArray A) {
		int low = 0, high = A.length() - 1;
		// Find the peak index
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (A.get(mid) < A.get(mid + 1)) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		int peak = low;

		// Binary search on increasing subarray
		low = 0;
		high = peak;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (A.get(mid) < target) {
				low = mid + 1;
			} else if (A.get(mid) > target) {
				high = mid - 1;
			} else {
				return mid;
			}
		}

		// Binary search on decreasing subarray
		low = peak;
		high = A.length() - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (A.get(mid) < target) {
				high = mid - 1;
			} else if (A.get(mid) > target) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	// mock class of mountain array
	class MountainArray {

		public int length() {
			// TODO Auto-generated method stub
			return 0;
		}

		public int get(int m) {
			// TODO Auto-generated method stub
			return 0;
		}

	}

}
