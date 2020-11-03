/**
 * 
 */
package me.learn.personal.month4;

import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Title 352 :
 * 
 * Given a data stream input of non-negative integers a1, a2, ..., an, ...,
 * summarize the numbers seen so far as a list of disjoint intervals.
 * 
 * For example, suppose the integers from the data stream are 1, 3, 7, 2, 6,
 * ..., then the summary will be:
 * 
 * [1, 1] [1, 1], [3, 3] [1, 1], [3, 3], [7, 7] [1, 3], [7, 7] [1, 3], [6, 7]
 * 
 * 
 * @author bramanarayan
 * @date Aug 2, 2020
 */
public class DataStreamAsDisjointIntervals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SummaryRanges solution = new SummaryRanges();
		solution.addNum(1);
		solution.getIntervals();
		solution.addNum(3);
		solution.getIntervals();
		solution.addNum(2);
		solution.getIntervals();
		solution.addNum(4);
		solution.getIntervals();
		solution.addNum(7);
		solution.getIntervals();
	}

}

class SummaryRanges {

	TreeMap<Integer, Interval> m = new TreeMap<>();

	/** Initialize your data structure here. */
	public SummaryRanges() {

	}

	public void addNum(int val) {
		if (!m.containsKey(val - 1) && !m.containsKey(val + 1)) {
			m.put(val, new Interval(val, val));
		} else {
			// need to find start and end
			int start = val;
			while (m.lowerKey(start) != null && m.lowerKey(start) == start - 1) {
				start = start - 1;
			}

			int end = val;
			while (m.higherKey(end) != null && m.higherKey(end) == end + 1) {
				end = end + 1;
			}

			// update the intervals of all elements between start and end
			for (int i = start ; i <= end; i++) {
				m.put(i, new Interval(start, end));
			}

		}
	}

	public int[][] getIntervals() {
		// get all the unique intervals from map's values
		List<Interval> list = m.values().stream().distinct().collect(Collectors.toList());
		System.out.println(list.size());
		int n = list.size();
		int[][] res = new int[n][2];
		for (int i = 0; i < n; i++) {

			res[i][0] = list.get(i).start;
			res[i][1] = list.get(i).end;

			System.out.println("start: " + res[i][0]);
			System.out.println("end: " + res[i][1]);

		}
		System.out.println("-------");
		return res;
	}
}

class Interval {
	int start;
	int end;

	public Interval(int s, int e) {
		start = s;
		end = e;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + end;
		result = prime * result + start;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Interval other = (Interval) obj;
		if (end != other.end)
			return false;
		if (start != other.start)
			return false;
		return true;
	}
}