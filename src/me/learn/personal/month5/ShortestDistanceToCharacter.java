/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 821 :
 * 
 * Date : Dec 30, 2020
 * 
 * @author bramanarayan
 *
 */
public class ShortestDistanceToCharacter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] shortestToChar(String s, char c) {

		int n = s.length();
		int[] result = new int[n];

		int prev = -1; // last e seen
		int lastNonC = 0;

		for (int i = 0; i < n; i++)
			if (s.charAt(i) == c) {
				while (lastNonC <= i) {
					result[lastNonC] = Math.min(result[lastNonC], i - lastNonC);
					lastNonC++;
				}
				prev = i;
			} else {
				result[i] = prev != -1 ? i - prev : Integer.MAX_VALUE;				
			}

		return result;
	}


}
