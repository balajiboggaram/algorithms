/**
 * 
 */
package me.learn.personal.month4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Title 520 : 
 * 
 * Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

    All letters in this word are capitals, like "USA".
    All letters in this word are not capitals, like "leetcode".
    Only the first letter in this word is capital, like "Google".

Otherwise, we define that this word doesn't use capitals in a right way.

 

Example 1:

Input: "USA"
Output: True

 

Example 2:

Input: "FlaG"
Output: False

 * 
 * @author bramanarayan
 * @date Aug 6, 2020
 */
public class DetectCapital {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DetectCapital solution = new DetectCapital();
		System.out.println(solution.detectCapitalUse("USA"));
		System.out.println(solution.detectCapitalUse("usa"));
		System.out.println(solution.detectCapitalUse("usA"));

	}

	public boolean detectCapitalUse(String word) {
		String pattern = "[A-Z][A-Z]+|[A-Z][a-z]+|[a-z]+";
		Pattern p = Pattern.compile(pattern);
		return p.matcher(word).matches(); 
	}

}
