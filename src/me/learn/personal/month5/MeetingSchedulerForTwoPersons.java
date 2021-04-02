/**
 * 
 */
package me.learn.personal.month5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Title 1229 :
 * 
 * Date : Jan 2, 2021
 * 
 * @author bramanarayan
 *
 */
public class MeetingSchedulerForTwoPersons {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MeetingSchedulerForTwoPersons solution = new MeetingSchedulerForTwoPersons();
		System.out.println(solution.minAvailableDuration(new int[][] { { 0, 1000000000 } },
				new int[][] { { 0, 1000000000 } }, 1000000));
	}

	public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {

		int i = 0;
		int j = 0;
		int m = slots1.length;
		int n = slots2.length;

		Arrays.sort(slots1, (a, b) -> a[0] - b[0]); // sort increasing by start time
		Arrays.sort(slots2, (a, b) -> a[0] - b[0]); // sort increasing by start time

		List<Integer> result = new ArrayList<Integer>();

		// max of start - min of end template
		while (i < m && j < n) {
			int start1 = slots1[i][0];
			int end1 = slots1[i][1];

			int start2 = slots2[j][0];
			int end2 = slots2[j][1];

			int diff = Math.min(end1, end2) - Math.max(start2, start1);
			if (diff >= duration) {
				return Arrays.asList(Math.max(start2, start1), Math.max(start2, start1) + duration);
			}

			if (end1 < end2) {
				i++;
			} else if (end1 > end2) {
				j++;
			} else {
				i++;
				j++;
			}
		}
		return result;
	}
}
