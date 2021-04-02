/**
 * 
 */
package me.learn.personal.month5;

import java.util.Arrays;
import java.util.Comparator;


/**
 * Title 1235 :
 * 
 * Date : Dec 23, 2020
 * 
 * @author bramanarayan
 *
 */
public class MaxProfitInJobScheduling {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Sort based on their finish time
	public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

		int n = startTime.length;

		Job[] jobs = new Job[n];
		for (int i = 0; i < n; i++) {
			jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
		}

		// sort based on their end time
		Arrays.sort(jobs, Comparator.comparingInt(a -> a.end));

		int[] dp = new int[n];
		dp[0] = jobs[0].profit;
		for (int i = 1; i < n; i++) {
			int j = search(jobs, i); // get leftmost non colliding job here [kind of j loop in LIS]
			int iProfit = jobs[i].profit;
            int includeJobProfit = 0;
			if(j != -1) {
					includeJobProfit =  iProfit + dp[j]; // excluding this job and including this job
		
			}
			// should I pick i job or do not pick i ( i.e i-1 profit)
            dp[i] = Math.max(dp[i-1], includeJobProfit);
			
		}
		
		return dp[n-1];

	}

	// get first non collinding job - binary
	 private int search(Job[] jobs, int index) {
	        int start = 0, end = index - 1;
	        while (start <= end) {
	            int mid = (start + end) / 2;
	            if (jobs[mid].end <= jobs[index].start) {
	                if (jobs[mid + 1].end <= jobs[index].start)
	                    start = mid + 1;
	                else
	                    return mid;
	            }
	            else
	                end = mid - 1;
	        }
	        return -1;
	    }
	
	// Get the first non colliding job from right to left
	private int searchNonCollide(Job[] jobs, int i) {
	
		for(int j = i-1;j>=0;j--) {
			if(jobs[j].end <= jobs[i].start) {
				return j;
			}
		}
		return -1;
	}

}

class Job {
	int start;

	public Job(int start, int end, int profit) {
		this.start = start;
		this.end = end;
		this.profit = profit;
	}

	int end;
	int profit;
}
