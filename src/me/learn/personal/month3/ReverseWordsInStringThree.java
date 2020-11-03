/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title 557 :
 * 
 * Given a string, you need to reverse the order of characters in each word
 * within a sentence while still preserving whitespace and initial word order.
 * 
 * Example 1:
 * 
 * Input: "Let's take LeetCode contest" Output: "s'teL ekat edoCteeL tsetnoc"
 * 
 * Note: In the string, each word is separated by single space and there will
 * not be any extra space in the string.
 * 
 * @author bramanarayan
 * @date Jul 19, 2020
 */
public class ReverseWordsInStringThree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReverseWordsInStringThree solution = new ReverseWordsInStringThree();
		System.out.println(solution.reverseWords("let's take LeetCode contest"));
	}

	public String reverseWords(String s) {
		String[] t = s.split("\\s+");
		StringBuilder sb = new StringBuilder();
		for(String temp : t) {
			StringBuilder tempSB = new StringBuilder();
			sb.append(tempSB.append(temp).reverse());
			sb.append(" ");
		}
		return sb.toString().trim();
	}
	
	
}
