/**
 * 
 */
package me.learn.personal.month7;

import java.util.Stack;

/**
 * Title 591 :
 * 
 * Date : Mar 6, 2021
 * 
 * @author bramanarayan
 *
 */
public class TagValidator {
	
	public boolean isValid(String input) {
	
		if (!input.startsWith("<"))
			return false;
		
		if (input.length() < 2 || !(input.charAt(1) >= 'A' && input.charAt(1) <= 'Z'))
			return false;

		Stack<String> stack = new Stack<>();
		String currentStr = "";
		
		// Iterator
		for (int i = 0; i < input.length(); i++) {
		
			currentStr += input.charAt(i);
			
			if (currentStr.startsWith("<![CDATA[")) {  // CDATA TAG
				if (currentStr.endsWith("]]>")) {
					currentStr = "";
				}
			} else if (currentStr.startsWith("</")) { // END TAG
				
				if (currentStr.endsWith(">")) {
					String tag = currentStr.substring(2, currentStr.length() - 1);
					
					if (stack.isEmpty() || !stack.peek().equals("<" + tag + ">")) // if stack top do not match START tag
						return false;
					
					stack.pop();
					currentStr = "";
					
					if (i < input.length() - 1 && stack.isEmpty())
						return false;
				}
			} else if (currentStr.startsWith("<")) {  // START TAG
				
				if (currentStr.endsWith(">")) {
					if (!valid_tag(currentStr))
						return false;
					stack.push(currentStr);
					currentStr = "";
				}
			} else {
				currentStr = ""; // TEXT WITHIN TAGS - so ignore, I dont care
			}
		}
		return stack.isEmpty() && currentStr.length() == 0;
	}

	// check the conditions if its a valid tag or not
	boolean valid_tag(String tag) {
		if (!tag.startsWith("<") || !tag.endsWith(">"))
			return false;
		if (tag.length() < 3 || tag.length() > 11)
			return false;
		for (int i = 1; i < tag.length() - 1; i++) {
			char c = tag.charAt(i);
			if (!Character.isUpperCase(c))
				return false;
		}
		return true;
	}

}
