/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title 443 :
 * 
 * Given an array of characters, compress it in-place.
 * 
 * The length after compression must always be smaller than or equal to the
 * original array.
 * 
 * Every element of the array should be a character (not int) of length 1.
 * 
 * After you are done modifying the input array in-place, return the new length
 * of the array.
 * 
 * 
 * Follow up: Could you solve it using only O(1) extra space?
 * 
 * 
 * Example 1:
 * 
 * Input: ["a","a","b","b","c","c","c"]
 * 
 * Output: Return 6, and the first 6 characters of the input array should be:
 * ["a","2","b","2","c","3"]
 * 
 * Explanation: "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is
 * replaced by "c3".
 * 
 * 
 * 
 * @author bramanarayan
 * @date Jul 12, 2020
 */
public class StringCompression {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringCompression solution = new StringCompression();
		System.out.println(solution.compress(new char[] {'a','a','b','b','c','c','c'}));
	}

	public int compress(char[] c) {

		int n = c.length;
		int i = 0;
		StringBuilder sb = new StringBuilder();

		while (i < n) {

			int count = 0, j = i;

			while (j < n && c[j] == c[i]) {
				j++;
			}

			count = j - i;
			sb.append(c[i]);
			if (count > 1) {
				sb.append(count);
			}

			i = j;
		}
		System.out.println(sb.toString());
		c = sb.toString().toCharArray();
		return sb.length();

	}

}
