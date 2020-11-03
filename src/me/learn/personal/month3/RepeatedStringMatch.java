/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title 686 :
 * 
 * Given two strings A and B, find the minimum number of times A has to be
 * repeated such that B is a substring of it. If no such solution, return -1.
 * 
 * For example, with A = "abcd" and B = "cdabcdab".
 * 
 * Return 3, because by repeating A three times (“abcdabcdabcd”), B is a
 * substring of it; and B is not a substring of A repeated two times
 * ("abcdabcd").
 * 
 * Note: The length of A and B will be between 1 and 10000.
 * 
 * 
 * @author bramanarayan
 * @date Jun 30, 2020
 */
public class RepeatedStringMatch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RepeatedStringMatch solution = new RepeatedStringMatch();
	}
	
	
	// Nothing fancy here - Brute Force basically
	public int repeatedStringMatch(String a, String b) {
		
		int count = 1;
		StringBuilder sb = new StringBuilder();
		sb.append(a);
		while(sb.toString().indexOf(b) == -1) {
			
			// This indicates that there is no way we can get 'b' even if repeat 10000000.. times a
			// I am subtracting a.length cos we atleast need one repetition 
			if(sb.length() - a.length() > b.length()) {
				return -1;
			}
			
			sb.append(a);
			count++;
			
		}
		
		return count;
		
	}

}
