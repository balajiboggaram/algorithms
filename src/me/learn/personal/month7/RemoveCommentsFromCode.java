/**
 * 
 */
package me.learn.personal.month7;

import java.util.ArrayList;
import java.util.List;

/**
 * Title 722 :
 * 
 * Date : Feb 26, 2021
 * 
 * @author bramanarayan
 *
 */
public class RemoveCommentsFromCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// ALways try to keep track of /* or */ or //
	public List<String> removeComments(String[] source) {
		
		List<String> code = new ArrayList<>();
		
		boolean commentBlock = false; // to track whether its a comment block or not
		
		StringBuilder sb = new StringBuilder();

		for (String line : source) {
			
			int i = 0;
			char[] codeLine = line.toCharArray();
			
			if (!commentBlock)
				sb = new StringBuilder();
			
			// PROCESS SINGLE LINE
			while (i < codeLine.length) {
			
				// start of the comment block /*
				if (!commentBlock && i + 1 < codeLine.length && codeLine[i] == '/' && codeLine[i + 1] == '*') {
					commentBlock = true;
					i += 2;
					
					// end of comment block */
				} else if (commentBlock && i + 1 < codeLine.length && codeLine[i] == '*' && codeLine[i + 1] == '/') {
					commentBlock = false;
					i += 2;
					
					// single line comment, so ignore whole //
				} else if (!commentBlock && i + 1 < codeLine.length && codeLine[i] == '/' && codeLine[i + 1] == '/') {
					break;
					
					// if its not a comment block, then its code, so add to our result
				} else if (!commentBlock) {
					sb.append(codeLine[i]);
					i++;
				} else {
					i++;
				}
			}

			
			if (!commentBlock && sb.length() > 0)
				code.add(sb.toString());
		}

		return code;
	}

}
