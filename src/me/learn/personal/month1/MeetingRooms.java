package me.learn.personal.month1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * Title 252 : Given an array of meeting time intervals consisting of start and
 * end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend
 * all meetings.
 * 
 * @author bramanarayan
 * @date May 19, 2020
 */
public class MeetingRooms {

	public static void main(String args[]) {
		MeetingRooms solution = new MeetingRooms();
		System.out.println(solution.canAttendMeetings(new int[][] { { 1, 3 }, { 8, 10 }, { 2, 6 }, { 15, 18 } }));
		System.out.println(solution.canAttendMeetings(new int[][] { { 1, 3 }, { 8, 10 }, { 5, 6 }, { 15, 18 } }));

	}

	public boolean canAttendMeetings(int[][] intervals) {
		sortOnColumn(intervals);
		int n = intervals.length;
		if (n < 2)
			return true;

		for (int i = 1; i < n; i++) {
			if (intervals[i][0] >= intervals[i - 1][1]) {
				// there is no overlap, so lets continue
				continue;
			} else {
				// a merge occurred
				return false;
			}
		}
		return true; // if there is no overlap at all
	}

	private int[][] sortOnColumn(int[][] a) {

		Arrays.sort(a, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}

		});
		for (final int[] s : a) {
			System.out.println(s[0] + " " + s[1]);
		}
		return a;
	}

}
