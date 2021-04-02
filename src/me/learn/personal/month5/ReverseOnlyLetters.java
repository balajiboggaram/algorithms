/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 917 :
 * 
 * Date : Dec 30, 2020
 * 
 * @author bramanarayan
 *
 */
public class ReverseOnlyLetters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Given a string S, return the "reversed" string where all characters that are
	// not a letter stay in the same place, and all letters reverse their positions.

	// keep two pointers and start swapping if its a character.
	public String reverseOnlyLetters(String s) {
		int i = 0;
		int j = s.length() - 1;
		StringBuilder sb  = new StringBuilder(s);
		while (i <= j) {
			while( i < j && !Character.isLetter(sb.charAt(i))) {
				i++;
			}
			
			while( j > i && !Character.isLetter(sb.charAt(j))) {
				j--;
			}
			char temp = sb.charAt(i);
			sb.setCharAt(i, sb.charAt(j));
			sb.setCharAt(j, temp);
			i++;
			j--;
		}
		
		return sb.toString();

	}

}
