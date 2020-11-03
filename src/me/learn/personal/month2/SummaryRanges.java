package me.learn.personal.month2;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Title 228 :  Given a sorted integer array without duplicates, return the summary of its ranges.

Example 1:

Input:  [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.

Example 2:

Input:  [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.

 * 
 * @author bramanarayan
 * @date May 24, 2020
 */
public class SummaryRanges {

	public static void main(String args[]) {
		SummaryRanges solution = new SummaryRanges();
		System.out.println(solution.summaryRanges(new int[] {0,1,2,4,5,7}));
		System.out.println(solution.summaryRanges(new int[] {0,2,3,4,6,8,9}));

	}

	public List<String> summaryRanges(int[] a) {

		int n = a.length;
		int end = 0, start = 0;
		List<String> result = new ArrayList<String>();

		if (n == 0)
			return result;

		if (n == 1) {
			result.add(String.valueOf(a[0]));
			return result;
		}

		while (end + 1 < n) {
			start = end;
			while (end + 1 < n && a[end + 1] == a[end] + 1) {
				end++;
			}
			if (start == end) {
				result.add(String.valueOf(a[start]));
			} else {
				result.add(String.format("%d->%d", a[start], a[end]));
			}

			end++;
			if (end == n - 1) {
				result.add(String.valueOf(a[end]));
				break;
			}
		}

		return result;
	}

}
