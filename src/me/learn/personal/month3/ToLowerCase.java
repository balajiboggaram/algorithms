/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title 709 :
 * 
 * Implement function ToLowerCase() that has a string parameter str, and returns
 * the same string in lowercase.
 * 
 * Example 1:
 * 
 * Input: "Hello" Output: "hello"
 * 
 * 
 * @author bramanarayan
 * @date Jul 19, 2020
 */
public class ToLowerCase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	// Lazy to solve this problem :)
	// basically - 
	// if the given char is in lower case ASCII range - 97 to blah blah, then just append as is. 
	// if the given char is upper case ASCII range - 65 to blah blah, then just add 97-65 = x 
	public String toLowerCase(String str) {
		return str.toLowerCase();
	}

}
