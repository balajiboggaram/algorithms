/**
 * 
 */
package me.learn.personal.month5;

import java.util.ArrayList;
import java.util.List;

/**
 * Title 131:
 * 
 * Date : Dec 22, 2020
 * 
 * @author bramanarayan
 *
 */
public class PalindromePartitioning {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		PalindromePartitioning solution = new PalindromePartitioning();
		
		System.out.println(solution.partition("aab"));
	}

	List<List<String>> result = new ArrayList<>();

	// Return the list of all possible palindromes
	public List<List<String>> partition(String s) {

		dfs(s, 0, new ArrayList<String>());
		return result;
	}

	private void dfs(String s, int start, ArrayList<String> temp) {
		
		if(start == s.length()) { 
			result.add(new ArrayList<String>(temp));
		}
		
		for(int i = start;i< s.length(); i++) {
			if(isPalindrome(s, start, i)) {
				temp.add(s.substring(start, i+1));
				dfs(s, i+1, temp);
				temp.remove(temp.size()-1);
			}
		}
		
		
	}

	private boolean isPalindrome(String s, int start, int end) {
		int lo = start;
		int high  = end;
		while (lo <= high) {
			if(s.charAt(lo) != s.charAt(high)) return false;
			lo++;
			high--;
		}
		return true;	
	}
}
