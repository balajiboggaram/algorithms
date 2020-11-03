/**
 * 
 */
package me.learn.personal.month3;

import java.util.HashSet;
import java.util.Set;

/**
 * Title 681 :
 * 
 * Given a time represented in the format "HH:MM", form the next closest time by
 * reusing the current digits. There is no limit on how many times a digit can
 * be reused.
 * 
 * You may assume the given input string is always valid. For example, "01:34",
 * "12:09" are all valid. "1:34", "12:9" are all invalid.
 * 
 * Example 1:
 * 
 * Input: "19:34" Output: "19:39" Explanation: The next closest time choosing
 * from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later. It is not
 * 19:33, because this occurs 23 hours and 59 minutes later.
 * 
 * Example 2:
 * 
 * Input: "23:59" Output: "22:22" Explanation: The next closest time choosing
 * from digits 2, 3, 5, 9, is 22:22. It may be assumed that the returned time is
 * next day's time since it is smaller than the input time numerically.
 * 
 * 
 * @author bramanarayan
 * @date Jul 21, 2020
 */
public class NextClosestTime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NextClosestTime solution = new NextClosestTime();
		System.out.println(solution.nextClosestTime("19:34"));
		System.out.println(solution.nextClosestTime("19:11"));
		System.out.println(solution.nextClosestTime("01:32"));
		System.out.println(solution.nextClosestTime("20:56"));

	}

	public String nextClosestTime(String time) {

		String[] hhMM = time.split(":");
		int hour = Integer.parseInt(hhMM[0]);
		int min = Integer.parseInt(hhMM[1]);
		int[] curTime = new int[] { hour, min };

		// 19:35
		Set<Integer> required = new HashSet<Integer>();
		required.add(hour % 10); // 9
		required.add(hour / 10); // 1
		required.add(min % 10); // 5
		required.add(min / 10); // 3

		boolean nextFound = false;
		int[] next = new int[2];
		while (!nextFound) {
			next = nextTime(curTime);

			Set<Integer> formed = new HashSet<Integer>();
			formed.add(next[0] % 10);
			formed.add(next[0] / 10);
			formed.add(next[1] % 10);
			formed.add(next[1] / 10);

			if (required.containsAll(formed))
				break;
			else {
				curTime = next;
			}

		}

		String hourPart = next[0] <= 9 ? "0" + next[0] : String.valueOf(next[0]);
		String minPart = next[1] <= 9 ? "0" + next[1] : String.valueOf(next[1]);

		return hourPart + ":" + minPart;

	}

	// get the next time
	int[] nextTime(int[] time) {
		int hour = time[0];
		int min = time[1];
		min++;
		if (min == 60) {
			min = 0;
			hour++;
			if (hour == 24) {
				hour = 0;
			}
		} 
		int[] res = new int[2];

		res[0] = hour;
		res[1] = min;
		return res;
	}
}
