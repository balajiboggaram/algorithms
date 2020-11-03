package me.learn.personal.month1;

/**
 * 
 * Title : Find the longest common prefix in a given list of Strings
 * 
 * 
 * NOTE: we can use prefix trees or linked lists too to solve this. 
 * 
 * @author bramanarayan
 * @date Apr 28, 2020
 */
public class LongestCommonPrefix {

	public static void main(String args[]) {

		LongestCommonPrefix solution = new LongestCommonPrefix();
		//System.out.println(solution.longestCommonPrefix(new String[] { "flower", "flow", "flight" }));
		//System.out.println(solution.longestCommonPrefix(new String[] { "dog", "racecar", "car" }));
		//System.out.println(solution.longestCommonPrefix(new String[] { "a" }));
		System.out.println(solution.longestCommonPrefix(new String[] { "aca","cba" }));

	}

	/*
	 * FINAL : From LC Discussion forum 
	 */
	public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1 || strs == null) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        //find the shortest String
        int shortest = 0;
        int len = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            int curLen = strs[i].length();
            if (curLen < len) {
                len = curLen;
                shortest = i;
            }
        }
        //find the longest common prefix
        String sub = strs[shortest];
        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(sub) != 0) {
                sub = sub.substring(0, sub.length()-1);
            }
        } 
        return sub;
    }
	
	public String longestCommonPrefixMy(String[] strs) {

		if (strs == null) {
			return "";
		}
		if (strs.length == 0) {
			return "";
		}

		// Find the shortest String length
		int minLength = Integer.MAX_VALUE;
		for (String s : strs) {
			if (s.length() < minLength) {
				minLength = s.length();
			}
		}

		// We need to check until minLength only until the shortest string length for
		// common prefix.
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < minLength; i++) {
			char c = strs[0].charAt(i);
			boolean isSame = true;
			for (String s : strs) {
				if (s.charAt(i) != c) {
					isSame = false;
				}
			}
			if (!isSame) {
				sb.append(c);
			} else {
				break;
			}
		}
		System.out.println(sb.toString());		
		return sb.toString();
	}
}

// https://leetcode.com/problems/longest-common-prefix/discuss/7139/My-1ms-Java-solution Good one too.
