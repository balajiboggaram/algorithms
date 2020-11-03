/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title 680 :
 * 
 * Given a non-empty string s, you may delete at most one character. Judge
 * whether you can make it a palindrome.
 * 
 * Example 1:
 * 
 * Input: "aba" Output: True
 * 
 * Example 2:
 * 
 * Input: "abca" Output: True Explanation: You could delete the character 'c'.
 * 
 * Note:
 * 
 * The string will only contain lowercase characters a-z. The maximum length of
 * the string is 50000.
 * 
 * 
 * @author bramanarayan
 * @date Jul 2, 2020
 */
public class ValidPalindromeTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ValidPalindromeTwo solution = new ValidPalindromeTwo();
		System.out.println(solution.validPalindrome("aba"));
		System.out.println(solution.validPalindrome("abca"));
		System.out.println(solution.validPalindrome("abc"));

	}
	
	
	public boolean validPalindrome(String s) {
		int l = 0;
		int r = s.length() - 1;
		while (l <= r) {
			if (s.charAt(l) == s.charAt(r)) {
				l++;
				r--;
			} else {
				// not equal then check by removing on left or the right side
				return isPalindrome(s, l, r - 1) || isPalindrome(s, l + 1, r);
			}
		}
		return true;
	}
    
	// THis is needed as - you already noted one difference. 
	// You cannot have another diff - so this method checks it
    private boolean isPalindrome(String str, int low, int high){
        while (low <= high){
            if (str.charAt(low) == str.charAt(high)){
                low++;
                high--;
            }
            else
                return false;
        }
        
        return true;
    }


}
