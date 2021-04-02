/**
 * 
 */
package me.learn.personal.month6;

import java.util.HashMap;

/**
 * Title 294 :
 * 
 * Date : Jan 15, 2021
 * 
 * @author bramanarayan
 *
 */
public class FlipGamePlusMinusCanWin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// game theory - similar to CanIWin problem

	// The idea is try to replace every "++" in the current string s to "--" and see
	// if the opponent can win or not, if the opponent cannot win, great, we win!
	public boolean canWin(String s) {
		if (s == null || s.length() < 2) {
			return false;
		}
		HashMap<String, Boolean> winMap = new HashMap<String, Boolean>();
		return canWinUtil(s, winMap);
	}

	public boolean canWinUtil(String s, HashMap<String, Boolean> winMap) {

		// you already solved result for this string, so return answer
		if (winMap.containsKey(s)) {
			return winMap.get(s);
		}

		// this is trying all possible options
		for (int i = 0; i < s.length() - 1; i++) {
			
			// My turn - I will change it
			if (s.startsWith("++", i)) { // do you see ++ from i index ?
				
				// Possibles States for the next player - opponent
				String t = s.substring(0, i) + "--" + s.substring(i + 2); // if so create a new string by replacing it
																			// with --
				if (!canWinUtil(t, winMap)) {
					
					// If opponent cannot win, then I will win
					winMap.put(s, true);
					
					return true;
				}
			}
		}
		winMap.put(s, false);
		return false;
	}

}
