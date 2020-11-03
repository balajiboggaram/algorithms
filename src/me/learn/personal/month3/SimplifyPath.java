/**
 * 
 */
package me.learn.personal.month3;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Title 71 :
 * 
 *  iven an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.

In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level.

Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names. The last directory name (if it exists) must not end with a trailing /. Also, the canonical path must be the shortest string representing the absolute path.

 

Example 1:

Input: "/home/"
Output: "/home"
Explanation: Note that there is no trailing slash after the last directory name.

Example 2:

Input: "/../"
Output: "/"
Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.

Example 3:

Input: "/home//foo/"
Output: "/home/foo"
Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.

Example 4:

Input: "/a/./b/../../c/"
Output: "/c"

Example 5:

Input: "/a/../../b/../c//.//"
Output: "/c"

Example 6:

Input: "/a//b////c/d//././/.."
Output: "/a/b/c"

 * 
 * @author bramanarayan
 * @date Jun 29, 2020
 */
public class SimplifyPath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimplifyPath solution = new SimplifyPath();
		System.out.println(solution.simplifyPath("/home/"));
		System.out.println(solution.simplifyPath("/home//foo/"));
		System.out.println(solution.simplifyPath("/a/./b/../../c/"));
		System.out.println(solution.simplifyPath("/a//b////c/d//././/../"));

		System.out.println(solution.simplifyPath("/a/../../b/../c//.//"));

	}

	public String simplifyPath(String s) {

		Deque<String> st = new LinkedList<String>();
		
		String[] tokens = s.split("/"); // CATCH
		
		for (int i = 0; i < tokens.length; i++) {
			String next = tokens[i];
			if (next.equals("..")) {
				if(!st.isEmpty()) {
					st.removeLast();
				}
			} else if (next.equals(".") || next.isEmpty()) {
				// DO nothing here - its current directory
			} else {
				st.addLast(next);
			}
		}
	
		// IF the stack is empty, then its root.
		if(st.isEmpty()) {
			return "/";
		}
		
		// Now, pop the stack and return
		StringBuilder sb = new StringBuilder();
		while(!st.isEmpty()) {
			sb.append("/");
			sb.append(st.removeFirst());
		}
		return sb.toString();

	}
}
