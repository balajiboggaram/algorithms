/**
 * 
 */
package me.learn.personal.month3;

import java.util.HashSet;
import java.util.Set;

/**
 * Title 804 :
 * 
 * International Morse Code defines a standard encoding where each letter is
 * mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps
 * to "-...", "c" maps to "-.-.", and so on.
 * 
 * For convenience, the full table for the 26 letters of the English alphabet is
 * given below:
 * 
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * 
 * Now, given a list of words, each word can be written as a concatenation of
 * the Morse code of each letter. For example, "cab" can be written as
 * "-.-..--...", (which is the concatenation "-.-." + ".-" + "-..."). We'll call
 * such a concatenation, the transformation of a word.
 * 
 * Return the number of different transformations among all words we have.
 * 
 * Example: Input: words = ["gin", "zen", "gig", "msg"] Output: 2 Explanation:
 * The transformation of each word is: "gin" -> "--...-." "zen" -> "--...-."
 * "gig" -> "--...--." "msg" -> "--...--."
 * 
 * There are 2 different transformations, "--...-." and "--...--.".
 * 
 * 
 * @author bramanarayan
 * @date Jul 16, 2020
 */
public class UniqueMoorseCode {

	String[] codes = new String[] { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
			".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
			"--.." };

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UniqueMoorseCode solution = new UniqueMoorseCode();
		System.out.println(solution.uniqueMorseRepresentations(new String[] {"gin", "zen", "gig", "msg"}));
	}

	// SIMPLE SET
	public int uniqueMorseRepresentations(String[] words) {

		Set<String> set = new HashSet<String>();
		for (String s : words) {
			set.add(getMoorseCode(s));
		}
		return set.size();
	}

	private String getMoorseCode(String s) {
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) {
			sb.append(codes[c - 'a']);
		}
		return sb.toString();

	}

}
