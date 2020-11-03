/**
 * 
 */
package me.learn.personal.month4;

/**
 * Title 1221 :
 * 
 * Balanced strings are those who have equal quantity of 'L' and 'R' characters.
 * 
 * Given a balanced string s split it in the maximum amount of balanced strings.
 * 
 * Return the maximum amount of splitted balanced strings.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "RLRRLLRLRL" Output: 4 Explanation: s can be split into "RL",
 * "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
 * 
 * Example 2:
 * 
 * Input: s = "RLLLLRRRLR" Output: 3 Explanation: s can be split into "RL",
 * "LLLRRR", "LR", each substring contains same number of 'L' and 'R'.
 * 
 * Example 3:
 * 
 * Input: s = "LLLLRRRR" Output: 1 Explanation: s can be split into "LLLLRRRR".
 * 
 * 
 * @author bramanarayan
 * @date Jul 22, 2020
 */
public class SplitStringForMaxBalancedStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int balancedStringSplit(String s) {

		if (s == null)
			return 0;
		int n = s.length();
		int countL = 0;
		int countR = 0;

		int result = 0;
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == 'L') {
				countL++;
			} else if (s.charAt(i) == 'R') {
				countR++;
			}

			if (countL == countR) {
				result++;
			}

		}
		return result;

	}

}
