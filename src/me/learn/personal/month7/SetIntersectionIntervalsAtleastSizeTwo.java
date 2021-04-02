/**
 * 
 */
package me.learn.personal.month7;

import java.util.Arrays;

/**
 * Title 757 : 
 * 
 * Date : Feb 26, 2021
 * 
 * @author bramanarayan
 *
 */
public class SetIntersectionIntervalsAtleastSizeTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] != b[1] ? a[1]-b[1] : b[0]-a[0]); // java8 functional way of sort
        
        
        //[smax --- max] [start ---- end]
        // check if start Is less than smax -> then you have two points overlap. you already accounted to count in prev point so continue
        // check if start is less than max -> then you have one point overlap, so add to count.
        // if no point overlapped, then you need to add 2 
        
        int secondMax = -2, max = -1, cnt = 0; // pay attention to intial values of sndMax and max
        
        for (int[] interval: intervals) {
            
        	int start = interval[0];
            int end = interval[1]; // check the validity before processing
            
            if (start <= secondMax ) { // two point overlapped, already accounted
                continue;
            } else if (start <= max) { // one point overlapped
                cnt += 1;
                secondMax = max;
                max = end; 
            } else { // no point overlapped
                cnt += 2;
                secondMax = end - 1;
                max = end;
            }
        }
        return cnt;
}

}
