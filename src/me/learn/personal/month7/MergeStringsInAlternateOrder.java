/**
 * 
 */
package me.learn.personal.month7;

/**
 * Title 1768 :
 * 
 * Date : Feb 25, 2021
 * 
 * @author bramanarayan
 *
 */
public class MergeStringsInAlternateOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String mergeAlternately(String word1, String word2) {

		int m = word1.length();
		int n = word2.length();

		StringBuilder sb = new StringBuilder();

		int i = 0, j = 0;
		while (i < m && j < n) {
			sb.append(word1.charAt(i++));
			sb.append(word2.charAt(j++));
		}

		while (i < m) {
			sb.append(word1.charAt(i++));

		}

		while (j < n) {
			sb.append(word2.charAt(j++));

		}

		return sb.toString();

	}
}
