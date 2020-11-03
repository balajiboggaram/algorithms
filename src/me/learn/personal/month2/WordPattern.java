/**
 * 
 */
package me.learn.personal.month2;

import java.util.HashMap;
import java.util.Map;

/**
 * Title 290 :
 * 
 * @author bramanarayan
 * @date Aug 17, 2020
 */
public class WordPattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WordPattern solution = new WordPattern();
		System.out.println(solution.wordPattern("abba", "dog cat cat dog"));
		
	}

	public boolean wordPattern(String pattern, String text) {
		String[] token = text.split("\\s+");
		int i = 0, j = 0, m = pattern.length(), n = token.length;

		if( m != n) return false;
		
		Map<Character, String> sMap = new HashMap<>();
		Map<String, Character> tMap = new HashMap<>();
		
		
		while(i < m && j < n) {
			char sChar = pattern.charAt(i);
			String tString = token[j];
			
			if(sMap.containsKey(sChar) && !sMap.get(sChar).equals(tString)) return false;
			if(tMap.containsKey(tString) && tMap.get(tString) != sChar) return false; // required as take example ab with "a a"
			
			sMap.put(sChar, tString);
			tMap.put(tString, sChar);
			i++;
			j++;
		}
		
		return true;
		
	}

}
