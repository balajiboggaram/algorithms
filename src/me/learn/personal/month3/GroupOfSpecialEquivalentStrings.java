/**
 * 
 */
package me.learn.personal.month3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Title 893 :
 * 
 * You are given an array A of strings.

A move onto S consists of swapping any two even indexed characters of S, or any two odd indexed characters of S.

Two strings S and T are special-equivalent if after any number of moves onto S, S == T.

For example, S = "zzxy" and T = "xyzz" are special-equivalent because we may make the moves "zzxy" -> "xzzy" -> "xyzz" that swap S[0] and S[2], then S[1] and S[3].

Now, a group of special-equivalent strings from A is a non-empty subset of A such that:

    Every pair of strings in the group are special equivalent, and;
    The group is the largest size possible (ie., there isn't a string S not in the group such that S is special equivalent to every string in the group)

Return the number of groups of special-equivalent strings from A.
 

Example 1:

Input: ["abcd","cdab","cbad","xyzz","zzxy","zzyx"]
Output: 3
Explanation: 
One group is ["abcd", "cdab", "cbad"], since they are all pairwise special equivalent, and none of the other strings are all pairwise special equivalent to these.

The other two groups are ["xyzz", "zzxy"] and ["zzyx"].  Note that in particular, "zzxy" is not special equivalent to "zzyx".

 * 
 * @author bramanarayan
 * @date Jul 15, 2020
 */
public class GroupOfSpecialEquivalentStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numSpecialEquivGroups(String[] a) {
		
		Set<String> seen = new HashSet<String>();
		for(String s : a) {
			int[] count = new int[52]; // 26 uppercase + 26 lowercase
			
			for(int i = 0;i < s.length(); i++) {
				count[s.charAt(i)-'a' + 26 * (i % 2)]++;
			}
			
			seen.add(Arrays.toString(count));
		}
		return seen.size();
	}
}
