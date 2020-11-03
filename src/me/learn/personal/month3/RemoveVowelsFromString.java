/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title 1119 :
 * 
 *  Given a string S, remove the vowels 'a', 'e', 'i', 'o', and 'u' from it, and return the new string.

Example 1:

Input: "leetcodeisacommunityforcoders"
Output: "ltcdscmmntyfrcdrs"

Example 2:

Input: "aeiou"
Output: ""

 * 
 * @author bramanarayan
 * @date Jun 26, 2020
 */
public class RemoveVowelsFromString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RemoveVowelsFromString solution = new RemoveVowelsFromString();
		System.out.println(solution.removeVowels("leetcodeisacommunityforcoders"));
	}

	public String removeVowels(String s) {
		s = s.replaceAll("[aeiou]", "");
		return s;
	}

}
