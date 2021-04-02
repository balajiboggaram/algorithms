/**
 * 
 */
package me.learn.personal.month7;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Title 759 :
 * 
 * Date : Mar 6, 2021
 * 
 * @author bramanarayan
 *
 */
public class EmployeeFreeTime {

	public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

		List<Interval> result = new ArrayList<>();

		// sort all the intervals based on the start time
		PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);
		schedule.forEach(e -> pq.addAll(e));

		int end = pq.poll().end; // get the first interval end
		
		
		while (!pq.isEmpty()) {
			
			// if its not intersecting, then you got some free time here
			if (end < pq.peek().start) {
				Interval interval = pq.poll();
				result.add(new Interval(end, interval.start));
				end = interval.end;
			} else {
				// no free time, try to take maximum end possible 
				end = Math.max(end, pq.poll().end);
			}
		}
		return result;
	}
}
