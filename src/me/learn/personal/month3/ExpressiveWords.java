/**
 * 
 */
package me.learn.personal.month3;

import java.util.ArrayList;
import java.util.List;

/**
 * Title 809 : 
 * 
 *  Sometimes people repeat letters to represent extra feeling, such as "hello" -> "heeellooo", "hi" -> "hiiii".  In these strings like "heeellooo", we have groups of adjacent letters that are all the same:  "h", "eee", "ll", "ooo".

For some given string S, a query word is stretchy if it can be made to be equal to S by any number of applications of the following extension operation: choose a group consisting of characters c, and add some number of characters c to the group so that the size of the group is 3 or more.

For example, starting with "hello", we could do an extension on the group "o" to get "hellooo", but we cannot get "helloo" since the group "oo" has size less than 3.  Also, we could do another extension like "ll" -> "lllll" to get "helllllooo".  If S = "helllllooo", then the query word "hello" would be stretchy because of these two extension operations: query = "hello" -> "hellooo" -> "helllllooo" = S.

Given a list of query words, return the number of words that are stretchy. 

 

Example:
Input: 
S = "heeellooo"
words = ["hello", "hi", "helo"]
Output: 1
Explanation: 
We can extend "e" and "o" in the word "hello" to get "heeellooo".
We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or more.

 

Constraints:

    0 <= len(S) <= 100.
    0 <= len(words) <= 100.
    0 <= len(words[i]) <= 100.
    S and all words in words consist only of lowercase letters


 * 
 * @author bramanarayan
 * @date Jun 30, 2020
 */
public class ExpressiveWords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ExpressiveWords solution = new ExpressiveWords();
		System.out.println(solution.expressiveWords("heeellooo", new String[] {"hello","hi", "helo"}));
		System.out.println(solution.expressiveWords("aaa", new String[] {"aaaa"})); // some crappy test case

	}

	// RUN LENGTH ENCODING
	// Googles Favorite Problem
	public int expressiveWords(String s, String[] words) {

		RunLengthInfo runInfo = computeRunLengthEncoding(s);
		
		int keySize = runInfo.runLength.size();
		
		int count = 0; // total number of expressive words found so far.
		for(String word : words) {
			
 			RunLengthInfo tempInfo = computeRunLengthEncoding(word);
		
			// This cannot be an expressive word as they differ in the key
			if(!tempInfo.key.equals(runInfo.key))
				continue;
			
			for(int i = 0; i < keySize; i++) {
				int c1 = runInfo.runLength.get(i);
				int c2 = tempInfo.runLength.get(i);
				
				
				// you can never have less than 3 in main string.
				// if its less than 3 then the count shoudl always match
				// c2 > c1 is for crappy test case :-)
				if((c1 < 3 && c1 != c2) || (c2 > c1) ){
					break;
				}
				
				if(i == keySize-1) {
					count++; // Hurray we found an expressive word here.
				}
			}
			
			
		}
		
		return count;
		
	}
	
	RunLengthInfo computeRunLengthEncoding(String s) {
		
		StringBuilder sb = new StringBuilder();
		int n = s.length();
		int count  = 1, i =0;
		List<Integer> list = new ArrayList<Integer>();
		while (i+1 < n) {
			if(s.charAt(i) == s.charAt(i+1)) {
				count++;
			} else {
				sb.append(s.charAt(i));
				list.add(count);
				count = 1;
			}
			i++;
		}
		
		if(i == n-1) {
			sb.append(s.charAt(i));
			list.add(count);
		}
		return new RunLengthInfo(sb.toString(), list);
	}

}

// An auxiliary class to avoid multiple traversals.
class RunLengthInfo {
	
	public RunLengthInfo(String key, List<Integer> runLength) {
		this.key = key;
		this.runLength = runLength;
	}
	String key; 
	List<Integer> runLength;
		
}