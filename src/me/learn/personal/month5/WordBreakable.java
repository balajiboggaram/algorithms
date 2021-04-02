/**
 * 
 */
package me.learn.personal.month5;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Title :
 * 
 * Date : Dec 23, 2020
 * 
 * @author bramanarayan
 *
 */
public class WordBreakable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> wordDictSet = new HashSet<>(wordDict);
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}

}
