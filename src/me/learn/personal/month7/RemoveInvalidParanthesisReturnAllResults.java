/**
* 
*/
package me.learn.personal.month7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Title 301 :
 * 
 * Date : Mar 6, 2021
 * 
 * @author bramanarayan
 *
 */
public class RemoveInvalidParanthesisReturnAllResults {

	public List<String> removeInvalidParentheses(String s) {
		
		int left = 0, right = 0, count = 0;

		// how many excess left or right parantheses are there ?
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				left++;
			} else if (s.charAt(i) == ')') {
				if (left > 0)
					left--;
				else
					right++;
			}
		}

		// Find how many min. no. of changes are required
		count = left + right;

		Set<String> res = new HashSet<>();

		dfs(s, 0, res, new StringBuilder(""), count);

		return new ArrayList<String>(res);
	}

	// Keep removing character count, 
	public void dfs(String s, int i, Set<String> resultSet, StringBuilder sb, int removeCount) {

		if (removeCount < 0) {
			return;
		}

		// if index reaches at end and all extra are removed, then we are good.
		if (i == s.length()) {
			if (removeCount == 0) {
				if (isValid(sb.toString())) {
					resultSet.add(sb.toString());
				}
			}
			return;
		}

		char c = s.charAt(i);
		int len = sb.length();

		if (c == '(' || c == ')') {
			dfs(s, i + 1, resultSet, sb, removeCount - 1); // not use ')''('
			dfs(s, i + 1, resultSet, sb.append(c), removeCount); // use
		} else {
			dfs(s, i + 1, resultSet, sb.append(c), removeCount);
		}

		sb.setLength(len);
	}

	boolean isValid(String s) {
		int count = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(')
				count++;
			if (c == ')' && count-- == 0)
				return false;
		}

		return count == 0;
	}
}
