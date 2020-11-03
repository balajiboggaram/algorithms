/**
 * 
 */
package me.learn.personal.month2;

/**
 * Title 1446 : 
 * 
 *  Given a string s, the power of the string is the maximum length of a non-empty substring that contains only one unique character.

Return the power of the string.

Example 1:

Input: s = "leetcode"
Output: 2
Explanation: The substring "ee" is of length 2 with the character 'e' only.

 * 
 * @author bramanarayan
 * @date Jun 11, 2020
 */
public class ConsecutiveCharacters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ConsecutiveCharacters solution = new ConsecutiveCharacters();
		System.out.println(solution.maxPower("leetcode"));
		System.out.println(solution.maxPower("abbcccddddeeeeedcba"));
		System.out.println(solution.maxPower("hooraaaaaaaaaaay"));

	}

	// TWO RUNNING POINTERS
	public int maxPower(String s) {
		
		
		char[] a = s.toCharArray();
		int n = a.length;
		int i = 0, j = 0;
		int maxCount = 0;
		while (j < n) {
			if (a[j] == a[i]) {
				maxCount = Math.max(maxCount, j - i + 1);
				j++;
			} else {
				i = j;
			}
		}
		return maxCount;
	}

}
