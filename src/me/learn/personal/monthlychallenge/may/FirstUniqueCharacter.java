package me.learn.personal.monthlychallenge.may;

import java.util.LinkedHashSet;

/**
 * 
 * Title : First Unique Character in a String
 * 
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 * 
 * @author bramanarayan
 * @date May 5, 2020
 */
public class FirstUniqueCharacter {

	public static void main(String args[]) {
		FirstUniqueCharacter solution = new FirstUniqueCharacter();
		System.out.println(solution.firstUniqChar("leetcode"));
		System.out.println(solution.firstUniqChar("loveleetcode"));
		System.out.println(solution.firstUniqChar("cc"));

	}

	public int firstUniqChar(String s) {

		if (s == null)
			return -1;
		if (s.isEmpty())
			return -1;

		LinkedHashSet<Character> s1 = new LinkedHashSet<Character>();
		LinkedHashSet<Character> repeat = new LinkedHashSet<Character>();

		for (char c : s.toCharArray()) {

			if (!repeat.contains(c)) {
				if (s1.contains(c)) {
					// remove and add to repeat set
					s1.remove(c);
					repeat.add(c);
				} else {
					s1.add(c);
				}
			}

		}
		return s1.isEmpty() ? -1 : s.indexOf(s1.stream().findFirst().get());
	}

}
