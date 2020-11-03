/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title 151 :
 * 
 * Given an input string, reverse the string word by word.
 * 
 * Example 1:
 * 
 * Input: "the sky is blue" Output: "blue is sky the"
 * 
 * Example 2:
 * 
 * Input: " hello world! " Output: "world! hello" Explanation: Your reversed
 * string should not contain leading or trailing spaces.
 * 
 * Example 3:
 * 
 * Input: "a good example" Output: "example good a" Explanation: You need to
 * reduce multiple spaces between two words to a single space in the reversed
 * string.
 * 
 * 
 * @author bramanarayan
 * @date Jul 15, 2020
 */
public class ReverseWordsInString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReverseWordsInString solution = new ReverseWordsInString();
		System.out.println(solution.reverseWords("the sky is blue"));
		System.out.println(solution.reverseWords("   hello world! "));

	}

	public String reverseWords(String s) {
		String[] tokens = s.split("\\s+");
		int n = tokens.length;
		StringBuilder sb = new StringBuilder();
		
		for(int i=n-1;i>=0;i--) {
			sb.append(tokens[i] + " ");
		}
		return sb.toString().trim();
	}

}
