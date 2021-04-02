/**
 * 
 */
package me.learn.personal.month7;

import java.util.ArrayList;
import java.util.List;

/**
 * Title 936 :
 * 
 * Date : Mar 6, 2021
 * 
 * @author bramanarayan
 *
 */

/*
 * The idea is the same as the most upvoted post. Think reversely!
Let's take an example to illustrate.
Stamp = "abc", Target = "ababcbc`

    Target = ab***bc
    Target = ab*****
    Target = *******

We will go through the whole Target string to find if there exists any substring equals to Stamp. And then replace the whole substring with *. You can see in the step 1, we replace substring abc with ***. Then we keep doing the same thing. In the step 2, you will find we replace substring *bc to ***. * can match to any character because * will be override by the next stamp. Finally we get the result and output the reversed result. When # of stars equals to target.length(), we will return the result. If during one scan, we are not able to replace even one substring with *, directly return empty array.

Comments for two helper functions:
canReplace(char[] T, int p, char[] S) is used to check if any substring from Target is existing to be replaced with *.
doReplace(char[] T, int p, int len, int count) is used to replace the substring with * and return the total number of * we have now.
 */
public class StampingTheSequence {

	public int[] movesToStamp(String stamp, String target) {
		
		char[] stampChars = stamp.toCharArray();
		char[] targetChars = target.toCharArray();
		
		List<Integer> res = new ArrayList<>();
		
		boolean[] visited = new boolean[targetChars.length];
		
		int stars = 0;

		while (stars < targetChars.length) {
			boolean doneReplace = false;
			
			for (int i = 0; i <= targetChars.length - stampChars.length; i++) {
				if (!visited[i] && canReplace(targetChars, i, stampChars)) {
					
					stars = doReplace(targetChars, i, stampChars.length, stars); // replace all characters in the stamp window if its substring
					
					doneReplace = true;
					visited[i] = true;
					res.add(i);
					if (stars == targetChars.length) {
						break;
					}
				}
			}

			if (!doneReplace) {
				return new int[0];
			}
		}

		// convert List to int[]
		int[] resArray = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			resArray[i] = res.get(res.size() - i - 1);
		}
		return resArray;
	}

	//is used to check if any substring from Target is existing to be replaced with *.
	private boolean canReplace(char[] targetChars, int start, char[] stampChars) {
		for (int i = 0; i < stampChars.length; i++) {
			if (targetChars[i + start] != '*' && targetChars[i + start] != stampChars[i]) {
				return false;
			}
		}
		return true;
	}

	//is used to replace the substring with * and return the total number of * we have now.

	private int doReplace(char[] targetChars, int start, int stampLength, int count) {
		for (int i = 0; i < stampLength; i++) {
			if (targetChars[i + start] != '*') {
				targetChars[i + start] = '*';
				count++;
			}
		}
		return count;
	}

}
