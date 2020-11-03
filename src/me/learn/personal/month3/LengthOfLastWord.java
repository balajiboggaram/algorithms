/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title 58 :
 * 
 *  Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.

If the last word does not exist, return 0.

Note: A word is defined as a maximal substring consisting of non-space characters only.

Example:

Input: "Hello World"
Output: 5

 * 
 * @author bramanarayan
 * @date Jun 29, 2020
 */
public class LengthOfLastWord {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LengthOfLastWord solution = new LengthOfLastWord();
		System.out.println(solution.lengthOfLastWord("Hello World"));
		System.out.println(solution.lengthOfLastWord("a "));
		System.out.println(solution.lengthOfLastWord(" "));

	}

	public int lengthOfLastWord(String s) {
		
		s = s.trim();
		
		if(s.isEmpty()) return 0;
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if(!Character.isWhitespace(s.charAt(i))) { 
				count++;
			} else {
				count = 0;
			}
		}
		
		return count;
	}
}
