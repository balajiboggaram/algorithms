/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title 171 :
 * 
 * Date : Dec 30, 2020
 * 
 * @author bramanarayan
 *
 */
public class ExcelSheetColumnNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Given the excel title , tell its number, like A -> 1, B -> 2 , Z -> 26, AA -> 27...
	
	public int titleToNumber(String s) {
			
		int n = s.length();
		int result = 0;
		for(int i = 0;i< n;i++) {
			// res = res * 26 + char (int)
			result = result * 26 + (int) (s.charAt(i) - 'A') + 1;
		}
		return result;
		
	}

}
