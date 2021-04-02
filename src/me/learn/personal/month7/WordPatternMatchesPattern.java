/**
 * 
 */
package me.learn.personal.month7;

import java.util.HashMap;
import java.util.Map;

/**
 * Title 291 :
 * 
 * Date : Feb 26, 2021
 * 
 * @author bramanarayan
 *
 */
public class WordPatternMatchesPattern {

	public class Solution {
		
		// Store char -> word (mapping)
		Map<Character, String> map = new HashMap<Character, String>();

		// Every recursion, you cut the pattern length and str length. by taking substrings
		public boolean wordPatternMatch(String pattern, String str) {
			
			if (pattern.length() == 0)
				return str.length() == 0;
			
			// Always take the first character and see - if we have the mapping of this char before abab , the second a would have a mapping already
			if (map.containsKey(pattern.charAt(0))) {
				
				String value = map.get(pattern.charAt(0));
				// if the char -> word mapping do not match.  then return false
				if (value.length() > str.length() || !str.substring(0, value.length()).equals(value))
					return false;

				// so it matches, hence call recursively here . chop one char from pattern and value.length from beginning of the str.
				if (wordPatternMatch(pattern.substring(1), str.substring(value.length())))
					return true;
			
			} else {
				// Lets say this is a new character , no mapping exists in the map , we are seeing this pattern char for the first time.
				for (int i = 1; i <= str.length(); i++) {
					
					if (map.containsValue(str.substring(0, i)))
						continue;
					
					map.put(pattern.charAt(0), str.substring(0, i));
					
					if (wordPatternMatch(pattern.substring(1), str.substring(i))) {
						return true;
					}
					
					map.remove(pattern.charAt(0)); // remove the mapping as it was not coorect mapping.
				}
			}
			return false;
		}
	}
}
