package me.learn.personal.monthlychallenge.may;

/**
 * 
 * Title : You are a product manager and currently leading a team to develop a
 * new product. Unfortunately, the latest version of your product fails the
 * quality check. Since each version is developed based on the previous version,
 * all the versions after a bad version are also bad.
 * 
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first
 * bad one, which causes all the following ones to be bad.
 * 
 * You are given an API bool isBadVersion(version) which will return whether
 * version is bad. Implement a function to find the first bad version. You
 * should minimize the number of calls to the API.
 * 
 * @author bramanarayan
 * @date May 1, 2020
 */
public class FirstBadVersion {

	int badVersion;

	public FirstBadVersion(int badVersion) {
		this.badVersion = badVersion;
	}

	public static void main(String args[]) {
		FirstBadVersion solution = new FirstBadVersion(2);
		// solution.firstBadVersion(5);
		// solution.firstBadVersion(2126753390);
		solution.firstBadVersion(2);

	}

	/**
	 * Binary Implementation.
	 */
	public int firstBadVersion(int n) {

		// only one version available - and that is bad.
		if (n < 2 && isBadVersion(n))
			return n;

		int low = 0, high = n;
		int mid = 0;

		while (low <= high) {
			mid = low + (high - low) / 2;
			if (isBadVersion(mid) && !isBadVersion(mid - 1)) {
				return mid;
			} else if (isBadVersion(mid)) {
				high = mid;
			} else {
				low = mid + 1;
			}

		}
		return 0;
	}

	/**
	 * Linear Implementation. But we can solve this in log(n) using binary search
	 */
	public int firstBadVersionLinear(int n) {

		for (int i = n; i > 0; i--) {
			boolean currentVersion = isBadVersion(i);
			boolean previousVersion = isBadVersion(i - 1);
			if (previousVersion == false && currentVersion == true) {
				System.out.println("Bad Version : " + i);
				return i;
			}
		}
		return 0;
	}

	public boolean isBadVersion(int n) {
		return n >= badVersion;
	}

}
