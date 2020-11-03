package me.learn.personal.month1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * 
 * Title 56 : Given a collection of intervals, merge all overlapping intervals.
 * 
 *  Hint : Always think about the negative case first i.e if its not a merge ? then it will be easy
 *  Use stack as it helps is keeping track easily.
 * 
 * @author bramanarayan
 * @date May 19, 2020
 */
public class MergeIntervals {

	public static void main(String args[]) {
		MergeIntervals solution = new MergeIntervals();

		int[][] result = solution.merge(new int[][] { { 1, 3 }, { 8, 10 }, { 2, 6 }, { 15, 18 } });
		System.out.println(result);

		int[][] result2 = solution.merge(new int[][] { { 1, 4 }, { 5, 6 } });
		System.out.println(Arrays.toString(result2));
	}

	public int[][] merge(int[][] intervals) {
		int n = intervals.length;
		if (n < 2)
			return intervals;
		intervals = sortOnColumn(intervals);

		Stack<int[]> stack = new Stack<int[]>();
		stack.push(intervals[0]);
		// Start from the next interval and merge if necessary  
        for (int i = 1 ; i < n; i++)  
        {  
            // get interval from stack top  
            int[] top = stack.peek();  
    
            // if current interval is not overlapping with stack top,  
            // push it to the stack  
            if (top[1] < intervals[i][0])  
                stack.push(intervals[i]);  
    
            // Otherwise update the ending time of top if ending of current  
            // interval is more  
            else  {            		
                top[1] = Math.max(top[1], intervals[i][1]);  // take max of 2 end's 
                stack.pop();  
                stack.push(top);  
            }  
        }  
		
        // Get contents of stack to an 2d array
        int k = 0;
        int[][] result1 = new int[stack.size()][2];
        while(!stack.isEmpty()) {
        	int[] pair = stack.pop();
        	result1[k][0] = pair[0];
        	result1[k][1] = pair[1];
        	k++;
        }
		return result1;
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
