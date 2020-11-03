/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title 541 :
 * 
 * Given a string and an integer k, you need to reverse the first k characters
 * for every 2k characters counting from the start of the string. If there are
 * less than k characters left, reverse all of them. If there are less than 2k
 * but greater than or equal to k characters, then reverse the first k
 * characters and left the other as original.
 * 
 * Example:
 * 
 * Input: s = "abcdefg", k = 2 Output: "bacdfeg"
 * 
 * Restrictions:
 * 
 * The string consists of lower English letters only. Length of the given string
 * and k will in the range [1, 10000]
 * 
 * 
 * @author bramanarayan
 * @date Jul 21, 2020
 */
public class ReverseStringTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReverseStringTwo solution = new ReverseStringTwo();
		System.out.println(solution.reverseStr("abcdefg", 2));
	}

	public String reverseStr(String s, int k) {
		int n = s.length();
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i < n) {
			// reverse k characters
			int j = i + k < n ? i + k : n;
			String reverse = new StringBuilder().append(s.substring(i, j)).reverse().toString();
			sb.append(reverse);

			if (j >= n)
				break; // nothing to skip. done done

			// skip k characters
			i = j;
			j = i + k < n ? i + k : n;
			String noReverse = s.substring(i, j);
			sb.append(noReverse);

			i = j;
		}

		return sb.toString();
	}

}
