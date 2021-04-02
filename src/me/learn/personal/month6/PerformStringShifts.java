/**
 * 
 */
package me.learn.personal.month6;

/**
 * Title 1427 :
 * 
 * Date : Jan 12, 2021
 * 
 * @author bramanarayan
 *
 */
public class PerformStringShifts {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		PerformStringShifts solution = new PerformStringShifts();
		System.out.println(solution.stringShift("abc", new int[][] { { 0, 1 }, { 1, 2 } }));
	}

	/**
	 * 
	 * Input: s = "abc", shift = [[0,1],[1,2]] Output: "cab" Explanation: [0,1]
	 * means shift to left by 1. "abc" -> "bca" [1,2] means shift to right by 2.
	 * "bca" -> "cab"
	 */

	// you can compute the effective shift pos
	// + for left shift
	// - for right shift
	// compute pos and shift only once
	public String stringShift(String s, int[][] shifts) {
		int len = s.length();

		// imagine like a range line
		int pos = 0;

		for (int[] shift : shifts) {
			pos = pos + (shift[0] == 0 ? shift[1] : -shift[1]);
		}

		// if its -ve then modulo it
		pos = pos % len; // if +ve goes beyond string length. hence, keep it within range
		if (pos < 0) {
			pos = (pos + len);
		}

		System.out.println(s.substring(0, pos + 1));

		return s.substring(pos) + s.substring(0, pos);
	}

}
