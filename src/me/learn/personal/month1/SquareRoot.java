package me.learn.personal.month1;

/**
 * 
 * Title : Implement int sqrt(int x).
 * 
 * Compute and return the square root of x, where x is guaranteed to be a
 * non-negative integer.
 * 
 * Since the return type is an integer, the decimal digits are truncated and
 * only the integer part of the result is returned.
 * 
 * @author bramanarayan
 * @date May 11, 2020
 */
public class SquareRoot {
	public static void main(String args[]) {
		SquareRoot solution = new SquareRoot();
		// System.out.println(solution.mySqrt(36));
		// System.out.println(solution.mySqrt(39));
		// System.out.println(solution.mySqrt(41));
		/// System.out.println(solution.mySqrt(51));
		System.out.println(solution.mySqrt(4));
		// System.out.println(solution.mySqrt(64));
		// System.out.println(solution.mySqrt(2147395599));

	}

	public int mySqrt(int x) {
		if (x == 0)
			return 0;
		int low = 1, high = x;
		while (low < high) {
			int mid = low + (high - low) / 2;
			// Look for the critical point: i * i <= x && (i+1)(i+1) > x
			// A little trick is using i <= x / i for comparison, instead of i * i <= x, to
			// avoid exceeding integer upper limit.
			if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
				return mid;
			} else if (mid > x / mid) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}
}
