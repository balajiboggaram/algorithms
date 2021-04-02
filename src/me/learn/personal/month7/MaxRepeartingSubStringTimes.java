/**
 * 
 */
package me.learn.personal.month7;

/**
 * Title 1668 :
 * 
 * Date : Feb 25, 2021
 * 
 * @author bramanarayan
 *
 */
public class MaxRepeartingSubStringTimes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxRepeating(String sequence, String word) {
		if(!sequence.contains(word)) return 0;
		
		int k = 0;
		
		StringBuilder sb = new StringBuilder();
		sb.append(word);
		while(sequence.contains(sb.toString())) {
			k++;
			sb.append(word);
			
		}
		return k;
	}

}
