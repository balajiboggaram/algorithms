/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 1165 :
 * 
 * Date : Jan 6, 2021
 * 
 * @author bramanarayan
 *
 */
public class SingleRowKeyBoardStokeDistance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SingleRowKeyBoardStokeDistance solution = new SingleRowKeyBoardStokeDistance();
		System.out.println(solution.calculateTime("abcdefghijlmnopqrstuvwxyz", "cba"));
	}

	public int calculateTime(String keyboard, String word) {

		if (word.length() == 0)
			return 0;

		int distance = 0;
		int prevIndex = keyboard.indexOf(word.charAt(0));
		distance = prevIndex - 0;
		for (int i = 1; i < word.length(); i++) {
			int curIndex = keyboard.indexOf(word.charAt(i));
			distance += Math.abs(prevIndex - curIndex);
			prevIndex = curIndex;
		}

		return distance;
	}

}
