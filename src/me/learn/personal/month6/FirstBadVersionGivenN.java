/**
 * 
 */
package me.learn.personal.month6;

/**
 * Title 278 :
 * 
 * Date : Jan 15, 2021
 * 
 * @author bramanarayan
 *
 */
public class FirstBadVersionGivenN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int firstBadVersion(int n) {

		if (n < 2 && isBadVersion(n))
			return n;

		int low = 0, high = n;
		int mid = 0;

		while (low <= high) {
			
			mid = low + (high - low) / 2;

			if (isBadVersion(mid) && !isBadVersion(mid - 1)) {
				System.out.println(mid);
				return mid;
			} else if (isBadVersion(mid)) {
				high = mid;
			} else {
				low = mid + 1;
			}

		}
		return 0;
	}

	// mock
	private boolean isBadVersion(int mid) {
		return true;
	}

}
