/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 796 :
 * 
 * Date : Dec 31, 2020
 * 
 * @author bramanarayan
 *
 */
public class RotateStringExists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Can you get String B after some circular right shifts ? 
	public boolean rotateString(String A, String B) {
		if(A == null || B == null) return false;
		if(A.length() > B.length()) return false; // This is needed because we can decrease length of A to get B
		return (A + A).contains(B);

	}

}
