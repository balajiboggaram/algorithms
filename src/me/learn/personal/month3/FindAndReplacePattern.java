/**
 * 
 */
package me.learn.personal.month3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Title 890 : 
 * 
 * You have a list of words and a pattern, and you want to know
 * which words in words matches the pattern.
 * 
 * A word matches the pattern if there exists a permutation of letters p so that
 * after replacing every letter x in the pattern with p(x), we get the desired
 * word.
 * 
 * (Recall that a permutation of letters is a bijection from letters to letters:
 * every letter maps to another letter, and no two letters map to the same
 * letter.)
 * 
 * Return a list of the words in words that match the given pattern.
 * 
 * You may return the answer in any order.
 * 
 * Example 1:
 * 
 * Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb" 
 * 
 * Output:
 * ["mee","aqq"] Explanation: "mee" matches the pattern because there is a
 * permutation {a -> m, b -> e, ...}. "ccc" does not match the pattern because
 * {a -> c, b -> c, ...} is not a permutation, since a and b map to the same
 * letter.
 * 
 * 
 * @author bramanarayan
 * @date Jun 25, 2020
 */
public class FindAndReplacePattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindAndReplacePattern solution = new FindAndReplacePattern();
		System.out.println(solution.findAndReplacePattern(new String[] {"abc","deq","mee","aqq","dkd","ccc"}, "abb"));
	}

	public List<String> findAndReplacePattern(String[] words, String pattern) {
		
		
		char[] pat = pattern.toCharArray();
		List<String> result = new ArrayList<String>();
		
		for(String w : words) {
			if(match(w.toCharArray(), pat)) {
				result.add(w);
			}
		}
		
		return result;
	}

	private boolean match(char[] word, char[] pat) {

		int m = word.length;
		int n = pat.length;

		if (m != n)
			return false;                          

		// Start with the pattern and create a mapping
		Map<Character, Character> mapping = new HashMap<Character, Character>();
		Set<Character> reverseSet = new HashSet<Character>();
		for (int i = 0; i < n; i++) {
			char w = word[i];
			char p = pat[i];
			
			
			// To detect if there exists any multiple mappings to pattern character.
			if(!mapping.containsKey(p) && reverseSet.contains(w)) 
				return false;
		
			// if the mapping is not established yet, then please add it
			if (!mapping.containsKey(p) && !reverseSet.contains(w)) {
				mapping.put(p, w); // p-> w always
				reverseSet.add(w); // add this in to reverse set so there wont be any multiple mappings.
			} else {
				if(mapping.get(p) != w) return false;
			}
		}
		return true;
	}

}
