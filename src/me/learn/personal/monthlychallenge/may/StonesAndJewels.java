package me.learn.personal.monthlychallenge.may;

import java.util.HashSet;

/**
 * 
 * Title : You're given strings J representing the types of stones that are
 * jewels, and S representing the stones you have. Each character in S is a type
 * of stone you have. You want to know how many of the stones you have are also
 * jewels.
 * 
 * The letters in J are guaranteed distinct, and all characters in J and S are
 * letters. Letters are case sensitive, so "a" is considered a different type of
 * stone from "A".
 * 
 * @author bramanarayan
 * @date May 2, 2020
 */
public class StonesAndJewels {

	public static void main(String args[]) {
		StonesAndJewels solution = new StonesAndJewels();
		solution.numJewelsInStones("aA", "aAAbbbb");
		solution.numJewelsInStones("z", "ZZ");

	}

	/**
	 * This uses a simple hash set. However
	 * 
	 * Note that we can also solve this using constant space. 
	 * Like pick two integers - which can trach upper case and lower case character.
	 * 
	 * All that we need is 
	 * 1. set a bit on characters seen in J string 
	 * 2. Check a
	 * bit on characters seen in S string
	 */
	public int numJewelsInStones(String J, String S) {
		HashSet<Character> set = new HashSet<Character>();
		int result = 0;

		if (J == null || S == null)
			return result;

		for (char c : J.toCharArray()) {
			set.add(c);
		}

		for (char c : S.toCharArray()) {
			if (set.contains(c)) {
				result++;
			}
		}
		System.out.println(result);
		return result;
	}

}
