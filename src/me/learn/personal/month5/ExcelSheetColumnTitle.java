package me.learn.personal.month5;

/**
 * 
 * Title 168:
 * 
 * Date : Dec 30, 2020
 * 
 * @author bramanarayan
 *
 */
public class ExcelSheetColumnTitle {

	public static void main(String args[]) {
		ExcelSheetColumnTitle solution = new ExcelSheetColumnTitle();
		System.out.println(solution.convertToTitle(52));
	}

	// Given a number, get the title of excel column
	// Also see the pairing problem : 171
	public String convertToTitle(int n) {

		StringBuilder sb = new StringBuilder();
		while (n != 0) {

			int temp = (n - 1) % 26; // n-1 is important here

			sb.append((char) ('A' + temp));

			n = (n - 1) / 26; // here too
		}
		return sb.reverse().toString();

	}

}
