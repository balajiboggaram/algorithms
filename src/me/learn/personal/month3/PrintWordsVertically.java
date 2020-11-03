/**
 * 
 */
package me.learn.personal.month3;

import java.util.ArrayList;
import java.util.List;

/**
 * Title 1324 :
 * 
 * Given a string s. Return all the words vertically in the same order in which
 * they appear in s. Words are returned as a list of strings, complete with
 * spaces when is necessary. (Trailing spaces are not allowed). Each word would
 * be put on only one column and that in one column there will be only one word.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "HOW ARE YOU" Output: ["HAY","ORO","WEU"] Explanation: Each word
 * is printed vertically. "HAY" "ORO" "WEU"
 * 
 * Example 2:
 * 
 * Input: s = "TO BE OR NOT TO BE" Output: ["TBONTB","OEROOE"," T"] Explanation:
 * Trailing spaces is not allowed. "TBONTB" "OEROOE" " T"
 * 
 * Example 3:
 * 
 * Input: s = "CONTEST IS COMING" Output: ["CIC","OSO","N M","T I","E N","S
 * G","T"]
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 200 s contains only upper case English letters.
 * 
 * @author bramanarayan
 * @date Jul 1, 2020
 */
public class PrintWordsVertically {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrintWordsVertically solution = new PrintWordsVertically();
		System.out.println(solution.printVertically("TO BE OR NOT TO BE"));
	}

	
	// Split the sentence
	// Compute the max length of words
	// now... run with StringBuilder
	public List<String> printVertically(String s) {
		
		// Split on white space
		String[] tokens = s.split("\\s+");
		
		// find max
		int max = 0;
		for(int i = 0;i< tokens.length;i++) {
			max = Math.max(max, tokens[i].length());
		}
		
		// now - run
		List<String> result = new ArrayList<String>();
		for(int j = 0;j< max;j++) {
			StringBuilder sb = new StringBuilder();
			
			for(int i =0; i < tokens.length;i++) {
				if(tokens[i].length() > j) {
					sb.append(tokens[i].charAt(j));
				} else {
					// here append a space
					sb.append(" ");
				}
			}
			result.add(sb.toString().replaceAll("\\s+$", ""));
		}
		return result;
	}

}
