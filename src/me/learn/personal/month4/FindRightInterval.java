/**
 * 
 */
package me.learn.personal.month4;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Title 436 :
 * 
 * 
 * Given a set of intervals, for each of the interval i, check if there exists
 * an interval j whose start point is bigger than or equal to the end point of
 * the interval i, which can be called that j is on the "right" of i.
 * 
 * For any interval i, you need to store the minimum interval j's index, which
 * means that the interval j has the minimum start point to build the "right"
 * relationship for interval i. If the interval j doesn't exist, store -1 for
 * the interval i. Finally, you need output the stored value of each interval as
 * an array.
 * 
 * Note:
 * 
 * You may assume the interval's end point is always bigger than its start
 * point. You may assume none of these intervals have the same start point.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [ [1,2] ]
 * 
 * Output: [-1]
 * 
 * Explanation: There is only one interval in the collection, so it outputs -1.
 * 
 * 
 * @author bramanarayan
 * @date Aug 24, 2020
 */
public class FindRightInterval {

	 

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindRightInterval solution = new FindRightInterval();
		System.out.println(solution.findRightInterval(new int[][] {{3,4},{2,3},{1,2}}));
		
	}
	
	// put the intervals into map 
	// then try to get the highest entry - binary search
	// ENTRY = start -> <end, index>*
	public int[] findRightInterval(int[][] intervals) {

		int m = intervals.length;
		if (m <= 1)
			return new int[] { -1 };

		TreeMap<Integer, ArrayList<Tuple>> map = new TreeMap<>();

		for (int i = 0; i < m; i++) {
			map.computeIfAbsent(intervals[i][0], x -> new ArrayList<Tuple>()).add(new Tuple(intervals[i][1], i));
		}

		int[] result = new int[m];
		for (int i = 0; i < m; i++) {
			Entry<Integer, ArrayList<Tuple>> higherEntry = map.higherEntry(intervals[i][1]-1);
			if(higherEntry == null) {
				result[i] = -1;
			} else {
				result[i] = higherEntry.getValue().get(0).index; // get the minimum
			}
		}

		return result;

	}
	

class Tuple {
	int end;
	int index;

	public Tuple(int end, int index) {
		this.end = end;
		this.index = index;
	}
}

}

