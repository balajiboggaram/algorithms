/**
 * 
 */
package me.learn.personal.month4;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Title 435 :
 * 
 * Date : Jan 5, 2021
 * 
 * @author bramanarayan
 *
 */
public class EraseOverlappingIntervalCount {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// sort on end -> then followed by start
	public int eraseOverlapIntervals(int[][] intervals) {

		if (intervals == null || intervals.length == 0)
			return 0;

		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] != o2[1])
					return o1[1] - o2[1]; // first sort by end , 
				return o2[0] - o1[0]; // second sort by start
			}
		});// sort based on end, if end is equal then sort on biggest start first

		int end = Integer.MIN_VALUE;
		int count = 0;

		for (int i = 0; i < intervals.length; i++) {

			// if its non overlapping, update the new end
			if (intervals[i][0] >= end) {
				end = intervals[i][1];
			} else {
				// its overlapping
				count++;
			}

		}
		return count;
	}

}
