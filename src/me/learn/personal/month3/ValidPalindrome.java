/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title 125 :
 * 
 *  check if a given string is a valid palindrome or not
 * 
 * @author bramanarayan
 * @date Jul 2, 2020
 */
public class ValidPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ValidPalindrome solution = new ValidPalindrome();
		System.out.println(solution.isPalindrome("malayalam"));
		System.out.println(solution.isPalindrome("race a car"));
		System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(solution.isPalindrome("0P"));

	}
	
	// ONLY ASCII values - 
	// Ignore spaces
	public boolean isPalindrome(String s) {
		s = s.toLowerCase();
		int l = 0, high = s.length()-1;
		while(l < high) {
			
			if(!Character.isLetterOrDigit(s.charAt(l))) {
				l++;
				continue;
			}
			
			if(!Character.isLetterOrDigit(s.charAt(high))) {
				high--;
				continue;
			}
			
			if(s.charAt(l) != s.charAt(high))
				return false;
			
			l++;
			high--;
		}
		return true;
	}
	

}
