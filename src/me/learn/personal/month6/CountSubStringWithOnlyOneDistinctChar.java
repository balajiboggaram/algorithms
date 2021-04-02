/**
 * 
 */
package me.learn.personal.month6;

/**
 * Title 1180 :
 * 
 * Date : Jan 10, 2021
 * 
 * @author bramanarayan
 *
 */
public class CountSubStringWithOnlyOneDistinctChar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CountSubStringWithOnlyOneDistinctChar solution = new CountSubStringWithOnlyOneDistinctChar();
		System.out.println(solution.countLetters("aaaba"));
	}

	// count number of substring with only one distinct letter
	public int countLetters(String s) {
		
		if(s == null || s.length() == 0) return 0;
		
		int count = 1;
		int start = 0;
		int n = s.length();

		for (int i = 1; i < n; i++) {
			count++;
			if (s.charAt(i) == s.charAt(start)) {
				count += (i - start);
			} else {
				start = i;
			}
		}
		return count;

	}

}
