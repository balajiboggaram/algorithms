/**
 * 
 */
package me.learn.personal.month3;

import java.util.Arrays;

/**
 * Title 395 :
 * 
 * Date : Jan 6, 2021
 * 
 * @author bramanarayan
 *
 */
public class LongestSubstringFreqAtleastK {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// beautiful sliding window algorithm
	public int longestSubstring(String s, int k) {
		char[] str = s.toCharArray();
		int[] countMap = new int[26];
		int maxUnique = getMaxUniqueLetters(s);
		int result = 0;
		
		// from 1 unique , 2 unique, 3 unique upuntil max UNique
		
		for (int requiredUnique = 1; requiredUnique <= maxUnique; requiredUnique++) {
		
			// reset countMap
			Arrays.fill(countMap, 0);
			
			int start = 0, j = 0, idx = 0;
		     int uniqueFormed = 0, countAtLeastK = 0; // j -> end a running pointer
			
			
			while (j < str.length) {
				
				// expand the sliding window, use hashMap . its lot more readable
				if (uniqueFormed <= requiredUnique) {
					
					idx = str[j] - 'a';
					
					if (countMap[idx] == 0) {
						uniqueFormed++;						
					}
					
					countMap[idx]++;
					
					if (countMap[idx] == k) {
						countAtLeastK++;						
					}
					
					j++;
				}
				
				
				// SHRINK SLIDING WINDOW
				else {
					idx = str[start] - 'a';
					if (countMap[idx] == k)
						countAtLeastK--;
					countMap[idx]--;
					if (countMap[idx] == 0)
						uniqueFormed--;
					start++;
				}
				
				
				if (uniqueFormed == requiredUnique && uniqueFormed == countAtLeastK)
					result = Math.max(j - start, result);
			}
		}

		return result;
	}

	// get the maximum number of unique letters in the string s
	int getMaxUniqueLetters(String s) {
		boolean map[] = new boolean[26];
		int maxUnique = 0;
		for (int i = 0; i < s.length(); i++) {
			if (!map[s.charAt(i) - 'a']) {
				maxUnique++;
				map[s.charAt(i) - 'a'] = true;
			}
		}
		return maxUnique;
	}

}
