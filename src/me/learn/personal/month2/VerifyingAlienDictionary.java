/**
 * 
 */
package me.learn.personal.month2;

import java.util.HashMap;
import java.util.Map;

/**
 * Title 953 :
 * 
 * In an alien language, surprisingly they also use english lowercase letters,
 * but possibly in a different order. The order of the alphabet is some
 * permutation of lowercase letters.
 * 
 * Given a sequence of words written in the alien language, and the order of the
 * alphabet, return true if and only if the given words are sorted
 * lexicographicaly in this alien language.
 * 
 * 
 * Example 1:
 * 
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true Explanation: As 'h' comes before 'l' in this language, then the
 * sequence is sorted.
 * 
 * Example 2:
 * 
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false Explanation: As 'd' comes after 'l' in this language, then
 * words[0] > words[1], hence the sequence is unsorted.
 * 
 * 
 * @author bramanarayan
 * @date Aug 15, 2020
 */
public class VerifyingAlienDictionary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		VerifyingAlienDictionary solution = new VerifyingAlienDictionary();
		System.out.println(solution.isAlienSorted(new String[] {"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
		System.out.println(solution.isAlienSorted(new String[] {"apple","app"}, "abcdefghijklmnopqrstuvwxyz"));

	}

	// maintain a map of char -> position (in order required)
	// then try to iterate 2 words at a time until end of the words. 
	// its true cos if a < b and b < c then a < c. so, we will get lexicographic order.
	public boolean isAlienSorted(String[] words, String order) {

		// maintain order here
		Map<Character, Integer> map = new HashMap<Character,Integer>();
		for(int i = 0;i<order.length();i++) {
			char c = order.charAt(i);
			map.put(c, i);
		}

		// here try to iterate
		for(int i = 0; i < words.length-1;i++) {
			if(!compare(map, words[i], words[i+1])) return false;
		}
		
		return true;
		
	}

	private boolean compare(Map<Character,Integer> map, String a, String b) {
		int m = a.length();
		int n = b.length();
		int i = 0, j = 0;
		while(i < m && j <n) {
			
			if(a.charAt(i) != b.charAt(j)) {
				if(map.get(a.charAt(i)) == map.get(b.charAt(j))) {
					i++;
					j++;
				} else if(map.get(a.charAt(i)) < map.get(b.charAt(j))){
					// no need to check more as we found a high priority character in first string. we are good.
					return true;
				} else {
					return false;
				}
			} else {
				i++;
				j++;
			}
			
		}
		if(i < m) return false; // this is reauired because app comes before apple. So in case apple,app -> we need to return false;
		return true;
		
	}

}
