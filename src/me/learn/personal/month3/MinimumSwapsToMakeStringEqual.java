/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title 1247 :
 * 
 * You are given two strings s1 and s2 of equal length consisting of letters "x"
 * and "y" only. Your task is to make these two strings equal to each other. You
 * can swap any two characters that belong to different strings, which means:
 * swap s1[i] and s2[j].
 * 
 * Return the minimum number of swaps required to make s1 and s2 equal, or
 * return -1 if it is impossible to do so.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s1 = "xx", s2 = "yy" Output: 1 Explanation: Swap s1[0] and s2[1], s1 =
 * "yx", s2 = "yx".
 * 
 * Example 2:
 * 
 * Input: s1 = "xy", s2 = "yx" Output: 2 Explanation: Swap s1[0] and s2[0], s1 =
 * "yy", s2 = "xx". Swap s1[0] and s2[1], s1 = "xy", s2 = "xy". Note that you
 * can't swap s1[0] and s1[1] to make s1 equal to "yx", cause we can only swap
 * chars in different strings.
 * 
 * @author bramanarayan
 * @date Jun 29, 2020
 */
public class MinimumSwapsToMakeStringEqual {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MinimumSwapsToMakeStringEqual solution = new MinimumSwapsToMakeStringEqual();
		System.out.println(solution.minimumSwap("xx", "yy"));
		System.out.println(solution.minimumSwap("xy", "yx"));
		System.out.println(solution.minimumSwap("xxyyxyxyxx", "xyyxyxxxyx"));

	}

	// 2 CASE PROBLEM
	// case 1 : xx and yy - 1 swap required
	// case 2 : xy and yx - 2 swaps required
	public int minimumSwap(String s1, String s2) {

		// count the numbers of x and y in both the string
		int x1 = 0, x2 = 0;
		int y1 = 0, y2 = 0;

		for (int i = 0; i < s1.length(); i++) {

			// Completely IGNORE the characters which are same in their positions
			if (s1.charAt(i) == s2.charAt(i))
				continue;

			if (s1.charAt(i) == 'x') {
				x1++;
			} else {
				y1++;
			}

			if (s2.charAt(i) == 'x') {
				x2++;
			} else {
				y2++;
			}
		}

		// if its not even number - then there is no solution
		if ((x1 + x2) % 2 != 0 || (y1 + y2) % 2 != 0) {
			return -1;
		}

		// Now after you find the x1,y1, x2 and y2.
		// we can deduce the results of counts to the above two cases

		return x1 / 2 + y1 / 2 + (x1 % 2) * 2;

		// case 1 : x1/2 + y1/2 i.e x pairs and y pairs - here only one swap is required
		// case 2 : x1 % 2 i.e left out odd number of x or ys . so 2 swaps required
		// here.

	}
}
