/**
 * 
 */
package me.learn.personal.month7;

/**
 * Title 1109 : 
 * 
 * Date : Feb 27, 2021
 * 
 * @author bramanarayan
 *
 */
public class CorporateFlightBookings {

	public int[] corpFlightBookings(int[][] bookings, int n) {
        // prefix sum
        int[] preSum = new int[n];
        for (int[] b : bookings) {
        	
            preSum[b[0] - 1] += b[2];
            
            if (b[1] < n) {
                preSum[b[1]] -= b[2];
            }
        }
        for (int i = 1; i < n; i++) {
            preSum[i] += preSum[i - 1];
        }
        return preSum;
    }
	
}
