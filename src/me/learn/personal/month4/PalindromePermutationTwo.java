/**
 * 
 */
package me.learn.personal.month4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import me.learn.utli.Utils;

/**
 * Title 267 :
 * 
 * Given a string s, return all the palindromic permutations (without
 * duplicates) of it. Return an empty list if no palindromic permutation could
 * be form.
 * 
 * Example 1:
 * 
 * Input: "aabb" Output: ["abba", "baab"]
 * 
 * Example 2:
 * 
 * Input: "abc" Output: []
 * 
 * @author bramanarayan
 * @date Aug 21, 2020
 */
public class PalindromePermutationTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PalindromePermutationTwo solution = new PalindromePermutationTwo();
		System.out.println(solution.generatePalindromes("aabb"));
		System.out.println(solution.generatePalindromes("aab"));

	}

	
	// TAKE HALF ARRAY AND THEN START PERMUTING IT
	// This is a optimized brute force. nothing special in it.
	public List<String> generatePalindromes(String s) {


		Set<String> resultSet = new HashSet<>();
		List<String> result = new ArrayList<>();
		
		if (s == null)
			return result;

		if (s.length() == 1)
			return Arrays.asList(s);

		// maintain a map of character -> count.
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		// track the number of elements with odd count
		// if oddcount > 1 , there is no way you can form a palindrome permutation.
		// While you do it. take half of each character in to StringBuilder
		int oddCount = 0;
		String oddChar = "";
		StringBuilder sb = new StringBuilder();
		for (Entry<Character, Integer> e : map.entrySet()) {
			if (e.getValue() % 2 != 0) {
				oddCount++;
				oddChar = String.valueOf(e.getKey());
			}
			sb.append(fillNTimes(e.getKey(), e.getValue()/2));
		}	
		
		
		if (oddCount > 1)
			return result;
		
		// if not, generate permutation and append reverse and keep going
		String half = sb.toString();
		permute(half.toCharArray(), resultSet, oddChar, 0, half.length());

		return new ArrayList<>(resultSet);

	}

	private char[] fillNTimes(Character key, int n) {
		
		// repeat char n times
		char[] temp = new char[n];
		Arrays.fill(temp, key);
		return temp;
	}

	public void permute(char[] input, Set<String> result, String mid, int i, int n) {
		if (i == n) {
			String temp = new String(input);
			if (isPalindrome(temp + mid + new StringBuilder(temp).reverse().toString())) {
				result.add(temp + mid + new StringBuilder(temp).reverse().toString());
			}

		} else {
			for (int j = i; j < n; j++) {
				Utils.swap(input, i, j);
				permute(input, result, mid, i + 1, n);
				Utils.swap(input, i, j);
			}
		}

	}

	private boolean isPalindrome(String string) {
		int left = 0;
		int right = string.length() - 1;
		while (left < right) {
			if (string.charAt(left) != string.charAt(right)) {
				return false;
			}

			left++;
			right--;
		}

		return true;
	}
}
