/**
 * 
 */
package me.learn.personal.month7;

import java.util.Stack;

/**
 * Title 388 :
 * 
 * Date : Feb 27, 2021
 * 
 * @author bramanarayan
 *
 */
public class LongestAbsoluteFilePath {

	public static int lengthLongestPath(String input) {
		Stack<Integer> stack = new Stack<>();
		stack.push(0); // Layer 0, dummy head
		int maxLen = 0;
		for (String s : input.split("\n")) {

			int layer = s.lastIndexOf("\t") + 1; // e.g. Layer 2 s: "\t\tsubsubdir1"

			// size of stack here is # of layers processed so far
			// if stack has more layers than my current layer, pop it
			while (layer < stack.size() - 1)
				stack.pop();

			// you got your parent now. , s - (# of /t) + 1 => gives actual length of path
			int length = stack.peek() + s.length() - layer + 1; // remove "\t\t..." add "\"

			if (layer == 0) // dir has no "\t" in the front
				length--;

			if (s.contains(".")) // cos file has a . always : assumption
				maxLen = Math.max(maxLen, length);
			else
				stack.push(length); // push the new layer length
		}
		return maxLen;
	}
}
