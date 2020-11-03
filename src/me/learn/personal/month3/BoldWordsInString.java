/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title 758 :
 * 
 *  Given a set of keywords words and a string S, make all appearances of all keywords in S bold. Any letters between <b> and </b> tags become bold.

The returned string should use the least number of tags possible, and of course the tags should form a valid combination.

For example, given that words = ["ab", "bc"] and S = "aabcd", we should return "a<b>abc</b>d". Note that returning "a<b>a<b>b</b>c</b>d" would use more tags, so it is incorrect.

Constraints:

    words has length in range [0, 50].
    words[i] has length in range [1, 10].
    S has length in range [0, 500].
    All characters in words[i] and S are lowercase letters.

 * 
 * @author bramanarayan
 * @date Jun 30, 2020
 */
public class BoldWordsInString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BoldWordsInString solution  = new BoldWordsInString();
		System.out.println(solution.boldWords(new String[] {"abc","123"}, "abcxyz123"));
	}

	
	// A little tickie thing to catch an idea on maintaining a boolean 
	public String boldWords(String[] words, String s) {
		int n = s.length();
		
		// To mark if these are embedded within the bold tags or not.
		boolean[] boldMarker = new boolean[n];
		
		
		// at every index in s. keep checking if we can find any word in the dictionary
		int end = 0;
		
		for(int i = 0; i< n;i++) {
			for(int j=0;j< words.length; j++) {
				
				if(s.startsWith(words[j],i)) { // check if word exists from index i 
					end = Math.max(end, i + words[j].length());
				}
				
				if(i < end) {
					boldMarker[i]= true; // this is already covered in substring
				}
			}
		}
		
		//Once marking is complete, now - lets build the StringBuilder
		
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while(i < n) {
			
			
			// If its not within bold, then just keep appending it.
			if(!boldMarker[i]) {
				sb.append(s.charAt(i));
				i++;
				continue;
			} else {
				
				sb.append("<b>"); // open bold tag here
				
				// try to grab all the consecutive marked bold so that we can 
				// decorate with bold tags around it.
				int j =i;
				while(j < n  && boldMarker[j]) { 				
					sb.append(s.charAt(j));
					j++;
				}
				sb.append("</b>"); // close bold tag here
				
				i=j;
			}
		}
		return sb.toString();
		
	}

}
