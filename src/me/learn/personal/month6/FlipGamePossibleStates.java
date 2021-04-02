/**
 * 
 */
package me.learn.personal.month6;

import java.util.ArrayList;
import java.util.List;

/**
 * Title 293 :
 * 
 * Date : Jan 15, 2021
 * 
 * @author bramanarayan
 *
 */
public class FlipGamePossibleStates {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// a player can flip ++ to --
	// Return all the possible flip states possible
	public List<String> generatePossibleNextMoves(String s) {

		int n = s.length();
		List<String> result = new ArrayList<String>();

		for (int i = 0; i < n - 1; i++) {
			if (s.startsWith("++", i)) {
				result.add(s.substring(0, i) + "--" + s.substring(i + 2));
			}
		}
		return result;

	}

}
