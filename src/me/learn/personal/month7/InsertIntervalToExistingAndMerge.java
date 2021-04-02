/**
 * 
 */
package me.learn.personal.month7;

import java.util.ArrayList;
import java.util.List;

/**
 * Title 57 :
 * 
 * Date : Feb 26, 2021
 * 
 * @author bramanarayan
 *
 */
public class InsertIntervalToExistingAndMerge {

	// ADD A NEW INTERVAL TO MERGE IN EXISTING INTERVALS
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

		List<Interval> result = new ArrayList<>();
		int i = 0;
		int low = newInterval.start;
		int high = newInterval.end;

		// Disjoint interval, so add the result
		while (i < intervals.size() && intervals.get(i).end < low) {
			result.add(intervals.get(i));
			i++;
		}

		// obvious that its a overlapping interval
		while (i < intervals.size() && intervals.get(i).start <= high) {
			low = Math.min(low, intervals.get(i).start);
			high = Math.max(high, intervals.get(i).end);
			i++;
		}
		result.add(new Interval(low, high));

		// after overalapping, just copy the rest of other intervals
		while (i < intervals.size())
			result.add(intervals.get(i++));
		return result;
	}

}

class Interval {

	public Interval(int start2, int end2) {
		this.start = start2;
		this.end = end2;
	}

	int start;
	int end;
}
