/**
 * 
 */
package me.learn.personal.month4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Title 316 :
 * 
 * Given a string which contains only lowercase letters, remove duplicate
 * letters so that every letter appears once and only once. You must make sure
 * your result is the smallest in lexicographical order among all possible
 * results.
 * 
 * Example 1:
 * 
 * Input: "bcabc" Output: "abc"
 * 
 * Example 2:
 * 
 * Input: "cbacdcbc" Output: "acdb"
 * 
 * 
 * @author bramanarayan
 * @date Jul 27, 2020
 */
public class RemoveDuplicateLetters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		RemoveDuplicateLetters solution = new  RemoveDuplicateLetters();
		System.out.println(solution.removeDuplicateLetters("bcabc"));
	}

	// SAME as lexicographically shortest uncommon subsequence containing all
	// characters
	// tricky , need revision again
	public String removeDuplicateLetters(String s) {

		Map<Character, Integer> count = new HashMap<>();
		//Map<Character, Boolean> visited = new HashMap<>(); // maintain a hash set here
		Set<Character> visited = new HashSet<Character>();
		int n = s.length();

		// prepare the count map
		for (char c : s.toCharArray()) {
			count.put(c, count.getOrDefault(c, 0) + 1);
		}

		// check if I can get a smallest char with the help of stack
		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < n; i++) {

			char ch = s.charAt(i); // the current character

			count.put(ch, count.get(ch)-1); // decrement counter as processed
			if (visited.contains(ch))
				continue; // this character is already recorded - with leftmost position. so no need to
							// track again, contniue
			
			if(!st.isEmpty())

			
			// > 0 becuase we ensure that there is atleast one more character (i.e top of stack) that 
			// will come later in the string. So its ok to remove/ignore this one for to get a better
			// lexicographic string for us.
			while(!st.isEmpty() && ch -'a' < st.peek()-'a' && count.get(st.peek()) > 0) {
				char temp = st.pop();
				visited.remove(temp);
			}
			
			visited.add(ch);
			st.push(ch);

		}
		
		// capture result via SB
		StringBuilder sb = new StringBuilder();
		while(!st.isEmpty()) {
			sb.append(st.pop());
		}
		
		return sb.reverse().toString();

	}

}
